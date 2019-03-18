/*
 * Content class
 * Content screen which contain all brief history about watch
 */
package myapp2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author BHUIYAN
 */
public class Content extends Parent {
    DataController localController;
    //layout
    private BorderPane borderPane;
    
    //UI nodes 
    private ImageView background;
    private Label topLbl;
    private Button btnForward;
    private Button btnBack;
    private Label bottomLbl;
    private Button btnHome;
    private Button btnAbout;
    //Vertical Boxes To hold UI element
    private HBox topHb;
    private VBox leftVb;
    private VBox rightVb;
    private VBox bottomVb;
    private StackPane stackPane;
    private FlowPane flowPane;
    private AnchorPane anchorPane;
    private GridPane gridPane;
    private Text watchModel;
    private Text watchMake;
    private Text text;
    private String watchMakeValue;
    private String watchModelValue;
    
    //constructor
    public Content(){
    localController = MyApp2.getMainScreen().getDataController();
    getWatchData();
    createNodesForUI();
    configureUINodes();       
    addNodesToLayout();
    }
    private void getWatchData()
    {
    //watchMakeValue = localController.myWristWatch.getMake();
    //watchModelValue = localController.myWristWatch.getModel();
    }
    private void createNodesForUI()
    {
    //layout Object
    borderPane=new BorderPane();
    borderPane.setPrefSize(980,600);
    borderPane.setStyle("-fx-background-color:tan");
    // background = new ImageView(new Image(getClass().getResourceAsStream("watch1.jpg")));
    //watch text
    watchModel=new Text();
    watchMake=new Text();
    text=new Text();
    watchModel.setText("Watch Model " +  watchModelValue);
    watchMake.setText("Watch Make " + watchMakeValue );
    //Setup UI elements here
    topLbl = new Label(" Watch Elearning");
    btnForward = new Button("Forward");
    btnBack = new Button("Back");
    btnForward.setPrefSize(80,20);
    btnBack.setPrefSize(80,20);
    bottomLbl = new Label("Designed by TAHMINA BHUIYAN");
    //btnHome=new Button("Home");
    //btnAbout=new Button("About");
        
   //NEW VBox and HBox to hold UI elements
    topHb=new HBox();
    leftVb = new VBox();
    rightVb = new VBox();
    bottomVb = new VBox();
    stackPane=new StackPane();
    flowPane=new FlowPane();
    anchorPane=new AnchorPane();
    gridPane=new GridPane();
    //Button event Handler
    btnForward.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(6);
    });
    btnBack.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(2);
    });
   }
    // configure the UI (styling and position)
    private void configureUINodes()
    {
    //set fonts for all label using css
    topLbl.setFont(Font.font("Verdana",FontWeight.BOLD,16)); 
    topLbl.setAlignment(Pos.TOP_RIGHT);
    bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 28));
     
    //configure the Boxes
    topHb.getChildren().addAll(topLbl,stackPane);
    topHb.setPadding(new Insets(15,12,15,12));
    topHb.setSpacing(5);
    //btnHome.setPrefSize(80,10);
    // btnAbout.setPrefSize(80,10);
    topHb.setStyle("-fx-border-style:solid;"
                   + "-fx-background-color:#ffbc;fx-border-color:black");
    //left design
    leftVb.getChildren().add(btnBack);
    leftVb.setStyle("-fx-background-color:#ffbcdf");
    leftVb.setAlignment(Pos.CENTER);      
    rightVb.getChildren().add(btnForward);
    rightVb.setStyle("-fx-background-color:#ffbcdf");
    rightVb.setAlignment(Pos.CENTER);       
    bottomVb.getChildren().add(bottomLbl);
    bottomVb.setAlignment(Pos.CENTER);
    bottomVb.setStyle("-fx-border-stylel:solid;-fx-background-color:#ffbc; -fx-border-width:1pt; -fx-border-color:black;");  
    //Help text Stackpane
    Rectangle helpIcon=new Rectangle(30.0,25.0);
    helpIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
    new Stop[]{
    new Stop(0,Color.web("#4977A3")),
    new Stop(0.5, Color.web("#B0C6DA")),
    new Stop(1,Color.web("#9CB6CF")),}));
    helpIcon.setStroke(Color.web("#D0E6FA"));
    helpIcon.setArcHeight(3.5);
    helpIcon.setArcWidth(3.5);
    
    //Text Help
    Text helpText=new Text("?");
    helpText.setFont(Font.font("Verdana",FontWeight.BOLD,18));
    helpText.setFill(Color.web("#7080A0"));
    stackPane.getChildren().addAll(helpIcon,helpText);
    stackPane.setAlignment(Pos.CENTER_RIGHT); 
    // alignment of all nodes
    StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));
    HBox.setHgrow(stackPane, Priority.ALWAYS);
    //flowPane
    flowPane.setPadding(new Insets(15,0,5,0));
    flowPane.setVgap(4);
    flowPane.setHgap(4);
    flowPane.setPrefWrapLength(170);//
    flowPane.setStyle("-fx-background-color:DAE6F3");
    //Grid pan
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.setPadding(new Insets(0,10,0,10));
    //category in column 2, row 1
    Text category=new Text("Welcome to Hand Watch Elearning Application");
    category.setFont(Font.font("Arial", FontWeight.BOLD,20));
    gridPane.add(category,8,8);
    //Title in column 3,row 1
    Text chartSubtitle=new Text("Michael Kors - A Brief History:");
    chartSubtitle.setFont(Font.font("Arial",FontWeight.BOLD,18));
    gridPane.add(chartSubtitle, 8,9,10,3);
    //Subtitle in columns 2-3, row 2
    Text chartSubtitle1=new Text(" Michael Kors Watches stands for,"
                                 + " luxurious and chic design."
                                 + "To capture the jet setter in all of us,\n"
                                 + " Michael Kors brings value and quality "
                                 + "to his line of watches that "
                                 + "is reflected in the pricing.\n In the 1980’s in New York,"
                                 + " Michael Kors begain a line for Lothar’s in Manhattan."
                                 + "He immediately began to draw customers in \n"
                                 + "and soon the press took notice."
                                 + " He branched out in 1981 to launch his own brand and in 1983 his talent\n"
                                 + " was recognized with the First"
                                 + " American Original award from Dupont,the first of many he would receive.  ");
                                 gridPane.add(chartSubtitle1,8,12,14,4);
    chartSubtitle1.setFont(Font.font("Arial",14));
    //Right label in column 4 (top), row 3
    Text noticeText=new Text("Play Quiz and Win A MK Watch");
    GridPane.setValignment(noticeText,VPos.BOTTOM);
    gridPane.add(noticeText,10,10,10,10);
    noticeText.setFont(Font.font("Arial", FontWeight.BOLD,14));
    noticeText.setStyle("-fx-font-color:green");
    } 
    private void addNodesToLayout() {
    // Add VBoxes to Pane
    borderPane.setTop(topHb);
    borderPane.setLeft(leftVb);
    borderPane.setRight(rightVb);
    borderPane.setBottom(bottomVb);
    borderPane.setCenter(background);
        
    getChildren().addAll(borderPane,anchorPane,gridPane);
    }
    }
