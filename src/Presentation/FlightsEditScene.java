package Presentation;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;


/**
 * Created by Administrator on 5/24/2016.
 */
public class FlightsEditScene {

    //fields
    private static Stage dialogStage;
    private static Scene scene;
    private static Pane layout;
    private static Label flightL,timeL, routeL, dateL,planeL,toL1,toL2;
    private static ComboBox<String> routeC, plane_id,departure_time, arrival_time;
    private static DatePicker departure_date, arrival_date;
    private static Button okB, cancelB;
    private static VBox vBox1, vBox2;

    //initialize
    public static void initialize(){

        flightL = new Label("Flight details");
        flightL.relocate(250,100);

        routeL = new Label("Route");
        dateL = new Label("Date");
        timeL = new Label("Time");
        planeL = new Label ("Plane ID");
        toL1 = new Label("to");
        toL1.relocate(289,259);
        toL2 = new Label("to");
        toL2.relocate(289,302);
        vBox1 = new VBox();
        vBox1.getChildren().addAll(routeL, dateL,timeL,planeL);
        vBox1.relocate(41,202);
        vBox1.setSpacing(34);


        routeC = new ComboBox<>();
        departure_time = new ComboBox<>();
        arrival_time = new ComboBox<>();
        plane_id = new ComboBox<>();

        departure_date = new DatePicker();
        departure_date.setMaxWidth(120);
        arrival_date = new DatePicker();
        arrival_date.setMaxWidth(120);
        arrival_date.relocate(350,255);

        vBox2 = new VBox();
        vBox2.getChildren().addAll(routeC,departure_date,departure_time,plane_id);
        vBox2.setSpacing(25);
        vBox2.relocate(145,200);

        arrival_time = new ComboBox<>();
        arrival_time.relocate(350,302);


        okB = new Button("Ok");
        okB.relocate(220,450);

        cancelB = new Button("Cancel");
        cancelB.relocate(260,450);


        layout = new Pane();
        layout.getChildren().addAll(flightL, vBox1, vBox2, toL1, toL2, arrival_date, arrival_time, okB, cancelB);

        scene = new Scene(layout,500,600);

        dialogStage = new Stage();
        dialogStage.setScene(scene);

    }


    public static Stage getDialogStage() {
        return dialogStage;
    }

    public static ComboBox<String> getRouteC() {
        return routeC;
    }

    public static ComboBox<String> getPlane_id() {
        return plane_id;
    }

    public static ComboBox<String> getDeparture_time() {
        return departure_time;
    }

    public static ComboBox<String> getArrival_time() {
        return arrival_time;
    }

    public static DatePicker getDeparture_date() {
        return departure_date;
    }

    public static DatePicker getArrival_date() {
        return arrival_date;
    }

    public static Button getOkB() {
        return okB;
    }

    public static Button getCancelB() {
        return cancelB;
    }
}
