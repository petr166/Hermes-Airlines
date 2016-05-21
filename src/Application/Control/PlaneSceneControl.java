package Application.Control;

import Application.DataTypes.Plane;
import DataAccess.PlaneData;
import Presentation.PlaneEditScene;
import Presentation.PlaneScene;
import javafx.beans.property.IntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sun.security.tools.keytool.Main;

/**
 * Created by Administrator on 5/19/2016.
 */
public class PlaneSceneControl {

    //fields
    private static TableView<Plane> table;
    private static TableColumn plane_idColumn;
    private static TableColumn plane_nameColumn;
    private static TableColumn first_classColumn;
    private static TableColumn coachColumn;
    private static TableColumn economyColumn;
    private static Button addButton;
    private static Button removeButton;
    private static Button cancelButton;
    private static Button editButton;



    //initialization of fields
    public static void initialize(){
        //table
        table = PlaneScene.getTable();


        table.setItems(PlaneData.getPlanes());
        //plane_id column
        plane_idColumn = PlaneScene.getPlane_idColumn();

        //plane_name Column
        plane_nameColumn = PlaneScene.getPlane_nameColumn();

        //classes
        first_classColumn = PlaneScene.getFirst_classColumn();

        coachColumn = PlaneScene.getCoachColumn();

        economyColumn = PlaneScene.getEconomyColumn();

        //addButton
        addButton =  PlaneScene.getAddButton();
        addButton.setOnAction(e -> handle_addButton());

        //removeButton
        removeButton = PlaneScene.getRemoveButton();
        removeButton.setOnAction(e -> handle_removeButton());


        //cancelButton
        cancelButton = PlaneScene.getCancelButton();
        cancelButton.setOnAction(e -> handle_cancelButton());

        //editButton
        editButton = PlaneScene.getEditButton();
        editButton.setOnAction(e -> handle_editButton());


    }

    //handle_removeButton
    public static void handle_removeButton(){
        Plane plane = table.getSelectionModel().getSelectedItem();
        if(plane!=null) {
            PlaneData.deletePlane(plane);
           // table.getItems().remove(plane);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MainControl.getWindow());
            alert.setHeaderText("Select plane!");
            alert.setContentText("No plane selected!");
            alert.showAndWait();
        }
    }

    //handle_addB
    public static void handle_addButton(){
        Plane plane = new Plane();
        boolean okPresed = MainControl.showPlaneEditStage(plane);
        if(okPresed){

            PlaneData.insertPlanes(plane);
        }
    }

    //handle_editB
    public static void handle_editButton(){
        Plane plane = table.getSelectionModel().getSelectedItem();
        if(plane!=null){
            boolean okPressed = MainControl.showPlaneEditStage(plane);
            PlaneData.updatePlane(plane);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MainControl.getWindow());
            alert.setHeaderText("Select plane!");
            alert.setContentText("No plane selected!");
            alert.showAndWait();
        }
    }

    //handle cancel
    public static void handle_cancelButton(){
        MainControl.showMenuScene();
    }

}
