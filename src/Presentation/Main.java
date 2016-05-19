package Presentation;

import Application.DataTypes.Admin;
import Application.DataTypes.Booking;
import Application.DataTypes.Flight;
import Application.DataTypes.Schedule;
import DataAccess.AdminData;
import DataAccess.ScheduleData;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.text.View;
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
        System.out.println(schedules);



       // System.out.println(admins);
        //primaryStage setup
        primaryStage.setTitle("Hermes Airlines");
        primaryStage.setScene(FlightsScene.getScene());
        primaryStage.show();



    }

}
