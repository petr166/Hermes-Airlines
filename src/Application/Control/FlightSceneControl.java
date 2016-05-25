package Application.Control;

import Application.DataTypes.*;
import DataAccess.FlightData;
import DataAccess.FlightTableData;
import Presentation.FlightsScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
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
    private static TextField search;
    private static Button backB, viewCustomB, addB, editB;

    //initialize
    public static void initialize(){

        table = FlightsScene.getTable();
        table.setItems(FlightTableData.getFlightTableItems());

        editB = FlightsScene.getEditB();
        editB.setOnAction(e -> handle_editB());



        search = FlightsScene.getSearch();




    }

    public static void handle_editB(){
        FlightTable flightTable = table.getSelectionModel().getSelectedItem();
        Flight flight = new Flight();
        if(flightTable!=null){
            boolean okPressed = MainControl.showFlightEditScene(flightTable,flight);
            if(okPressed){

                FlightData.updateFlight(flight);
            }
        }

    }


}
