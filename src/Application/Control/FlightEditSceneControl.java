package Application.Control;

import Application.DataTypes.*;
import DataAccess.*;
import Presentation.FlightsEditScene;
import javafx.scene.Scene;
import javafx.scene.control.*;
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


    private static ComboBox<String> routeC;
    private static ComboBox<Integer> plane_id,departure_time, arrival_time;
    private static DatePicker departure_date, arrival_date;
    private static javafx.scene.control.Button okB, cancelB;
    private static boolean okPressed = false;
    private static Flight flight;
    private static FlightTable flightTable = new FlightTable();

    public static void initialize(){

        routeC = FlightsEditScene.getRouteC();
        for(FlightTable f: FlightTableData.getFlightTableItems()){
            routeC.getItems().add(f.getDeparture_city()+"->"+f.getArrival_city());
        }
        plane_id = FlightsEditScene.getPlane_id();
        for(Plane p : PlaneData.getPlanes()){
            plane_id.getItems().add(p.getPlane_id());
        }
        departure_time= FlightsEditScene.getDeparture_time();
        arrival_time = FlightsEditScene.getArrival_time();
        for(int i=1;i<=24;i++){
            departure_time.getItems().add(i);
            arrival_time.getItems().add(i);
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

            for(Flight fl: FlightData.getFlight()){
                if(fl.getFlight_id()==flightTable.getFlight_id())
                    flight = fl;

            routeC.setValue(flightTable.getDeparture_city() + "->" + flightTable.getArrival_city());
            plane_id.setValue(flight.getPlane_id());
            departure_date.setValue(LocalDate.parse(flightTable.getDeparture_date()));
            arrival_date.setValue(LocalDate.parse(flightTable.getArrival_date()));
            departure_time.setValue(1);
            arrival_time.setValue(2);
        }
    }

    public static boolean isOkPressed(){ return okPressed; }

    public static void handle_okB(){
        flight.setPlane_id(plane_id.getValue());
        String route = routeC.getValue();
        for(Airline a : AirlineData.getAirlines()){
            if((a.getDeparture_ciy()+"->"+a.getArrival_city()).equalsIgnoreCase(route)){
                flight.setAirline_id(a.getAirline_id());
                System.out.println("yes");
            }
        }

        Schedule schedule = new Schedule();
        schedule.setDeparture_time(Integer.toString(departure_time.getValue()));
        schedule.setArrival_time(Integer.toString(arrival_time.getValue()));
        schedule.setDeparture_date(Date.valueOf(departure_date.getValue()));
        schedule.setArrival_date(Date.valueOf(arrival_date.getValue()));
        ScheduleData.insertSchedule(schedule);

        for(Schedule s: ScheduleData.getSchedules())
           if( s.getDeparture_date().equals(schedule.getDeparture_date()) &&s.getArrival_date().equals(schedule.getArrival_date()))
               flight.setSchedule_id(s.getSchedule_id());
        okPressed = true;
        FlightsEditScene.getDialogStage().close();
    }

    public static void handleClose(){
        okPressed = false;
        FlightsEditScene.getDialogStage().close();
    }

}
