package Presentation;

import Application.Control.*;
import Application.DataTypes.*;
import DataAccess.AdminData;
import DataAccess.FlightData;
import DataAccess.PlaneData;
import DataAccess.ScheduleData;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.text.View;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * MAIN CLASS - HERMES AIRLINES ---
 */


public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    //start method
    public void start(Stage primaryStage)throws Exception {
        //start app
        MainControl.showLoginScene();




    }

}
