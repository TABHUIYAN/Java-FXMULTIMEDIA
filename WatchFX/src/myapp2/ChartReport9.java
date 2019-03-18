/*
*Chart class
*CHART SCREEN
*/
package myapp2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author BHUIYAN
 */
public class ChartReport9 extends Parent {
    
    DataController localController;
    //Layout
    private BorderPane borderPane;
    //UI nodes 
    private ImageView background;
    private Label topLbl;
    private Button btnForward;
    private Button btnBack;
    private Button btnBackMenu;
    private Label bottomLbl;
    LineChart chart;
    //Vertical Boxes To hold UI element
    private HBox topHb;
    private VBox leftVb;
    private VBox rightVb;
    private VBox bottomVb;
    // JavaFX Animation view
    private VBox midVb;
    
    // Constructor
    public ChartReport9()
    { 
    createNodesForUI();  
    configureChart();   
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
    bottomLbl = new Label("Designed by TAHMINA BHUIYAN (Charts)");
  
    //NEW VBox and HBox to hold UI elements
    topHb=new HBox();
    leftVb = new VBox(5);
    rightVb = new VBox();
    bottomVb = new VBox();
    midVb = new VBox();
    btnForward.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(11);
    });
    btnBack.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(4);
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
    
    midVb.getChildren().addAll(chart);
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
    // configure the chart (styling and position)
    private void configureChart() {
    NumberAxis xAxis = new NumberAxis("Values for X-Axis", 0, 3, 1);
    NumberAxis yAxis = new NumberAxis("Values for Y-Axis", 0, 3, 1);
    ObservableList<XYChart.Series<Double,Double>> lineChartData = FXCollections.observableArrayList(
    new LineChart.Series<Double,Double>("Series 1", FXCollections.observableArrayList(
    new XYChart.Data<Double,Double>(0.0, 1.0),
    new XYChart.Data<Double,Double>(1.2, 1.4),
    new XYChart.Data<Double,Double>(2.2, 1.9),
    new XYChart.Data<Double,Double>(2.7, 2.3),
    new XYChart.Data<Double,Double>(2.9, 0.5)        )),
    new LineChart.Series<Double,Double>("Series 2", FXCollections.observableArrayList(
    new XYChart.Data<Double,Double>(0.0, 1.6),
    new XYChart.Data<Double,Double>(0.8, 0.4),
    new XYChart.Data<Double,Double>(1.4, 2.9),
    new XYChart.Data<Double,Double>(2.1, 1.3),
    new XYChart.Data<Double,Double>(2.6, 0.9)
     )));
        
    chart = new LineChart(xAxis, yAxis, lineChartData);
    }
}
