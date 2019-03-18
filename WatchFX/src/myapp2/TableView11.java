/*
 * data table class
 * table screen
 */
package myapp2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import myapp2.wristwatches.WristWatch;
import myapp2.DataController;
import myapp2.MyApp2;

/**
 *
 * @author BHUIYAN
 */
public class TableView11 extends Parent {
	DataController localController;

	WristWatch[] myWatches;

	TableView<WristWatch> table;

	// layout
	private BorderPane borderPane;

	// UI nodes
	private Label topLbl;
	private Button btnForward;
	private Button btnBack;
        private Button btnBackMenu;
	private Label bottomLbl;
	private Text text;

	// Veritcal Boxes to hold UI elements
	private VBox topVb;
	private VBox leftVb;
	private VBox rightVb;
	private VBox bottomVb;
	private VBox midVb;

	// constructor
	public TableView11() {
		localController = MyApp2.getMainScreen().getDataController();
		myWatches = localController.getMyWristWatchObjects();
		createNodesForUI();
		configureTable();
		configureUINodes();
		addNodesToLayout();
	}

	// create the nodes objects for the UI
	private void createNodesForUI() {
		// layout object
		borderPane = new BorderPane();
		borderPane.setPrefSize(980, 600);

		// Setup UI elements here
		topLbl = new Label("Watch Elearning");
		btnForward = new Button("Forward");
		btnForward.setPrefSize(80, 20);
		btnBack = new Button("Back");
		btnBack.setPrefSize(80, 20);
		bottomLbl = new Label("Designed by TAHMINA BHUIYAN");
                btnBackMenu=new Button("Back Menu");
		// new VBox s to hold UI elements
		topVb = new VBox();
		leftVb = new VBox(5);
		rightVb = new VBox(5);
		bottomVb = new VBox();
		midVb = new VBox();
        
         // button event handler
        btnForward.setOnAction((ActionEvent event) -> {
            MyApp2.getMainScreen().changeScreen(8);
        });
         btnBack.setOnAction((ActionEvent event) -> {
            MyApp2.getMainScreen().changeScreen(9);
        });
         btnBackMenu.setOnAction((ActionEvent event) -> {
            MyApp2.getMainScreen().changeScreen(2);
        });
    }
    
    
    // configure the UI (styling and position)
	private void configureUINodes() {
		// Set fonts for all labels using CSS
		topLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

		bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

		// Configure the VBoxes
		topVb.getChildren().add(topLbl);
		topVb.setAlignment(Pos.CENTER);
		// topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt;
		// -fx-border-color:black;");
		topVb.setStyle("-fx-border-style:solid;" + "-fx-background-color:#ffbc;fx-border-color:black");

		leftVb.getChildren().addAll(btnBackMenu,btnBack);
		leftVb.setAlignment(Pos.CENTER);
		leftVb.setStyle("-fx-background-color:#ffbcdf");

		rightVb.getChildren().add(btnForward);
		rightVb.setAlignment(Pos.CENTER);
		rightVb.setStyle("-fx-background-color:#ffbcdf");

		bottomVb.getChildren().add(bottomLbl);
		bottomVb.setAlignment(Pos.CENTER);
		bottomVb.setStyle(
		"-fx-border-stylel:solid;-fx-background-color:#ffbc; -fx-border-width:1pt; -fx-border-color:black;");

		midVb.getChildren().addAll(table);
		midVb.setAlignment(Pos.CENTER);
	}

	// configure the UI (styling and position)
	private void configureTable() {
		// Watch Make column
		TableColumn<WristWatch, String> nameColumn = new TableColumn<>("Make");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("make"));

		// Watch Model column
		TableColumn<WristWatch, String> priceColumn = new TableColumn<>("Model");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("model"));

		// Watch Color column
		TableColumn<WristWatch, String> quantityColumn = new TableColumn<>("Color");
		quantityColumn.setMinWidth(100);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("color"));

		// Watch strap column
		TableColumn<WristWatch, String> strapColumn = new TableColumn<>("Watch Strap");
		strapColumn.setMinWidth(100);
		strapColumn.setCellValueFactory(new PropertyValueFactory<>("strapType"));

		table = new TableView<>();
		table.setItems(getProduct());
		// Adjusts the width of table columns
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn, strapColumn);

	}

	// add the child nodes to the layout
	private void addNodesToLayout() {
	// Add VBoxes to Pane
	borderPane.setTop(topVb);
        borderPane.setLeft(leftVb);
	borderPane.setRight(rightVb);
        borderPane.setBottom(bottomVb);
	borderPane.setCenter(midVb);
	getChildren().add(borderPane);
	}

	public ObservableList<WristWatch> getProduct() {
		ObservableList<WristWatch> products = FXCollections.observableArrayList();

		for (int i = 0; i < localController.getNumWatches(); i++) {
			products.add(myWatches[i]);
		}

		return products;
	}

}