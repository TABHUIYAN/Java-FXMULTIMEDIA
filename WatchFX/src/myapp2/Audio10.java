/*
 * Audio class
 * Audio screen
 */
package myapp2;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author BHUIYAN
 */
public class Audio10 extends Parent{
    //Layout
    private BorderPane borderPane;
    //UI nodes 
    private ImageView background;
    private Label topLbl;
    private Button btnForward;
    private Button btnBack;
    private Label bottomLbl;
    private Button playButton;
    private Button stopButton;
    private Button btnBackMenu;
    private Circle circle;
    //Vertical Boxes To hold UI element
    private HBox topHb;
    private VBox leftVb;
    private VBox rightVb;
    private VBox bottomVb;
    // JavaFX Animation view
    private VBox midVb;
    //audio..
    private XYChart.Data<String,Number>[]series1Data;
    private BarChart<String,Number> bc;
    private XYChart.Series<String,Number> series1;
    private AudioSpectrumListener audioSpectrumListener;
    private static final String AUDIO_URI = System.getProperty("demo.audio.url","http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv");
    private static MediaPlayer audioMediaPlayer;
    private static final boolean PLAY_AUDIO = Boolean.parseBoolean(System.getProperty("demo.play.audio","true"));
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
    // Constructor
    public Audio10()
    { 
    createNodesForUI();
    configureUINodes();
    addNodesToLayout();
    }
  
    // create the nodes objects for the UI
    private void createNodesForUI() {
    // layout object
    borderPane=new BorderPane();
    borderPane.setPrefSize(980,600);
    play();
    borderPane.setStyle("-fx-background-color:tan");
    audioSpectrumListener = (double timestamp, double duration, float[] magnitudes, float[] phases) -> {
        for (int i = 0; i < series1Data.length; i++) {
        series1Data[i].setYValue(magnitudes[i] + 60);
    }
    };
    
    //setup UI elements
    topLbl = new Label(" Watch Elearning");
    btnForward = new Button("Forward");
    btnBack = new Button("Back");
    btnBackMenu=new Button("Back Menu");
    btnForward.setPrefSize(80,20);
    btnBack.setPrefSize(80,20);
    bottomLbl = new Label("Designed by TAHMINA BHUIYAN(Audio)");
   
    //NEW VBox and HBox to hold UI elements
    topHb=new HBox();
    leftVb = new VBox(5);
    rightVb = new VBox();
    bottomVb = new VBox();
    midVb = new VBox();
    // Button onClick listener
    btnForward.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(4);
    });
    btnBack.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(6);
    });
    btnBackMenu.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(2);
    });
    }
    public void play() 
    {
    this.startAudio();
    }
    public void stop() 
    {
    this.stopAudio();
    }
    protected BarChart<String,Number>createChart(){
    // Bar charts UI 
    xAxis = new CategoryAxis();
    yAxis = new NumberAxis(0,50,10);
    bc = new BarChart<>(xAxis,yAxis);
    bc.setId("barAudioDemo");
    bc.setLegendVisible(false);
    bc.setAnimated(false);
    bc.setBarGap(0);
    bc.setCategoryGap(1);
    bc.setVerticalGridLinesVisible(false);
    // setup chart
    bc.setTitle("Live Audio Spectrum Data");
    xAxis.setLabel("Frequency Bands");
    yAxis.setLabel("Magnitudes");
    yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,null,"dB"));
    // add starting data
    series1 = new XYChart.Series<>();
    series1.setName("Data Series 1");
    //noinspection unchecked
    series1Data = new XYChart.Data[128];
    String[] categories = new String[128];
    for (int i=0; i<series1Data.length; i++) {
    categories[i] = Integer.toString(i+1);
    series1Data[i] = new XYChart.Data<>(categories[i],50);
    series1.getData().add(series1Data[i]);
    }
    bc.getData().add(series1);
    return bc;
    }
    private void startAudio() {
        if (PLAY_AUDIO) {
        getAudioMediaPlayer().setAudioSpectrumListener(audioSpectrumListener);
        getAudioMediaPlayer().play();
        }
    }
    private void stopAudio() {
        if (getAudioMediaPlayer().getAudioSpectrumListener() == audioSpectrumListener) {
            getAudioMediaPlayer().pause();
        }
    }
    private static MediaPlayer getAudioMediaPlayer() {
        if (audioMediaPlayer == null) {
        Media audioMedia = new Media(AUDIO_URI);
        audioMediaPlayer = new MediaPlayer(audioMedia);
        }
        return audioMediaPlayer;
    }
    private void configureUINodes() {
   //set fonts for all label using css
    topLbl.setFont(Font.font("Verdana",FontWeight.BOLD,16)); 
    topLbl.setAlignment(Pos.TOP_RIGHT);
    bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 28));
     
    //configure the Boxes
    topHb.getChildren().addAll(topLbl);
    topHb.setPadding(new Insets(15,12,15,12));
    topHb.setSpacing(5);
    topHb.setStyle("-fx-border-style:solid;"
                   + "-fx-background-color:#ffbc;fx-border-color:black");
    //left design
    leftVb.getChildren().addAll(btnBackMenu,btnBack);
    leftVb.setStyle("-fx-background-color:#ffbcdf");
    leftVb.setAlignment(Pos.CENTER);      
    rightVb.getChildren().add(btnForward);
    rightVb.setStyle("-fx-background-color:#ffbcdf");
    rightVb.setAlignment(Pos.CENTER);       
    bottomVb.getChildren().add(bottomLbl);
    bottomVb.setAlignment(Pos.CENTER);
    bottomVb.setStyle("-fx-border-stylel:solid;-fx-background-color:#ffbc; -fx-border-width:1pt; -fx-border-color:black;");  
    
    midVb.getChildren().addAll(createChart());
    midVb.setAlignment(Pos.CENTER);
    }

    private void addNodesToLayout() {
    // Add VBoxes to Pane
    borderPane.setTop(topHb);
    borderPane.setLeft(leftVb);
    borderPane.setRight(rightVb);
    borderPane.setBottom(bottomVb);
    borderPane.setCenter(midVb);
        
    getChildren().addAll(borderPane);
    }
}
