/*
 * class Watch Video
 * video Screen containig video 
 */
package myapp2;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author BHUIYAN
 */
public class WatchVideo extends Parent{
    //layout
    private BorderPane borderPane;
    
    //UI Nodes
    private Label topLbl;
    private Button btnForward;
    private Button btnBack;
    private Label bottomLbl;
    private Button btnMenu;
    private Button btnVideo;
    private Button btnImages;
    private Button btnQuiz;
    //Verticle Boxes to hold UI elements
    private VBox topVb;
    private VBox leftVb;
    private VBox rightVb;
    private VBox bottomVb;
    private HBox cornerVb;
    private Button btnVideoNext;
    //JavaFX media(video) object
    private Media media;
    private MediaView mediaView;
    
    //constructor 
    public WatchVideo()
    {
        createNodesForUI();
        createVideoPlayer();
        configureUINodes();
        addNodesToLayout();
    }
    //create node objects for the UI
    private void createNodesForUI() {
    //Layout object
    borderPane=new BorderPane();
    borderPane.setPrefSize(980,600);
    borderPane.setStyle("-fx-background-color:tan");
    
    //Setup UI Elements here
    topLbl=new Label("Watch Elearning");
    btnForward=new Button("Next");
    btnForward.setPrefSize(80,20);
    btnBack=new Button("Previous");
    btnBack.setPrefSize(80,20);
    bottomLbl = new Label("Designed by TAHMINA BHUIYAN");
    btnMenu=new Button("Menu");
    btnMenu.setPrefSize(80,20);
    btnImages=new Button("Images");
    btnImages.setPrefSize(80,20);
    btnQuiz=new Button("Quiz");
    btnQuiz.setPrefSize(80,20);
    btnVideoNext=new Button(">");
    // new VBox s to hold UI element
    topVb = new VBox();
    leftVb = new VBox(15);
    rightVb = new VBox();
    bottomVb = new VBox();
    cornerVb=new HBox();
    // button event handler
    btnForward.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(9);
    });
    // button event handler
    btnBack.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(10);
    });
    btnMenu.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(2);
    });
    btnImages.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(6);
    });
    btnQuiz.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(7);
    });     
}
    private void createVideoPlayer() {
    // Locate the media content (video) in the CLASSPATH
    URL mediaUrl = getClass().getResource("Video3.mp4");
    // URL mediaUrl = getClass().getResource("video.mp4");
    String mediaStringUrl = mediaUrl.toExternalForm();   
    media = new Media(mediaStringUrl);
    // Create a Media Player
    final MediaPlayer player = new MediaPlayer(media);
    // Automatically begin the playback
    player.setAutoPlay(true);
    // Create a 600X500 MediaView
    mediaView = new MediaView(player);
    mediaView.setFitWidth(600);
    mediaView.setFitHeight(500);   
    mediaView.setSmooth(true);
    }
    private void configureUINodes() {
    // Set fonts for all labels using CSS
    topLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));    
    bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
    // Configure the VBoxes
    topVb.getChildren().addAll(topLbl);
    topVb.setAlignment(Pos.CENTER);
    topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt;"
            + " -fx-border-color:black;-fx-background-color:#ffbc");
    leftVb.getChildren().addAll(btnMenu,btnImages,btnQuiz,btnBack);
    leftVb.setPadding(new Insets(25, 0, 0, 0));
    leftVb.setAlignment(Pos.TOP_LEFT); 
    leftVb.setStyle("-fx-background-color:#ffcbbc");
    rightVb.getChildren().add(btnForward);
    rightVb.setAlignment(Pos.CENTER);       
    rightVb.setStyle("-fx-background-color:#ffcbbc");
    bottomVb.getChildren().add(bottomLbl);
    bottomVb.setAlignment(Pos.CENTER);
    bottomVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt;"
            + " -fx-border-color:black;-fx-background-color:#ffbc");  
    cornerVb.setAlignment(Pos.BOTTOM_RIGHT);
    cornerVb.getChildren().add(btnVideoNext);
    }
     // add the child nodes to the layout
    private void addNodesToLayout()
    {
    // Add VBoxes to Pane
    borderPane.setTop(topVb);
    borderPane.setLeft(leftVb);
    borderPane.setRight(rightVb);
    borderPane.setBottom(bottomVb);     
    borderPane.setCenter(mediaView);
    getChildren().addAll(borderPane);
    }
    
    
    
}
