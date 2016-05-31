package Presentation;

import Application.DataTypes.FlightTable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Created by Petru on 18-May-16.
 */

public class ViewFlightsScene {

    //fields
    private static Pane layout;
    private static Scene scene;
    private static TableView<FlightTable> table;
    private static TableColumn<FlightTable, Integer> flight_idColumn, economyColumn, coachColumn, first_classColumn;
    private static TableColumn<FlightTable, String> departure_dateColumn, departure_cityColumn, arrival_cityColumn;
    private static TableColumn<FlightTable, Double> priceColumn;
    private static TextField search;
    private static HBox buttonLayout;
    private static Button backB, addB, editB, exportFlightsB;


    //initialization of objects
    public static void initialize() {

        //table
        table = new TableView<>();
        table.setMinSize(1116,591);
        table.relocate(42,32);

        //initialize columns
        flight_idColumn = new TableColumn<>("ID");
        flight_idColumn.setCellValueFactory(cellData -> cellData.getValue().flight_idProperty().asObject());

        departure_dateColumn = new TableColumn<>("Departure date");
        departure_dateColumn.setCellValueFactory(cellData -> cellData.getValue().departure_dateProperty());

        departure_cityColumn = new TableColumn<>("Departure city");
        departure_cityColumn.setCellValueFactory(cellData -> cellData.getValue().departure_cityProperty());

        arrival_cityColumn = new TableColumn<>("Arrival city");
        arrival_cityColumn.setCellValueFactory(cellData -> cellData.getValue().arrival_cityProperty());

        priceColumn = new TableColumn<>("Basic price");
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        economyColumn = new TableColumn<>("Eco seat");
        economyColumn.setCellValueFactory(cellData -> cellData.getValue().economyLeftProperty().asObject());

        coachColumn = new TableColumn<>("Coach seat");
        coachColumn.setCellValueFactory(cellData -> cellData.getValue().coachLeftProperty().asObject());

        first_classColumn = new TableColumn<>("First seat");
        first_classColumn.setCellValueFactory(cellData -> cellData.getValue().first_classLeftProperty().asObject());

        table.getColumns().addAll(flight_idColumn,departure_dateColumn,departure_cityColumn,arrival_cityColumn,priceColumn,economyColumn,coachColumn,first_classColumn);

        //search field
        search = new TextField();
        search.setPromptText("search");
        search.setMinWidth(545);
        search.relocate(42,642);

        //back butt
        backB = new Button("Back");

        //add butt
        addB = new Button("Add");

        //edit butt
        editB = new Button("Edit");

        //exportFlightsB
        exportFlightsB = new Button("Export Flights");

        //button layout
        buttonLayout = new HBox(20);
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.relocate(685,635);
        buttonLayout.getChildren().addAll(backB,addB,editB,exportFlightsB);

        //layout setup
        layout = new Pane();
        layout.getChildren().addAll(table,search,buttonLayout);

        //scene
        scene = new Scene(layout, 1200, 700);

        System.out.println("flights scene initialized");
    }


    //getters
    public static Pane getLayout() {
        return layout;
    }

    public static Scene getScene() {
        return scene;
    }

    public static TableView<FlightTable> getTable() {
        return table;
    }

    public static TableColumn<FlightTable, Integer> getFlight_idColumn() {
        return flight_idColumn;
    }

    public static TableColumn<FlightTable, Integer> getEconomyColumn() {
        return economyColumn;
    }

    public static TableColumn<FlightTable, Integer> getCoachColumn() {
        return coachColumn;
    }

    public static TableColumn<FlightTable, Integer> getFirst_classColumn() {
        return first_classColumn;
    }

    public static TableColumn<FlightTable, String> getDeparture_dateColumn() {
        return departure_dateColumn;
    }

    public static TableColumn<FlightTable, String> getDeparture_cityColumn() {
        return departure_cityColumn;
    }

    public static TableColumn<FlightTable, String> getArrival_cityColumn() {
        return arrival_cityColumn;
    }

    public static TableColumn<FlightTable, Double> getPriceColumn() {
        return priceColumn;
    }

    public static TextField getSearch() {
        return search;
    }

    public static HBox getButtonLayout() {
        return buttonLayout;
    }

    public static Button getBackB() {
        return backB;
    }

    public static Button getAddB() {
        return addB;
    }

    public static Button getEditB() {
        return editB;
    }

    public static Button getExportFlightsB() {
        return exportFlightsB;
    }

}

