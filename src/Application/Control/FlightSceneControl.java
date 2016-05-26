package Application.Control;

import Application.DataTypes.*;
import DataAccess.CustomerData;
import DataAccess.FlightData;
import DataAccess.FlightTableData;
import Presentation.FlightsScene;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

/**
 * Created by Administrator on 5/23/2016.
 */

public class FlightSceneControl {

    //fields
    private static TableView<FlightTable> table;
    private static ObservableList<FlightTable> flights, tableItems;
    private static TextField search;
    private static Button backB, viewCustomB, addB, editB;

    //initialize
    public static void initialize(){

        table = FlightsScene.getTable();
        table.setItems(FlightTableData.getFlightTableItems());

        backB = FlightsScene.getBackB();
        backB.setOnAction(e -> handle_backB());

        addB = FlightsScene.getAddB();
        addB.setOnAction(e -> handle_addB());

        editB = FlightsScene.getEditB();
        editB.setOnAction(e -> handle_editB());

        viewCustomB = FlightsScene.getViewCustomB();
        //viewCustomB.setOnAction(e -> handle_viewCustomB());

        search = FlightsScene.getSearch();
        flights = table.getItems();
        initializeSearch();


    }


    //handle_addB
    public static void handle_addB() {
        FlightTable flightTable = new FlightTable("2016-07-15", "2016-07-15");
        Flight flight = new Flight();

        boolean okPressed = MainControl.showFlightEditScene(flightTable,flight);
        if(okPressed) {
            flight = FlightEditSceneControl.getFlight();
            FlightData.insertFlight(flight);
            FlightTableData.getList().add(FlightEditSceneControl.getFlightTable());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(MainControl.getWindow());
            alert.setContentText("Flight added!");
            alert.showAndWait();
        }
    }


    public static void handle_editB(){
        FlightTable flightTable = table.getSelectionModel().getSelectedItem();
        Flight flight = new Flight();

        if(flightTable != null) {
            boolean okPressed = MainControl.showFlightEditScene(flightTable,flight);
            if(okPressed){
                flight = FlightEditSceneControl.getFlight();
                FlightData.updateFlight(flight);
                //FlightTableData.getList().set(flightTable.getFlight_id() - 1, flightTable);
               // MainControl.showFlightsScene();
                table.setItems(FlightTableData.getFlightTableItems());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initOwner(MainControl.getWindow());
                alert.setContentText("Flight edited!");
                alert.showAndWait();
            }
        }

        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MainControl.getWindow());
            alert.setHeaderText("Select flight!");
            alert.setContentText("No flight selected!");
            alert.showAndWait();
        }
    }



    //back button action
    public static void handle_backB(){ MainControl.showMenuScene(); }


    //search bar setup
    public static void initializeSearch(){
        search.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (search.textProperty().get().isEmpty()) {
                    table.setItems(flights);
                    return;
                }

                tableItems = FXCollections.observableArrayList();

                for(FlightTable f : flights){
                    if(f.getDeparture_city().toUpperCase().contains(search.getText().toUpperCase()) ||
                    f.getArrival_city().toUpperCase().contains(search.getText().toUpperCase())){

                        tableItems.add(f);
                    }
                }

                table.setItems(tableItems);
            }
        });
    }

    public static TableView<FlightTable> getTable() {
        return table;
    }
}
