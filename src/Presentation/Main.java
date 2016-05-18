package Presentation;

import Presentation.LoginScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * MAIN CLASS - HERMES AIRLINES ---
 */


public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    //start method
    public void start(Stage primaryStage)throws Exception {

        //scenes initialization
        LoginScene.initialize();
        BookingScene.initialize();

        //primaryStage setup
        primaryStage.setTitle("Hermes Airlines");
        primaryStage.setScene(BookingScene.getScene());
        primaryStage.show();
    }

}
