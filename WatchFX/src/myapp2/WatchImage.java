/*
*content/watch Image
*Watch image Screen
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
import myapp2.MyApp2;

/**
 *
 * @author BHUIYAN
 */
public class WatchImage extends Parent {
	DataController localController;
	// layout
	private BorderPane borderPane;
	// UI Nodes
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
	private Button btnImNext;
	private Button btnImBack;
	private String watchMakeValue;
	private String watchModelValue;
	private String watchImageFile;
	// Veritcal Boxes to hold UI elements
	private VBox topVb;
	private VBox leftVb;
	private VBox rightVb;
	private VBox bottomVb;
	private VBox midVb;
	private HBox midHb;
	private int numWatches;

	// constructor
	public WatchImage() {

		numWatches = 0;
		localController = MyApp2.getMainScreen().getDataController();
		getWatchData(numWatches);
		createNodesForUI();
		configureUINodes();
		configureImage();
		addNodesToLayout();
	}

	private void getWatchData(int i) {
		watchMakeValue = localController.getMyWristWatchObjects()[i].getMake();
		watchModelValue = localController.getMyWristWatchObjects()[i].getModel();
		watchImageFile = localController.getMyWristWatchObjects()[i].getImagePath();
	}

	// create the nodes objects for the UI
	private void createNodesForUI() {
		// layout object
		borderPane = new BorderPane();
		borderPane.setPrefSize(980, 600);
		borderPane.setStyle("-fx-background-color:tan");
		watchImage = new Image(getClass().getResourceAsStream("fossil.jpg"));
		watchImageView = new ImageView(watchImage);

		// watch text
		watchModel = new Text();
		watchWarenty = new Text();
		text = new Text();
		watchModel.setText("Watch Make: " + watchMakeValue);
		watchWarenty.setText("Watch Model: " + watchModelValue);

		// Setup UI elements here
		topLbl = new Label(" Watch Elearning");
		btnForward = new Button("Forward");

		btnBack = new Button("Back");
		btnBackMenu = new Button("Back to Menu");
		btnImNext = new Button(">");
		btnImBack = new Button("<");
		// btnBackMenu.setAlignment(Pos.BASELINE_RIGHT);
		bottomLbl = new Label("Designed by TAHMINA BHUIYAN");
		// new VBox s to hold UI elements
		topVb = new VBox();
		leftVb = new VBox(5);
		rightVb = new VBox();
		bottomVb = new VBox();
		midVb = new VBox(5);
		midHb = new HBox(4);
		// button event handler
		btnForward.setOnAction((ActionEvent event) -> {
			MyApp2.getMainScreen().changeScreen(10);
		});
		btnBack.setOnAction((ActionEvent event) -> {
			MyApp2.getMainScreen().changeScreen(3);
		});
		// button event handler
		btnBackMenu.setOnAction((ActionEvent event) -> {
			MyApp2.getMainScreen().changeScreen(2);
		});
		
		btnImBack.setOnAction((ActionEvent event) -> {
			numWatches--;
			if (numWatches == -1) {
		        numWatches = localController.getNumWatches()-1;
			}

			watchModel.setText("Watch Make: " + localController.getMyWristWatchObjects()[numWatches].getMake());
			watchWarenty.setText("Watch Model: " + localController.getMyWristWatchObjects()[numWatches].getModel());
			Image newWatchImage = new Image(getClass()
					.getResourceAsStream(localController.getMyWristWatchObjects()[numWatches].getImagePath()));
			watchImageView.setImage(newWatchImage);
		        });
		        btnImNext.setOnAction((ActionEvent event) -> {
			numWatches++;
			if (numWatches == localController.getNumWatches()) {
				numWatches = 0;
			}

			watchModel.setText("Watch Make: " + localController.getMyWristWatchObjects()[numWatches].getMake());
			watchWarenty.setText("Watch Model: " + localController.getMyWristWatchObjects()[numWatches].getModel());
			Image newWatchImage = new Image(getClass()
					.getResourceAsStream(localController.getMyWristWatchObjects()[numWatches].getImagePath()));
			watchImageView.setImage(newWatchImage);
		});
	}

	// configure the UI (styling and position)
	private void configureUINodes() {
		// Set fonts for all labels using CSS
		topLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
		bottomLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
		btnBack.setPrefSize(80, 20);
		btnForward.setPrefSize(80, 20);
		btnImNext.setPrefSize(40, 20);
		btnImBack.setPrefSize(40, 20);
		// Configure the VBoxes
		topVb.getChildren().addAll(topLbl);
		topVb.setAlignment(Pos.CENTER);
		topVb.setPrefSize(10, 40);
		topVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt;"
				+ " -fx-border-color:black;-fx-background-color:#ffbc");

		leftVb.getChildren().addAll(btnBackMenu, btnBack);
		leftVb.setAlignment(Pos.CENTER);
		leftVb.setPrefSize(100, 20);
		leftVb.setStyle("-fx-background-color:#fbcc");

		rightVb.getChildren().addAll(btnForward);
		rightVb.setAlignment(Pos.CENTER);
		rightVb.setPrefSize(100, 20);
		rightVb.setStyle("-fx-background-color:#fbcc");

		bottomVb.getChildren().addAll(bottomLbl);
		bottomVb.setAlignment(Pos.CENTER);
		bottomVb.setPrefSize(10, 40);
		bottomVb.setStyle("-fx-border-stylel:solid; -fx-border-width:1pt; "
				+ "-fx-border-color:black;-fx-background-color:#ffbc");

		midVb.getChildren().addAll(watchModel, watchWarenty, text, watchImageView, midHb);
		midVb.setAlignment(Pos.CENTER);
		midHb.setAlignment(Pos.CENTER);
		midHb.getChildren().addAll(btnImBack, btnImNext);
	}

	// configure the UI (styling and position)
	private void configureImage() {
		// Setting the position of the image
		watchImageView.setFitHeight(200);
		watchImageView.setFitWidth(300);

		// Setting the preserve ratio of the image view
		watchImageView.setPreserveRatio(true);
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
}
