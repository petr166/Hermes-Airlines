package Application.Control;

import Application.DataTypes.Plane;
import DataAccess.PlaneData;
import Presentation.ViewPlaneScene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 * Created by Administrator on 5/19/2016.
 */

public class ViewPlaneSceneControl {

    //fields
    private static TableView<Plane> table;
    private static Button addButton;
    private static Button backButton;
    private static Button editButton;
    private static Button exportPlaneB;

    //initialization of fields
    public static void initialize(){
        //table
        table = ViewPlaneScene.getTable();
        table.setItems(PlaneData.getPlanes());

        //addButton
        addButton =  ViewPlaneScene.getAddButton();
        addButton.setOnAction(e -> handle_addButton());


        //backButton
        backButton = ViewPlaneScene.getBackButton();
        backButton.setOnAction(e -> handle_backButton());

        //editButton
        editButton = ViewPlaneScene.getEditButton();
        editButton.setOnAction(e -> handle_editButton());

        //exportButton
        exportPlaneB = ViewPlaneScene.getExportPlaneB();
        exportPlaneB.setOnAction(event -> handle_exportButton());

    }


    //handle_addB
    public static void handle_addButton(){
        Plane plane = new Plane();
        boolean okPresed = MainControl.showPlaneEditStage(plane);

        if(okPresed) {
            PlaneData.insertPlanes(plane);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(MainControl.getWindow());
            alert.setContentText("Plane added!");
            alert.showAndWait();
        }
    }


    //handle_editB
    public static void handle_editButton(){
        Plane plane = table.getSelectionModel().getSelectedItem();

        if(plane!=null){

            boolean okPressed = MainControl.showPlaneEditStage(plane);
            if(okPressed){
            PlaneData.updatePlane(plane);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(MainControl.getWindow());
            alert.setContentText("Plane edited!");
            alert.showAndWait();}
        }

        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MainControl.getWindow());
            alert.setHeaderText("Select plane!");
            alert.setContentText("No plane selected!");
            alert.showAndWait();
        }
    }

    //handle export
    public  static  void handle_exportButton() {
        PlaneData.getPlanes();
        PlaneData.exportPlanes();
    }

    //handle back
    public static void handle_backButton(){
        MainControl.showMenuScene();
    }

}
