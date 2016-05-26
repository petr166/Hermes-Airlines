package Application.Control;

import Application.DataTypes.Customer;
import Application.DataTypes.Flight;
import Application.DataTypes.FlightTable;
import Application.DataTypes.Plane;
import Presentation.*;
import javafx.stage.Stage;

/**
 * Created by Administrator on 5/19/2016.
 */

public class MainControl {


    //fields
    public static Stage window = new Stage();


    //show-scene methods
    public static void showMenuScene(){
        //initialization of scene
        MenuScene.initialize();

        //initialization of controller
        MenuSceneControl.initialize();

        //set scene
        window.setScene(MenuScene.getScene());
        window.centerOnScreen();

    }


    public static void showLoginScene() {
        //initialization of scene
        LoginScene.initialize();

        //initialization of actions
        LoginSceneControl.initialize();


        //set scene
        window.setScene(LoginScene.getScene());

        window.show();
        window.centerOnScreen();
    }


    //viewBookingScene
    public static void showViewBookingScene(){
        //initialization of scene
        ViewBookingScene.initialize();

        //initialization of actions
        //ViewBookingSceneControl.initialize();

        //set scene
        window.setScene(ViewBookingScene.getScene());
    }


    public static void showViewCustomerScene(){
        //initialization of scene
        ViewCustomersScene.initialize();

        //initialization of controller
        ViewCustomerSceneControl.initialize();

        //set scene
        window.setScene(ViewCustomersScene.getScene());
    }


    public static void showFlightsScene(){
        //initialization of scene
        ViewFlightsScene.initialize();

        //initialization of controller
        ViewFlightSceneControl.initialize();

        //set scene
        window.setScene(ViewFlightsScene.getScene());
    }


    public static void showPlaneScene(){
        //initialization of scene
        ViewPlaneScene.initialize();

        //initialization of controller
        ViewPlaneSceneControl.initialize();

        //set scene
        window.setScene(ViewPlaneScene.getScene());
    }


    public static boolean showPlaneEditStage(Plane plane){
        //initialization of scene
        PlaneEditScene.initialize();

        //initialization of control
        PlaneEditSceneControl.initialize();

        PlaneEditSceneControl.setPlane(plane);
        PlaneEditScene.getDialogStage().initOwner(window);
        PlaneEditScene.getDialogStage().showAndWait();

        return PlaneEditSceneControl.isOkPressed();
    }


    public static boolean showCustomerEditScene(Customer customer){
        //initialization of scene
        CustomerEditScene.initialize();

        //initialization of control
        CustomerEditSceneControl.initialize();
        CustomerEditSceneControl.setCustomer(customer);

        CustomerEditScene.getDialogStage().initOwner(window);
        CustomerEditScene.getDialogStage().showAndWait();

        return CustomerEditSceneControl.isOkPressed();
    }

    public static boolean showFlightEditScene(FlightTable flightTable, Flight flight){

        //initialization of scene
      //  FlightsEditScene.initialize();

        //initialization of controller
        //FlightEditSceneControl.initialize();
        FlightEditSceneControl.setFlight(flightTable,flight);

      // FlightsEditScene.getDialogStage().initOwner(window);
        FlightsEditScene.getDialogStage().showAndWait();
        return FlightEditSceneControl.isOkPressed();
    }


    //getters
    public static Stage getWindow() {
        return window;
    }

}
