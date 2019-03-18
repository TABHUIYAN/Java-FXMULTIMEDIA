/*
 * Animation class
 * Animation screen 
 */
package myapp2;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 *
 * @author BHUIYAN
 */
public class Animation extends Parent{
    
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
    Circle circle;
    //Vertical Boxes To hold UI element
    private HBox topHb;
    private VBox leftVb;
    private VBox rightVb;
    private VBox bottomVb;
    // JavaFX Animation view
    private VBox midVb;
    
    // Constructor
    public Animation()
    { createNodesForUI();
     cofigureAnimation();
     configureUINodes(); 
     addNodesToLayout();
  
    }
  
    // create the nodes objects for the UI
    private void createNodesForUI() {
      
    // layout object
    borderPane=new BorderPane();
    borderPane.setPrefSize(980,600);
    borderPane.setStyle("-fx-background-color:tan");
    
    //setup UI elements
     topLbl = new Label(" Watch Elearning");
     
    btnForward = new Button("Forward");
    btnBack = new Button("Back");
    btnBackMenu=new Button("Back Menu");
    btnForward.setPrefSize(80,20);
    btnBack.setPrefSize(80,20);
    btnBackMenu.setPrefSize(80,20);
    bottomLbl = new Label("Designed by TAHMINA BHUIYAN(Animation)");
  
    //NEW VBox and HBox to hold UI elements
    topHb=new HBox();
    leftVb = new VBox(5);
    rightVb = new VBox();
    bottomVb = new VBox();
    midVb = new VBox(10);
    //Creating play button 
      playButton = new Button("Play"); 
      playButton.setPrefSize(80,20);
      playButton.setLayoutX(300); 
      playButton.setLayoutY(250);
     // Creating stop button 
      stopButton = new Button("stop");
      stopButton.setPrefSize(80,20);
      stopButton.setLayoutX(250); 
      stopButton.setLayoutY(250);
    btnForward.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(5);
    });
    btnBack.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(11);
    });
     btnBackMenu.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(2);
    });
    }
    private void cofigureAnimation() {
      //Drawing a Circle 
      circle = new Circle(); 
      //Setting the position of the circle 
      circle.setCenterX(300.0f); 
      circle.setCenterY(135.0f); 
      //Setting the radius of the circle 
      circle.setRadius(25.0f);  
      
      //Setting the color of the circle 
      circle.setFill(Color.BROWN); 
      
      //Setting the stroke width of the circle 
      circle.setStrokeWidth(20);      
       
      //Creating a Path 
      Path path = new Path(); 
      
      //Moving to the staring point 
      MoveTo moveTo = new MoveTo(208, 71);               
      
      //Creating 1st line 
      LineTo line1 = new LineTo(421, 161);        
      
      //Creating 2nd line 
      LineTo line2 = new LineTo(226,232); 
      
      //Creating 3rd line 
      LineTo line3 = new LineTo(332,52);        
      
      //Creating 4th line 
      LineTo line4 = new LineTo(369, 250);        
      
      //Creating 5th line 
      LineTo line5 = new LineTo(208, 71);       
      
      //Adding all the elements to the path 
      path.getElements().add(moveTo); 
      path.getElements().addAll(line1, line2, line3, line4, line5);     
      
      //Creating the path transition 
      PathTransition pathTransition = new PathTransition(); 
      
      //Setting the duration of the transition 
      pathTransition.setDuration(Duration.millis(1000));       
      
      //Setting the node for the transition 
      pathTransition.setNode(circle); 
      
      //Setting the path for the transition 
      pathTransition.setPath(path); 
      
      //Setting the orientation of the path 
     // pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TAN GENT);
     
      pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
      
      //Setting the cycle count for the transition 
      pathTransition.setCycleCount(50); 
      
      //Setting auto reverse value to true 
      pathTransition.setAutoReverse(false);
      circle.setOnMouseClicked ((javafx.scene.input.MouseEvent e) -> {
           System.out.println("");
           circle.setFill(Color.DARKSLATEBLUE); 
      });   
      playButton.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         @Override
        public void handle(MouseEvent event) { 
            System.out.println("Animation Playing");  
            pathTransition.play(); 
         } 
      })); 
       
      
     stopButton.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         @Override
         public void handle(MouseEvent event) { 
            System.out.println("Stop Animation"); 
            pathTransition.stop(); 
         } 
      }));
      
         }

    private void configureUINodes() {
   //set fonts for all label using css
    topLbl.setFont(Font.font("Verdana",FontWeight.BOLD,16)); 
    topLbl.setAlignment(Pos.CENTER);
    
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
    
    midVb.getChildren().addAll(circle,playButton,stopButton);
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
