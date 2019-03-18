/*
 * Content menu class 
 * content menu screen ....brief history of rolex watch
 */
package myapp2;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author BHUIYAN
 */
public class ContentMenu extends Parent
{
    // layout
    private BorderPane borderPane;
    // JavaFX menu
    Menu appMenu;
    MenuBar menuBar;
    // UI nodes
    private Label midLbl;
    private Label topLbl;
    private Button btnForward;
    private Button btnBack;
    private Button btnBackMenu;
    private Label bottomLbl;
    private Text watchText;

    // Veritcal Boxes to hold UI elements
    private  VBox topVb;
    private VBox leftVb;
    private  VBox rightVb;
    private VBox bottomVb;
    
    // constructor
    public ContentMenu() 
    {
    createNodesForUI();
    configureUINodes();       
    addNodesToLayout();
    }
    // create the nodes objects for the UI
    private void createNodesForUI()
    {
    //menu
    appMenu = new Menu("Elearning");
       
    // menu items
    MenuItem pauseLesson = new MenuItem("Pause Lesson");
    appMenu.getItems().add(new MenuItem("Start Lesson"));
    appMenu.getItems().add(new MenuItem("Save Progress"));
    appMenu.getItems().add(pauseLesson);        
    // menu bar
    menuBar = new MenuBar();
    menuBar.getMenus().addAll(appMenu);
    // layout object
    borderPane = new BorderPane();
    borderPane.setPrefSize(980,600);
    // Setup UI elements here
    topLbl = new Label("Watch Elearning");
    // watch text
    watchText = new Text();
    watchText.setFont(new Font(14));
    watchText.setWrappingWidth(500);
    watchText.setTextAlignment(TextAlignment.JUSTIFY);
    watchText.setText("\"The history of Rolex is inextricably linked to the visionary spirit of Hans Wilsdorf, its founder. "
        + "In 1905, at the age of 24, Hans Wilsdorf founded a company in London specialising in the distribution of timepieces."
        + " He began to dream of a watch worn on the wrist. Wristwatches were not very precise at the time,"
        + " but Hans Wilsdorf foresaw that they could become not only elegant, but also reliable.");
        
    btnForward = new Button("Forward");
    btnForward.setPrefSize(80,20);
    btnBack = new Button("Back");
    btnBackMenu=new Button("Back Menu");
    btnBack.setPrefSize(80,20);
    bottomLbl = new Label("Designed by TAHMINA BHUIYAN");
    // new VBox s to hold UI elements
    topVb = new VBox();
    leftVb = new VBox(5);
    rightVb = new VBox();
    bottomVb = new VBox();
    // button event handler
    pauseLesson.setOnAction((ActionEvent event) -> {
    System.out.println("Pausing lesson now......");
    });
    // button event handler
    btnForward.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(7);
    });
    btnBack.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(8);
    });
    btnBackMenu.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(2);
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
    topVb.setStyle("-fx-border-style:solid;"
            + "-fx-background-color:#ffbc;fx-border-color:black");
    leftVb.getChildren().addAll(btnBackMenu,btnBack);
    leftVb.setStyle("-fx-background-color:#ffbcdf");
    leftVb.setAlignment(Pos.CENTER);      
    rightVb.getChildren().add(btnForward);
    rightVb.setStyle("-fx-background-color:#ffbcdf");
    rightVb.setAlignment(Pos.CENTER);       
    bottomVb.getChildren().add(bottomLbl);
    bottomVb.setAlignment(Pos.CENTER);
    bottomVb.setStyle("-fx-border-stylel:solid;-fx-background-color:#ffbc;"
            + " -fx-border-width:1pt; -fx-border-color:black;");  
    }
    
        
    
     // add the child nodes to the layout
    private void addNodesToLayout()
    {
       // Add VBoxes to Pane
       borderPane.setTop(menuBar);
       
       borderPane.setLeft(leftVb);
       borderPane.setRight(rightVb);
       borderPane.setBottom(bottomVb);
       borderPane.setCenter(watchText);
       getChildren().add(borderPane);
    }
}
