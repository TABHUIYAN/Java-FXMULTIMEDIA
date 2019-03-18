/*image class
 *image content
 */
package myapp2;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author BHUIYAN
 */
public class Image13 extends Parent {
    //layout
    private BorderPane borderPane;
    //UI Nodes
    private Image watchImage;
    private ImageView watchImageView;
    private Label topLbl;
    private Button btnForward;
    private Button btnBack;
    private Button btnBackMenu;
    private Label bottomLbl;
    private Text watchModel;
    private Text watchWarenty;
    private Text text;
    private int watchValue;
    private int smartWatchValue;
    private Button btnImNext;
    private Button btnImBack;
    // Veritcal Boxes to hold UI elements
    private  VBox topVb;
    private VBox leftVb;
    private  VBox rightVb;
    private VBox bottomVb;
    private VBox midVb;
    private HBox midHb;
    // constructor
    public Image13() 
    {
    //  localController = Test4.getMainScreen().getDataController();
    // getWatchData();
        createNodesForUI();
        configureUINodes(); 
        configureImage();
        addNodesToLayout();
    }
    // create the nodes objects for the UI
    private void createNodesForUI()
    { 
        // layout object
        borderPane = new BorderPane(); 
        borderPane.setPrefSize(980,600);
        borderPane.setStyle("-fx-background-color:tan");
        watchImage = new Image(getClass().getResourceAsStream("watch1.jpg"));
        watchImageView = new ImageView(watchImage);
        
        // watch text
        watchModel = new Text();
        watchWarenty = new Text();
        text = new Text();
        watchModel.setText("Watch Price " +  watchValue);
        watchWarenty.setText("Watch Model " + smartWatchValue );
        
        // Setup UI elements here
        topLbl = new Label("Micheal Kors Watch Elearning");
        btnForward = new Button("Forward");
        
        btnBack = new Button("Back");
        btnBackMenu=new Button("Back to Menu");
        btnImNext=new Button(">");
        btnImBack=new Button("<");
        // btnBackMenu.setAlignment(Pos.BASELINE_RIGHT);
        bottomLbl = new Label("Designed by TAHMINA BHUIYAN");
        // new VBox s to hold UI elements
        topVb = new VBox();
        leftVb = new VBox();
        rightVb = new VBox();
        bottomVb = new VBox();
        midVb = new VBox(5);
        midHb=new HBox(4);
        // button event handler
        btnForward.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(7);
        });
        btnBack.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(3);
        });
        // button event handler
        btnBackMenu.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(2);
        });
        btnImBack.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(6);
        });
        btnImNext.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(13);
        });
    }
    // configure the UI (styling and position)
    private void configureUINodes()
    {
    // Set fonts for all labels using CSS
       topLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
       // topLbl.setPrefSize(10,20);
       bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
       // bottomLbl.setPrefSize(10,20);
       btnBack.setPrefSize(80,20);
       // btnBack.setStyle("-fx-background-color:#ffbc");
       btnForward.setPrefSize(80,20);
       btnImNext.setPrefSize(40,20);
       btnImBack.setPrefSize(40,20);
       // btnForward.setStyle("-fx-background-color:#ffbc");
       // Configure the VBoxes
       topVb.getChildren().addAll(topLbl,btnBackMenu);
       topVb.setAlignment(Pos.CENTER);
       topVb.setPrefSize(10,40);
       topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;-fx-background-color:#ffbc");
       
       leftVb.getChildren().add(btnBack);
       leftVb.setAlignment(Pos.CENTER);  
       leftVb.setPrefSize(100,20);
       leftVb.setStyle("-fx-background-color:#fbcc");
       
       rightVb.getChildren().addAll(btnForward);
       rightVb.setAlignment(Pos.CENTER);       
       rightVb.setPrefSize(100,20);
       rightVb.setStyle("-fx-background-color:#fbcc");
       
       bottomVb.getChildren().addAll(bottomLbl);
       bottomVb.setAlignment(Pos.CENTER);
       bottomVb.setPrefSize(10,40);
       bottomVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;-fx-background-color:#ffbc");  
       
       midVb.getChildren().addAll(watchModel,watchWarenty,text,watchImageView,midHb);
       midVb.setAlignment(Pos.CENTER); 
       midHb.setAlignment(Pos.CENTER);
       midHb.getChildren().addAll(btnImBack,btnImNext);
    }
    // configure the UI (styling and position)
    private void configureImage()
    {
    //Setting the position of the image 
    //setting the fit height and width of the image view 
    watchImageView.setFitHeight(200); 
    watchImageView.setFitWidth(300); 
      
    //Setting the preserve ratio of the image view 
    watchImageView.setPreserveRatio(true);  
    }
    // add the child nodes to the layout
    private void addNodesToLayout()
    {
    // Add VBoxes to Pane
       borderPane.setTop(topVb);
       borderPane.setLeft(leftVb);
       borderPane.setRight(rightVb);
       borderPane.setBottom(bottomVb);
       borderPane.setCenter(midVb);
       getChildren().add(borderPane);
    }
    

}
