package Presentation;

import Application.Control.*;
import Application.DataTypes.Booking;
import Application.DataTypes.BookingTable;
import Application.DataTypes.Customer;
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
        //start app
        MainControl.showLoginScene();

        /*MainControl.showBookingEditScene(new BookingTable(), new Booking());*/

    }

}
