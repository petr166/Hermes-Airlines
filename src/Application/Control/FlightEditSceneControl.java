package Application.Control;

import Application.DataTypes.*;
import DataAccess.*;
import Presentation.FlightsEditScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Administrator on 5/25/2016.
 */

public class FlightEditSceneControl {

    private static TextField price;
    private static ComboBox<String> routeC,departure_time, arrival_time;
    private static ComboBox<Integer> plane_id;
    private static DatePicker departure_date;
    private static Button okB, cancelB;
    private static boolean okPressed = false;
    private static Flight flight;
    private static FlightTable flightTable;


    //initialize
    public static void initialize(){

        //price
        price = FlightsEditScene.getPrice();

        //route
        routeC = FlightsEditScene.getRouteC();
        for(Airline airline: AirlineData.getAirlines()){
            if(!routeC.getItems().contains(airline.getDeparture_city() + " -> " + airline.getArrival_city()))
                routeC.getItems().add(airline.getDeparture_city() + " -> " + airline.getArrival_city());
        }

        //plane
        plane_id = FlightsEditScene.getPlane_id();
        for(Plane p : PlaneData.getPlanes()){
            if(!plane_id.getItems().contains(p.getPlane_id()))
                plane_id.getItems().add(p.getPlane_id());
        }


        //flight times setup
        departure_time= FlightsEditScene.getDeparture_time();
        arrival_time = FlightsEditScene.getArrival_time();

        ObservableList<String> times = FXCollections.observableArrayList();
        for(int i=1; i<=24; i++) {
            times.add(i + ":00");
        }

        departure_time.setItems(times);
        arrival_time.setItems(times);


        //departure date picker
        departure_date = FlightsEditScene.getDeparture_date();


        //ok button
        okB = FlightsEditScene.getOkB();
        okB.setOnAction( e -> handle_okB());


        //cancel button
        cancelB = FlightsEditScene.getCancelB();
        cancelB.setOnAction( e-> handleClose());

    }


    //setting flight for edit
    public static void setFlight(FlightTable f,Flight flig){

            flightTable = f;
            flight = flig;

            for(Flight fl: FlightData.getFlight()) {
                if (fl.getFlight_id() == flightTable.getFlight_id()) {
                    flight = fl;
                    break;
                }
            }

            Schedule schedule = new Schedule();
            for(Schedule s : ScheduleData.getSchedules()) {
                if (s.getSchedule_id() == flight.getSchedule_id()) {
                    schedule = s;
                    break;
                }
            }

            routeC.setValue(flightTable.getDeparture_city() + " -> " + f.getArrival_city());
            plane_id.setValue(flight.getPlane_id());
            departure_date.setValue(LocalDate.parse(flightTable.getDeparture_date()));
            departure_time.setValue(schedule.getDeparture_time());
            arrival_time.setValue(schedule.getArrival_time());
            price.setText(Double.toString(flightTable.getPrice()));

    }



    //ok button action
    public static void handle_okB(){
        if(isInputValid()){

        flight.setPlane_id(plane_id.getValue());

        String route = routeC.getValue();

        for(Airline a : AirlineData.getAirlines()){
            if((a.getDeparture_city() + " -> " + a.getArrival_city()).equalsIgnoreCase(route)){
                flight.setAirline_id(a.getAirline_id());
            }
        }

        Schedule schedule = new Schedule();
        schedule.setDeparture_time(departure_time.getValue());
        schedule.setArrival_time(arrival_time.getValue());
        schedule.setDeparture_date(Date.valueOf(departure_date.getValue()));
        schedule.setArrival_date(Date.valueOf(departure_date.getValue()));
        ScheduleData.insertSchedule(schedule);

        for(Schedule s: ScheduleData.getSchedules())
           if(s.getDeparture_date().equals(schedule.getDeparture_date()) && s.getArrival_date().equals(schedule.getArrival_date()))
               flight.setSchedule_id(s.getSchedule_id());

            flight.setPrice(Double.parseDouble(price.getText()));

        okPressed = true;
        FlightsEditScene.getDialogStage().close();
        }

    }


    //cancel button action
    public static void handleClose(){
        okPressed = false;
        FlightsEditScene.getDialogStage().close();
    }


    //method to verify user input
    public static boolean isInputValid(){
        String error = "";

       if(routeC.getValue().equalsIgnoreCase(" -> "))
        error += "Invalid route!\n";


        if(price.getText().length()<1)
            error+="Invalid base price!\n";
        else try{
            Double.parseDouble(price.getText());
        }
        catch(NumberFormatException e){
            error += "Invalid base price!\n";
        }

        if(error=="")
            return true;
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(FlightsEditScene.getDialogStage());
            alert.setContentText(error);
            alert.setHeaderText("Invalid input!");
            alert.showAndWait();
            return false;
        }
    }


    //getters
    public static Flight getFlight() {
        return flight;
    }

    public static boolean isOkPressed(){ return okPressed; }

}
