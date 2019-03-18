/*
 * Class: Main Menu
 * Description: Menu layout extends the JavaFX Parent - main application menu
 */
package myapp2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author BHUIYAN
 */
public class MainMenu extends Parent{
    //Layout
    private VBox vboxMenu=new VBox();
    private ImageView background;
    //UI Nodes
    private Label nameLabel;
    private Button btnStart;
    private Button btnAudio;
    private Button btnVideo;
    private Button btnQuizAns;
    private Button btnMenu;
    private Button btnImage;
    private Button btnQuiz;
    private Button btnAnimation;
    private Button btnChartReport;
    private Button btnTable;
    private Button btnLink;
    
    //constructor
    MainMenu(){
    
    createNodeForUI();
    addNodesToLayout();
    }
    //create the nodes objects for the UI
  
    private void createNodeForUI() {
        vboxMenu=new VBox();
        nameLabel=new Label("Main Menu");
        nameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
             
        //ui buttons
        btnStart=new Button("Start");
        btnMenu = new Button("Content Menu");
        btnImage=new Button("Images");
        btnVideo = new Button("Videos");
        btnAudio = new Button("Audio");
        btnQuiz = new Button("Quiz");
        btnQuizAns = new Button("Quiz Answer");
        btnAnimation=new Button("Animation");
        btnChartReport=new Button("Charts");
        btnTable=new Button("Table");
        btnLink=new Button("Link");
        //button hieght and width     
        btnStart.setPrefWidth(150);
        btnImage.setPrefWidth(150);
        btnAudio.setPrefWidth(150);
        btnVideo.setPrefWidth(150);
        //btnSettings.setPrefWidth(150);
        btnQuizAns.setPrefWidth(150);
        btnMenu.setPrefWidth(150);
        btnQuiz.setPrefWidth(150);
        btnAnimation.setPrefWidth(150);
        btnTable.setPrefWidth(150);               
        btnChartReport.setPrefWidth(150);  
        btnLink.setPrefWidth(150);

        // set Vbox layout details and size
        vboxMenu.setPrefSize(980,600);
        vboxMenu.setStyle("-fx-background-color:tan");
        vboxMenu.setSpacing(10);
        vboxMenu.setPadding(new Insets(0, 20, 10, 20)); 
        vboxMenu.setAlignment(Pos.CENTER);
        // button event handler
        btnStart.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(3);
        });
        background=new ImageView(new Image(getClass().getResourceAsStream("watch1.jpg")));
        // button menu event handler
        btnMenu.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(5);
        });
        btnQuiz.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(7);
        });
        btnQuizAns.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(14);
        });
        btnAudio.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(10);
        });
        btnVideo.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(4);
        });
        btnImage.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(6);
        });
        btnAnimation.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(8);
        });
        btnTable.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(11);
        });
        btnChartReport.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(9);
        });
        btnLink.setOnAction((ActionEvent event) -> {
        MyApp2.getMainScreen().changeScreen(12);
        });
        }
    // add the child nodes to the layout
    private void addNodesToLayout()
    {
        //Add everything to layout
        vboxMenu.getChildren().addAll(nameLabel, 
        btnStart,btnImage,btnAudio,btnVideo,btnChartReport,btnTable,btnAnimation,
        btnMenu,btnQuiz,btnQuizAns,btnLink);
        
        getChildren().addAll(vboxMenu);
    }

}
