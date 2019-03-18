/*
 * Quiz Class
 * quiz screen containing question and answer
 */
package myapp2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author BHUIYAN
 */
public class Quiz2 extends Parent {
    //Layout 
    private BorderPane borderPane;
      // Radio Button
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;
    
    // UI nodes
    private Label topLbl;
    private Label question;
    private Button btnForward;
    private Button btnBack;
    private Button btnAnswer;
    private Button btnBackMenu;
    private Label bottomLbl;
   private final Label answerResponse= new Label();

     // Veritcal Boxes to hold UI elements
    private  VBox topVb;
    private  VBox midVb;
    private VBox leftVb;
    private  VBox rightVb;
    private VBox bottomVb;
    
    // Questions and Answers
    private final String[] questions = {"Who invented MK Watch?",
                                 "Which operating system Apple Watch use?",
                                 "How many series Apple Watch Have?",
                                 "How many images you have seen in this Application?",
                                 "When Micheal Kors invented?"};
    private final String[][] answers = {{"Newton","Lothar","Job Stevs","Messi","2"},
                                  {"iOS","Window","Linux","Android","1"},
                                  {"1","2","3","4","3"},
                                  {"3","2","5","6","2"},
                                  {"1995","2018","2000","1980","4"}};
    
    private int resultCount;
    private int i;
    // constructor
    public Quiz2() 
    {
        i = 0;
        resultCount = 0;
        createNodesForUI();
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
       radio1= new RadioButton(answers[i][0]);
       radio2= new RadioButton(answers[i][1]);
       radio3= new RadioButton(answers[i][2]);
       radio4= new RadioButton(answers[i][3]);
       
       ToggleGroup question1= new ToggleGroup();

       radio1.setToggleGroup(question1);
       radio2.setToggleGroup(question1);
       radio3.setToggleGroup(question1);
       radio4.setToggleGroup(question1);

       //btnAnswer.setDisable(true);
        
        // Setup UI elements here 
        topLbl = new Label(" Watch Elearning");
        question = new Label(questions[i]);
        btnForward = new Button("Forward");
        btnForward.setPrefSize(80,20);
        btnBack = new Button("Back");
        btnBackMenu=new Button ("Back Menu");
        btnBack.setPrefSize(80,20);
        btnAnswer = new Button("Answer");
        btnAnswer.setPrefSize(80,20);
        bottomLbl = new Label("Designed by TAHMINA BHUIYAN");

        // new VBox s to hold UI elements
        topVb = new VBox();
        midVb = new VBox(20);
        leftVb = new VBox(5);
        rightVb = new VBox();
        bottomVb = new VBox();
        
         // button event handler
        btnForward.setOnAction((ActionEvent event) -> {
            MyApp2.getMainScreen().changeScreen(14);
       });
         btnBack.setOnAction((ActionEvent event) -> {
             MyApp2.getMainScreen().changeScreen(5);
       });
         btnBackMenu.setOnAction((ActionEvent event) -> {
       MyApp2.getMainScreen().changeScreen(2);
       });
         btnAnswer.setOnAction(ae->{
            
                int rightAnswer = Integer.parseInt(answers[i][4]);
                switch(rightAnswer){
                    case 1:
                       if (radio1.isSelected())
                        {
                            //btnAnswer.setDisable(true);
                            resultCount++;
                            answerResponse.setText("Correct answer");
                        }
   
                        else
                        {
                        answerResponse.setText("Wrong answer");
                        //btnAnswer.setDisable(true);
                        }
                        break;
                    case 2:
                       if (radio2.isSelected())
                        {
                           // btnAnswer.setDisable(true);
                            resultCount++;
                            answerResponse.setText("Correct answer");
                        }
   
                        else
                        {
                        answerResponse.setText("Wrong answer");
                        //btnAnswer.setDisable(true);
                        }
                        break;
                    case 3:
                       if (radio3.isSelected())
                        {
                            //btnAnswer.setDisable(true);
                            resultCount++;
                            answerResponse.setText("Correct answer");
                        }
   
                        else
                        {
                        answerResponse.setText("Wrong answer");
                        //btnAnswer.setDisable(true);
                        }
                       break;
                    case 4:
                       if (radio4.isSelected())
                        {
                            //btnAnswer.setDisable(true);
                            resultCount++;
                            answerResponse.setText("Correct answer");
                        }
   
                        else
                        {
                        answerResponse.setText("Wrong answer");
                        //btnAnswer.setDisable(true);
                        }
                       break;
                    default:
                        answerResponse.setText("Wrong answer");
                        //btnAnswer.setDisable(true);
                }
                      
            if(i < 4){
            
            i++;
            question.setText(questions[i]);
            radio1.setText(answers[i][0]);
            radio2.setText(answers[i][1]);
            radio3.setText(answers[i][2]);
            radio4.setText(answers[i][3]);
            resetRadioSelection();
            
            
        }else{
          answerResponse.setText("Total Score: " + getResultCount() + "/5");
         
          
            }
         
         });

       }
    
    
    // configure the UI (styling and position)
    private void configureUINodes()
    {
        // Set fonts for all labels using CSS
        topLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
    
       bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
       
       // Configure the VBoxes
       topVb.getChildren().add(topLbl);
       topVb.setAlignment(Pos.CENTER);
       topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;-fx-background-color:#ffbc");
       
       leftVb.getChildren().addAll(btnBackMenu,btnBack);
       leftVb.setAlignment(Pos.CENTER); 
       leftVb.setStyle("-fx-background-color:#ffcbbc");
       
       rightVb.getChildren().add(btnForward);
       rightVb.setAlignment(Pos.CENTER);    
       rightVb.setStyle("-fx-background-color:#ffcbbc");
   
       bottomVb.getChildren().add(bottomLbl);
       bottomVb.setAlignment(Pos.CENTER);
       bottomVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; -fx-border-color:black;-fx-background-color:#ffbc");  
      
       midVb.setPrefWidth(150);
       midVb.setAlignment(Pos.TOP_LEFT);
       midVb.getChildren().addAll(question,radio1,radio2,radio3,radio4,btnAnswer,answerResponse);
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
    
    private void resetRadioSelection(){
        radio1.setSelected(false);
        radio2.setSelected(false);
        radio3.setSelected(false);
        radio4.setSelected(false);
    }
    
    public int getResultCount(){
    
        return resultCount;
    }
}
