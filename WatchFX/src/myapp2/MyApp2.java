/*
 * Class:           MyAppFx/ watchfx
 * Description:     Main application class & entry point - a JavaFX application
 */
package myapp2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author BHUIYAN
 */
public class MyApp2 extends Application {
    
  private static MainScreen mainScreen;
 
   public static MainScreen getMainScreen() {
        return mainScreen;
    }
   
    @Override
    public void start(Stage primaryStage) {
       Group root=new Group();
       mainScreen=new MainScreen(root);
        // create the main scene
        Scene scene = new Scene(root, 980, 600);
        mainScreen = new MainScreen(root);
        mainScreen.startApp();
        
        primaryStage.setTitle(" Watch Application");
       
      scene.getStylesheets().add
       (Signin.class.getResource("Signin.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //MainScreen constructor
 public class MainScreen{
// Main data controller object (provide access to content data)
private DataController dataController;
private Group root;
//screen
private Splash splash; //splash layout
private Signin signin;//Signin layout
private MainMenu mainMenu;
private Content content;
private WatchVideo contentVideo;
private ContentMenu contentMenu;
private WatchImage contentImage;
private Quiz2 quiz;
private Animation animation;
private ChartReport9 chartReport;
private Audio10 audio;
private TableView11 table;
private LinkLastPage12 link;
private Image13 imageNext;
private QuizAns14 quizAns;
private MainScreen(Group _root){
this.root=_root;
}
//start the app by openinig
public void startApp(){
dataController = new DataController();
splash=new Splash();
root.getChildren().addAll(splash);
} 
public DataController getDataController()
{
return dataController;
}
public void changeScreen(int screenNumber){
switch(screenNumber){    
case 1:
// login
root.getChildren().clear();
splash = null;
signin = new Signin();
root.getChildren().addAll(signin);
break;
case 2:
// menu
root.getChildren().clear();
signin = null;
mainMenu = new MainMenu();
root.getChildren().addAll(mainMenu);
break;
 case 3:
// content screen
  root.getChildren().clear();
  mainMenu = null;
  content = new Content();
  root.getChildren().addAll(content);                    
  break;
  case 4:
  // content video
  root.getChildren().clear();
  content = null;
  contentVideo = new WatchVideo();
  root.getChildren().addAll(contentVideo);
  break;
  case 5:
// content menu example
 root.getChildren().clear();
 mainMenu = null;
 contentMenu = new ContentMenu();
 root.getChildren().addAll(contentMenu);
 break;
 case 6:
//content Image
 root.getChildren().clear();
 mainMenu=null;
 contentImage=new WatchImage();
 root.getChildren().addAll(contentImage);
 break;
 case 7:
// Quiz
root.getChildren().clear();
mainMenu=null;
quiz=new Quiz2();
 root.getChildren().addAll(quiz);
 break;
 case 8:
//content Animation
root.getChildren().clear();
 mainMenu=null;
 animation=new Animation();
 root.getChildren().addAll(animation);
 break;
 case 9:
 //content Animation
 root.getChildren().clear();
 mainMenu=null;
 chartReport=new ChartReport9();
 root.getChildren().addAll(chartReport);
 break;
 case 10:
 //content Animation
 root.getChildren().clear();
 chartReport=null;
 audio=new Audio10();
 root.getChildren().addAll(audio);
 break;
  case 11:
 //content Animation
 root.getChildren().clear();
 mainMenu=null;
 table=new TableView11();
 root.getChildren().addAll(table);
 break;
 case 12:
 //content Animation
 root.getChildren().clear();
 mainMenu=null;
 link=new LinkLastPage12();
 root.getChildren().addAll(link);
 break;
 case 13:
 //next Image
 root.getChildren().clear();
 contentImage=null;
 imageNext=new Image13();
 root.getChildren().addAll(imageNext);
 case 14:
 //Answer page
 root.getChildren().clear();
 quiz=null;
 quizAns=new QuizAns14();
 root.getChildren().addAll(quizAns);
 
 default:
 }
 }
 }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
