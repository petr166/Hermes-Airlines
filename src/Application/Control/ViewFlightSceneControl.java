package Application.Control;

import Application.DataTypes.*;
import DataAccess.FlightData;
import DataAccess.FlightTableData;
import DataAccess.PlaneData;
import Presentation.ViewFlightsScene;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;


/**
 * Created by Administrator on 5/23/2016.
 */

public class ViewFlightSceneControl {

    //fields
    private static TableView<FlightTable> table;
    private static ObservableList<FlightTable> flights, tableItems;
    private static TextField search;
    private static Button backB, addB, editB, exportFlightsB;

    //initialize
    public static void initialize(){

        table = ViewFlightsScene.getTable();
        table.setItems(FlightTableData.getFlightTableItems());

        backB = ViewFlightsScene.getBackB();
        backB.setOnAction(e -> handle_backB());

        addB = ViewFlightsScene.getAddB();
        addB.setOnAction(e -> handle_addB());

        editB = ViewFlightsScene.getEditB();
        editB.setOnAction(e -> handle_editB());

        exportFlightsB = ViewFlightsScene.getExportFlightsB();
        exportFlightsB.setOnAction(event -> handle_exportFlightsB());


        search = ViewFlightsScene.getSearch();
        flights = table.getItems(); //set search arrayList items
        initializeSearch();

    }


    //add button action
    public static void handle_addB() {
        FlightTable flightTable = new FlightTable("2016-07-15");
        Flight flight = new Flight();

        boolean okPressed = MainControl.showFlightEditScene(flightTable,flight);

        if(okPressed) {
            flight = FlightEditSceneControl.getFlight();

            //getting the seat info from plane database
            for(Plane p: PlaneData.getPlanes()){
                if(p.getPlane_id()==flight.getPlane_id()){
                    flight.setFirst_class_left(p.getFirst_class());
                    flight.setCoach_left(p.getCoach());
                    flight.setEconomy_left(p.getEconomy());
                }
            }

            FlightData.insertFlight(flight); //add flight to database

            table.setItems(FlightTableData.getFlightTableItems()); //set the table items
            flights = table.getItems();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(MainControl.getWindow());
            alert.setContentText("Flight added!");
            alert.showAndWait();

            System.out.println("new flight added");
        }
    }



    //edit button action
    public static void handle_editB(){
        FlightTable flightTable = table.getSelectionModel().getSelectedItem();
        Flight flight = new Flight();

        if(flightTable != null) {
            boolean okPressed = MainControl.showFlightEditScene(flightTable, flight);

            if (okPressed) {
                flight = FlightEditSceneControl.getFlight();
                FlightData.updateFlight(flight); //update flight in database

                table.setItems(FlightTableData.getFlightTableItems()); //set the table items
                flights = table.getItems();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initOwner(MainControl.getWindow());
                alert.setContentText("Flight edited!");
                alert.showAndWait();

                System.out.println("a flight edited");
            }
        }

        else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(MainControl.getWindow());
                alert.setHeaderText("Select flight!");
                alert.setContentText("No flight selected!");
                alert.showAndWait();
            }

    }


    //back button action
    public static void handle_backB(){ MainControl.showMenuScene(); }


    //export button action
    public static void handle_exportFlightsB() {
        FlightData.getFlight();
        FlightData.exportFlights();
    }


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

}
