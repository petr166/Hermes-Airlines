package Application.Control;

import Application.DataTypes.Plane;
import Presentation.*;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Administrator on 5/19/2016.
 */
public class MainControl {

    //fields
    public static Stage window = new Stage();
    public static Scene scene;

    //start method
   /* public static void start(){

    }*/

    //show-scene methods
    public static void showMenuScene(){
        //initializatinn of scene
        MenuScene.initialize();

        //initialization of controller
        MenuSceneControl.initialize();

        //set scene
        scene = MenuScene.getScene();
        window.setScene(scene);
        window.show();
    }


    public static void showLoginScene(){
        //initialization of scene
        LoginScene.initialize();

        //initialization of actions
        LoginSceneControl.initialize();


        //set scene
        scene = LoginScene.getScene();
        window.setScene(scene);

        window.show();

    }

    //viewBookingScene
    public static void showViewBookingScene(){
        //initialization of scene
        ViewBookingScene.initialize();

        //initialization of actions
        //ViewBookingSceneControl.initialize();

        //set scene
        scene = ViewBookingScene.getScene();
        window.setScene(scene);
        window.show();
    }


    public static void showViewCustomerScene(){
        //initialization of scene
        ViewCustomersScene.initialize();

        //initialization of controller
        //CustomerSceneControl.initialize();

        //set scene
        scene = ViewCustomersScene.getScene();
        window.setScene(scene);
        window.show();
    }


    public static void showFlightsScene(){
        //initialization of scene
        FlightsScene.initialize();

        //initialization of controller
        //FlightsSceneControl.initialize();

        //set scene
        scene = FlightsScene.getScene();
        window.setScene(scene);
        window.show();
    }

    public static void showPlaneScene(){
        //initialization of scene
        PlaneScene.initialize();

        //initialization of controller
        PlaneSceneControl.initialize();

        //set scene
        scene = PlaneScene.getScene();
        window.setScene(scene);
        window.show();
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



    //getters
    public static Stage getWindow() {
        return window;
    }

    public static Scene getScene() {
        return scene;
    }
}
