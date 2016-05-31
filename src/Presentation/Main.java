package Presentation;

import Application.Control.*;
import DataAccess.DataConnection;
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

        //connect to database
        DataConnection.connect();

        //show the login screen
        MainControl.showLoginScene();

    }

}
