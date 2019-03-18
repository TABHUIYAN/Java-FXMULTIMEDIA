/*
 * Splash class
 * first screen
 */
package myapp2;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author BHUIYAN
 */
class Splash extends Parent {
    // layout for the screen
    private final StackPane stackPane;
    //UI nodes
    Button btnWelcome=new Button();
    ImageView background;
   
    //Splash costructor
    public Splash(){
    stackPane=new StackPane();
    createNodesForUI();
    //createVideoPlayer();
    addNodesToLayout();
    
    }

    private void createNodesForUI() {
    btnWelcome=new Button();
    btnWelcome.setPrefWidth(250);
    
    btnWelcome.setAlignment(Pos.CENTER);
    btnWelcome.setText("Welcome to my Site");
    btnWelcome.setStyle(" -fx-font-size:14px; "
            + "-fx-text-fill: black;"
            + "-fx-background-color: #ff0;"
            + " -fx-font-weight: bold");
     
      
    //button event handler
    btnWelcome.setOnAction((ActionEvent event) -> {
    MyApp2.getMainScreen().changeScreen(1);
    });
    background=new ImageView(new Image(getClass().getResourceAsStream("Watchff.jpg")));
    }

    //add the child nodes to the layout
    private void addNodesToLayout() {
    //add to the this objects layout
    stackPane.getChildren().addAll(background,btnWelcome);
    //add to the applications layout
    getChildren().add(stackPane);
    }
}
