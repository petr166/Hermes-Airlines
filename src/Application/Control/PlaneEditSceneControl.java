package Application.Control;

import Application.DataTypes.Plane;
import Presentation.PlaneEditScene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/**
 * Created by Administrator on 5/21/2016.
 */

public class PlaneEditSceneControl {

    //fields
    private static Button okB;
    private static Button cancelB;
    private static TextField plane_nameT, firstClassT, coachT, economyT;
    private static Plane plane = new Plane();
    private static boolean okPressed = false;


    //initialize method
    public static void initialize(){
        //buttons
        okB = PlaneEditScene.getOkB();
        okB.setOnAction(e -> handle_okB());

        cancelB = PlaneEditScene.getCancelB();
        cancelB.setOnAction(e -> handleClose());

        //text fields
        plane_nameT = PlaneEditScene.getPlane_nameT();

        firstClassT = PlaneEditScene.getFirstClassT();

        coachT = PlaneEditScene.getCoachT();

        economyT = PlaneEditScene.getEconomyT();

    }


    //set plane
    public static void setPlane(Plane p) {
        plane = p;

        plane_nameT.setText(plane.getPlane_name());
        firstClassT.setText(Integer.toString(plane.getFirst_class()));
        coachT.setText(Integer.toString(plane.getCoach()));
        economyT.setText(Integer.toString(plane.getEconomy()));

    }


    public static boolean isOkPressed() { return okPressed; }



    public static void handle_okB(){
        if(isInputValid()){
            plane.setPlane_name(plane_nameT.getText());
            plane.setFirst_class(Integer.parseInt(firstClassT.getText()));
            plane.setCoach(Integer.parseInt(coachT.getText()));
            plane.setEconomy(Integer.parseInt(economyT.getText()));
            okPressed = true;
            PlaneEditScene.getDialogStage().close();
        }
    }



    public static void handleClose(){
        okPressed = false;
        PlaneEditScene.getDialogStage().close();
    }


    public static boolean isInputValid(){
        String error = "";
        if(plane_nameT != null || !plane_nameT.getText().isEmpty())
            error += "Invalid plane name!\n";

        if(firstClassT != null || !firstClassT.getText().isEmpty())
            error += "Invalid number of seats for first class!\n";
        else
            try{Integer.parseInt(firstClassT.getText());}
        catch(NumberFormatException e){
            error += "Invalid number of seats for first class!\n";
        }

        if(coachT != null || !coachT.getText().isEmpty())
            error += "Invalid number of seats for coach class!\n";
        else
            try{Integer.parseInt(coachT.getText());}
            catch(NumberFormatException e){
                error += "Invalid number of seats for coach class!\n";
            }

        if(economyT != null || !economyT.getText().isEmpty())
            error += "Invalid number of seats for economy class!\n";
        else
            try{Integer.parseInt(economyT.getText());}
            catch(NumberFormatException e){
                error += "Invalid number of seats for economy class!\n";
            }

        if(error.equals(""))
            return true;

        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MainControl.getWindow());
            alert.setContentText(error);
            alert.setHeaderText("Invalid input!");
            alert.showAndWait();
            return false;
        }
    }


    //getters
    public static Plane getPlane() { return plane; }

}
