/*
 * Quiz answer class
 * quiz answer screen
 */
package myapp2;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author BHUIYAN
 */
public class QuizAns14 extends Parent {

    //layout
    private BorderPane borderPane;
    //UI Nodes
    private Label topLbl;
    private Button btnForward;
    private Button btnBack;
    private Button btnBackMenu;
    private Label bottomLbl;
    private Label question1;
    private Label question1a;
    private Label question2;
    private Label question2a;
    private Label question3;
    private Label question3a;
    private Label question4;
    private Label question4a;
    private Label question5;
    private Label question5a;
    // Veritcal Boxes to hold UI elements
    private VBox topVb;
    private VBox leftVb;
    private VBox rightVb;
    private VBox bottomVb;
    private VBox midVb;
    //private HBox midHb;
    // constructor
    public QuizAns14() 
    {createNodesForUI();
    configureUINodes(); 
    addNodesToLayout();
    }
    // create the nodes objects for the UI
    private void createNodesForUI()
    {
    // layout object
        borderPane = new BorderPane(); 
        borderPane.setPrefSize(980,600);
        borderPane.setStyle("-fx-background-color:tan");
        // Setup UI elements here
        topLbl = new Label(" Watch Elearning");
        btnForward = new Button("Forward");
        btnBack = new Button("Back");
        btnBackMenu=new Button("Back to Menu");
        question1=new Label("Question 1: Who invented MK Watch?");
        question1a=new Label("Answer: Lother");
        question2=new Label("Question 2: Which operating system Apple Watch use?");
        question2a=new Label("Answer: iOS");
        question3=new Label("Question 3: How many series Apple Watch Have?");
        question3a=new Label("Answer: 3");
        question4=new Label("Question 4: How many images you have seen in this Application?");
        question4a=new Label("Answer: 2");
        question5=new Label("Question 5: When Micheal Kors invented?");
        question5a=new Label("Answer: 1980");
        // btnBackMenu.setAlignment(Pos.BASELINE_RIGHT);
        bottomLbl = new Label("Designed by TAHMINA BHUIYAN");
        // new VBox s to hold UI elements
        topVb = new VBox();
        leftVb = new VBox(5);
        rightVb = new VBox();
        bottomVb = new VBox();
        midVb=new VBox();
        // button event handler
        btnForward.setOnAction((ActionEvent event) -> {
            MyApp2.getMainScreen().changeScreen(12);
        });
        btnBack.setOnAction((ActionEvent event) -> {
            MyApp2.getMainScreen().changeScreen(7);
        });
           // button event handler
        btnBackMenu.setOnAction((ActionEvent event) -> {
            MyApp2.getMainScreen().changeScreen(2);
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
       //button size
       btnForward.setPrefSize(80,20);
       // Configure the VBoxes
       topVb.getChildren().add(topLbl);
       topVb.setAlignment(Pos.CENTER);
       topVb.setPrefSize(10,40);
       topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;-fx-background-color:#ffbc");
       
       leftVb.getChildren().addAll(btnBackMenu,btnBack);
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
       
       midVb.getChildren().addAll(question1,question1a,question2,question2a,
       question3,question3a,question4,question4a,question5,question5a);
       midVb.setAlignment(Pos.BASELINE_LEFT); 
       
      
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
