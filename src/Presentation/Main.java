package Presentation;

import javafx.application.Application;
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
        MenuScene.initialize();

        //primaryStage setup
        primaryStage.setTitle("Hermes Airlines");
        primaryStage.setScene(MenuScene.getScene());
        primaryStage.show();
    }

}
