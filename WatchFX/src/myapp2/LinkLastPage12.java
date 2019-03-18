/*
* Link class
*Link screen
*/
package myapp2;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author BHUIYAN
 */
public class LinkLastPage12 extends Parent {
    //Layout
    private BorderPane borderPane;
    //UI nodes 
    //private ImageView background;
    private Label topLbl;
    private Button btnForward;
    private Button btnBack;
    private Button btnBackMenu;
    private Label bottomLbl;
    private String[]imageFiles;
    private String[]captions;
    private String[]urls;
    private ImageView selectedImage;
    private Hyperlink[]hpls;
    private Image[]images;
    private WebView browser;
    private WebEngine webEngine;
    private Hyperlink hpl;
    private Image[]image;
   
    //Vertical Boxes To hold UI element
    private HBox topHb;
    private VBox leftVb;
    private VBox rightVb;
    private VBox bottomVb;
    // JavaFX Animation view
    private VBox midVb;
    private HBox hbox;
    // Constructor
    public LinkLastPage12()
    { createNodesForUI();
    configureUINodes();       
    addNodesToLayout();
  
    }
  
   //create the nodes objects for the UI
    private void createNodesForUI() {

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
    bottomLbl = new Label("Designed by TAHMINA BHUIYAN(Link)");
    //get images
    imageFiles=new String[]{
    "","","",""};
    
    //heading caption 
    captions=new String[]{
    "Watch-Apple","Samsung-Watch","Michael Kors_Watch","Support"};
    
    //all Url link
    urls=new String[]{
    "https://www.apple.com/ie/watch/",        
    "https://www.samsung.com/us/mobile/wearables/",
    "https://www.michaelkors.eu/en_IE/watches/view-all-watches/_/N-zzyd20",       
    "http://www.oracle.com/us/support/index.html"};
    selectedImage=new ImageView();
    
    hpls=new Hyperlink[captions.length];
    images=new Image[imageFiles.length];
    
    selectedImage.setLayoutX(100);    
    selectedImage.setLayoutY(10);
    
    browser=new WebView();
    webEngine=browser.getEngine();
    for (int i = 0; i < captions.length; i++) {          
    hpl = hpls[i] = new Hyperlink(captions[i]);           
    final Image image = images[i] =new Image(getClass().getResourceAsStream(imageFiles[i]));      
    hpl.setGraphic(new ImageView (image));     
    hpl.setFont(Font.font("Arial", 14));
       final String url = urls[i]; 
       hpl.setOnAction((ActionEvent e) -> {                
        webEngine.load(url);});}
    //NEW VBox and HBox to hold UI elements
    topHb=new HBox();
    leftVb = new VBox(5);
    rightVb = new VBox();
    bottomVb = new VBox();
    midVb = new VBox();
    hbox = new HBox();       
    hbox.setAlignment(Pos.BASELINE_CENTER);        
    hbox.getChildren().addAll(hpls);
    //btnForward.setOnAction((ActionEvent event) -> {
    //MyApp2.getMainScreen().changeScreen(9);
    //});
    btnBack.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(14);
    });
     btnBackMenu.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(2);
    });
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
    
    midVb.getChildren().addAll(hbox,browser);
    midVb.setAlignment(Pos.CENTER);
    VBox.setVgrow(browser, Priority.ALWAYS);
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
    

