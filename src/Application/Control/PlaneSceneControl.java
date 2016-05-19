package Application.Control;

import Application.DataTypes.Plane;
import DataAccess.PlaneData;
import Presentation.PlaneScene;
import javafx.beans.property.IntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Administrator on 5/19/2016.
 */
public class PlaneSceneControl {

    //fields
    private static TableView table;
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
        table.getItems().addAll(PlaneData.getPlanes());
        //plane_id column
        plane_idColumn = PlaneScene.getPlane_idColumn();

        //plane_name Column
        plane_nameColumn = PlaneScene.getPlane_nameColumn();

        //classes
        first_classColumn = PlaneScene.getFirst_classColumn();

        coachColumn = PlaneScene.getCoachColumn();

        economyColumn = PlaneScene.getEconomyColumn();


    }
    


}
