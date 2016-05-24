package Application.Control;

import Application.DataTypes.*;
import DataAccess.FlightTableData;
import Presentation.FlightsScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

/**
 * Created by Administrator on 5/23/2016.
 */
public class FlightSceneControl {

    //fields
    private static TableView<FlightTable> table;
  //  private static TableColumn dateColumn, routeColumn, priceColumn, bookingsColumn;
    private static TextField search;


    //initialize
    public static void initialize(){
        table = FlightsScene.getTable();
        System.out.println(FlightTableData.getFlightTableItems().get(1));
        table.setItems(FlightTableData.getFlightTableItems());
      /*  dateColumn = new TableColumn<Schedule, String>("Date");
        routeColumn = new TableColumn<Airline, String>("Route");
        priceColumn = new TableColumn<Flight, Double>("Price");
        bookingsColumn = new TableColumn<Flight, Integer>("Bookings");
        dateColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("departure_date"));
        routeColumn .setCellValueFactory(new PropertyValueFactory<Airline,String>("departure_city"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Flight, Double>("price"));
        bookingsColumn.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("first_class_left"));
    */
        search = FlightsScene.getSearch();




    }


}
