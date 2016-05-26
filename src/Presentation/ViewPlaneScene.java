package Presentation;

import Application.DataTypes.Plane;
import DataAccess.PlaneData;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by Administrator on 5/18/2016.
 */

public class ViewPlaneScene {

    //table
    private static TableView<Plane> table;
    private static TableColumn<Plane, Integer> plane_idColumn;
    private static TableColumn<Plane, String> plane_nameColumn;
    private static TableColumn<Plane, Integer> first_classColumn;
    private static TableColumn<Plane, Integer> coachColumn;
    private static TableColumn<Plane, Integer> economyColumn;
    private static Button addButton;
    private static Button backButton;
    private static Button editButton;
    private static VBox buttonsVbox;
    private static Pane layout;
    private static Scene scene;


    //initialization
    public static void initialize(){

        //table
        table=new TableView();
        table.relocate(28,34);
        table.setMinHeight(609);
        table.setMinWidth(950);


        //ID
        plane_idColumn=new TableColumn("ID");
        plane_idColumn.setCellValueFactory(cellData -> cellData.getValue().plane_idProperty().asObject());
        plane_idColumn.setMinWidth(190);


        //plane_name
        plane_nameColumn=new TableColumn("Name");
        plane_nameColumn.setCellValueFactory(cellData->cellData.getValue().plane_nameProperty());
        plane_nameColumn.setMinWidth(190);


        //fare classes
        first_classColumn = new TableColumn("First Class");
        first_classColumn.setCellValueFactory(cellData -> cellData.getValue().first_classProperty().asObject());
        first_classColumn.setMinWidth(190);

        coachColumn = new TableColumn("Coach Class");
        coachColumn.setCellValueFactory(cellData->cellData.getValue().coachProperty().asObject());
        coachColumn.setMinWidth(190);

        economyColumn = new TableColumn("Economy Class");
        economyColumn.setCellValueFactory(cellData->cellData.getValue().economyProperty().asObject());
        economyColumn.setMinWidth(190);

        table.getColumns().addAll(plane_idColumn,plane_nameColumn,first_classColumn,coachColumn,economyColumn);

        //add
        addButton = new Button("Add");

        //back
        backButton = new Button("Back");

        //edit
        editButton = new Button("Edit");

        //buttons layout
        buttonsVbox = new VBox();
        buttonsVbox.getChildren().addAll(addButton,editButton,backButton);
        buttonsVbox.setSpacing(25);
        buttonsVbox.relocate(1020,250);


        //scene setup
        layout=new Pane();
        layout.getChildren().addAll(table,buttonsVbox);
        scene = new Scene(layout,1200,700);

    }


    //getters

    public static Pane getLayout() {
        return layout;
    }

    public static Scene getScene() {
        return scene;
    }

    public static TableView getTable() {
        return table;
    }

    public static TableColumn getPlane_idColumn() {
        return plane_idColumn;
    }

    public static TableColumn getPlane_nameColumn() {
        return plane_nameColumn;
    }

    public static TableColumn getFirst_classColumn() {
        return first_classColumn;
    }

    public static TableColumn getCoachColumn() {
        return coachColumn;
    }

    public static TableColumn getEconomyColumn() {
        return economyColumn;
    }

    public static Button getAddButton() {
        return addButton;
    }

    public static Button getBackButton() {
        return backButton;
    }

    public static Button getEditButton() {
        return editButton;
    }

    public static VBox getButtonsVbox() {
        return buttonsVbox;
    }
}
