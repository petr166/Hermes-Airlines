package Application.Control;

import Application.DataTypes.*;
import DataAccess.*;
import Presentation.FlightsEditScene;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * Created by Administrator on 5/25/2016.
 */

public class FlightEditSceneControl {


    private static ComboBox<String> routeC,departure_time, arrival_time;
    private static ComboBox<Integer> plane_id;
    private static DatePicker departure_date, arrival_date;
    private static Button okB, cancelB;
    private static boolean okPressed = false;
    private static Flight flight;
    private static FlightTable flightTable;



    public static void initialize(){

        routeC = FlightsEditScene.getRouteC();
        for(Airline airline: AirlineData.getAirlines()){
            routeC.getItems().add(airline.getDeparture_city() + " -> " + airline.getArrival_city());
        }

        plane_id = FlightsEditScene.getPlane_id();
        for(Plane p : PlaneData.getPlanes()){
            plane_id.getItems().add(p.getPlane_id());

        }

        departure_time= FlightsEditScene.getDeparture_time();
        arrival_time = FlightsEditScene.getArrival_time();

        for(int i=1; i<=24; i++) {
            departure_time.getItems().add(i + ":00");
            arrival_time.getItems().add(i + ":00");
        }

        departure_date = FlightsEditScene.getDeparture_date();
        arrival_date = FlightsEditScene.getArrival_date();

        okB = FlightsEditScene.getOkB();
        okB.setOnAction( e -> handle_okB());

        cancelB = FlightsEditScene.getCancelB();
        cancelB.setOnAction( e-> handleClose());

    }


    public static void setFlight(FlightTable f,Flight flig){

            flightTable = f;
            flight = flig;

            for(Flight fl: FlightData.getFlight()) {
                if (fl.getFlight_id() == flightTable.getFlight_id())
                    flight = fl;
            }

            routeC.setValue(flightTable.getDeparture_city() + " -> " + flightTable.getArrival_city());
            plane_id.setValue(flight.getPlane_id());
            departure_date.setValue(LocalDate.parse(flightTable.getDeparture_date()));
            arrival_date.setValue(LocalDate.parse(flightTable.getArrival_date()));
            departure_time.setValue("10:00");
            arrival_time.setValue("12:00");

    }



    public static boolean isOkPressed(){ return okPressed; }


    public static void handle_okB(){
        flight.setPlane_id(plane_id.getValue());
      /*  for(Plane p: PlaneData.getPlanes()){
            if(p.getPlane_id()==plane_id.getValue()){
                flight.setFirst_class_left(p.getFirst_class());
                flight.setCoach_left(p.getCoach());
                flight.setEconomy_left(p.getEconomy());
            }
        }*/
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
        schedule.setArrival_date(Date.valueOf(arrival_date.getValue()));
        ScheduleData.insertSchedule(schedule);

        for(Schedule s: ScheduleData.getSchedules())
           if( s.getDeparture_date().equals(schedule.getDeparture_date()) && s.getArrival_date().equals(schedule.getArrival_date()))
               flight.setSchedule_id(s.getSchedule_id());

        okPressed = true;
        FlightsEditScene.getDialogStage().close();
    }


    public static void handleClose(){
        okPressed = false;
        FlightsEditScene.getDialogStage().close();
    }


    //getters
    public static Flight getFlight() {
        return flight;
    }

    public static FlightTable getFlightTable() {
        return flightTable;
    }
}
