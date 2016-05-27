package Presentation;

import Application.Control.*;
import Application.DataTypes.Booking;
import Application.DataTypes.BookingTable;
import Application.DataTypes.Customer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MAIN CLASS - HERMES AIRLINES ---
 */


public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    //start method
    public void start(Stage primaryStage)throws Exception {

        ViewFlightsScene.initialize();
        ViewFlightSceneControl.initialize();
        FlightsEditScene.initialize();
        FlightEditSceneControl.initialize();
        //start app
        MainControl.showLoginScene();

        /*MainControl.showBookingEditScene(new BookingTable(), new Booking());*/

    }


}
