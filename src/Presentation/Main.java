package Presentation;

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

        //scenes initialization

        LoginScene.initialize();
        ViewBookingScene.initialize();
        MenuScene.initialize();
        FlightsScene.initialize();
        PlaneScene.initialize();
        BookingScene.initialize();
        CustomerScene.initialize();
        ArrayList<Schedule> schedules= ScheduleData.getSchedules();
        ArrayList<Flight> flights =  FlightData.getFlight();
        //System.out.println(schedules);
       // System.out.println(flights);
        ArrayList<Plane> planes = PlaneData.getPlanes();
        Plane plane = new Plane(3, 20, 40, 40, "Hermes01");
        System.out.println(planes);
        PlaneData.insertPlanes(plane);
        System.out.println(planes);
        //primaryStage setup
        primaryStage.setTitle("Hermes Airlines");
        primaryStage.setScene(FlightsScene.getScene());
        primaryStage.show();



    }

}
