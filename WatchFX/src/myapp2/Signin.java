/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author BHUIYAN
 */
public class Signin extends Parent {
    // layout for this screen - GridPane
     private GridPane grid;
     ImageView background;
     
     // UI nodes
     private Label nameLabel;
     private TextField nameInput;
     private Label passLabel;
     private TextField passInput;
     private Button signinButton;
     private Button forgotPassword;
  
     // Login constructor
    public Signin() 
    {
        createNodesForUI();
        
        addNodesToLayout();     
    }
// create the nodes objects for the UI
    private void createNodesForUI() {
         //GridPane with 10px padding around edge
        grid = new GridPane();
        grid.setPrefSize(980,600);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(15, 15, 15, 15));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-background-color:tan");
        Text scenetitle = new Text("Welcome to Signin Page");
        //scenetitle.setId("welcome-text");
        scenetitle.setStyle(" -fx-font-size:18px; "
               + "-fx-text-fill: white;"
               + "-fx-background-color: blue;"
               + " -fx-font-weight: bold");
         
        //background=new ImageView(new Image(getClass().getResourceAsStream("watch1.jpg")));
        scenetitle.setFill(Color.FIREBRICK);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 34));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        //Name Label - constrains use (child, column, row)
        nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 1);
        nameLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        
        //Name Input
        nameInput = new TextField("TAHMINA BHUIYAN");
       // nameInput.setPromptText("User Name");
        GridPane.setConstraints(nameInput, 1, 1);

        //Password Label
        passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 2);
        passLabel.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));

        //Password Input
        passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 2);

        //Login
        signinButton = new Button("Signin");
        signinButton.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
        //HBox hbBtn=new HBox(10);
       // hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        //hbBtn.getChildren().add(signinButton);
        //grid.add(hbBtn, 1, 4);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 7);
        actiontarget.setId("actiontarget");
        // actiontarget.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        GridPane.setConstraints(signinButton, 1, 4);
        forgotPassword = new Button("Forgot Password");
        GridPane.setConstraints(forgotPassword, 1, 5); 
       
        // button event handler
        signinButton.setOnAction((ActionEvent event) -> {
        System.out.println("Signin Successfully");
        // actiontarget.setFill(Color.FIREBRICK);
        MyApp2.getMainScreen().changeScreen(2);
        });
        forgotPassword.setOnAction((ActionEvent event) -> {
        actiontarget.setText("Set Your Password again");
        System.out.println("Set Password");
        // actiontarget.setFill(Color.FIREBRICK);
        
        });
       
    }

    private void addNodesToLayout() {
    //Add everything to grid
    grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, signinButton,forgotPassword);
    getChildren().add(grid);
    
         
    }
    
    
    
}
