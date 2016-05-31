package Presentation;

import Application.Control.MainControl;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.geom.Arc2D;


/**
 * Created by Administrator on 5/24/2016.
 */

public class FlightsEditScene {

    //fields
    private static Stage dialogStage;
    private static Scene scene;
    private static Pane layout;
    private static Label flightL,timeL,routeL,dateL,planeL,toL,priceL;
    private static ComboBox<String> routeC,departure_time, arrival_time;
    private static ComboBox<Integer> plane_id;
    private static DatePicker departure_date;
    private static TextField price;
    private static Button okB, cancelB;
    private static VBox vBox1, vBox2;


    //initialization of objects
    public static void initialize(){

        //labels
        flightL = new Label("Flight details");
        flightL.relocate(250,100);

        priceL = new Label("Base price");
        routeL = new Label("Route");
        dateL = new Label("Date");
        timeL = new Label("Time");
        planeL = new Label ("Plane ID");

        toL = new Label("to");
        toL.relocate(289,302);

        //labels layout
        vBox1 = new VBox();
        vBox1.getChildren().addAll(routeL, dateL,timeL,planeL, priceL);
        vBox1.relocate(41,202);
        vBox1.setSpacing(34);


        //combo boxes
        routeC = new ComboBox<>();
        departure_time = new ComboBox<>();
        arrival_time = new ComboBox<>();
        plane_id = new ComboBox<>();

        //price field
        price = new TextField();

        //departure date picker
        departure_date = new DatePicker();
        departure_date.setMaxWidth(120);

        //selectors layout
        vBox2 = new VBox();
        vBox2.getChildren().addAll(routeC,departure_date,departure_time,plane_id, price);
        vBox2.setSpacing(25);
        vBox2.relocate(145,200);

        //arrival time box
        arrival_time = new ComboBox<>();
        arrival_time.relocate(350,302);


        //buttons
        okB = new Button("Ok");
        okB.relocate(220,450);

        cancelB = new Button("Cancel");
        cancelB.relocate(260,450);


        //layout
        layout = new Pane();
        layout.getChildren().addAll(flightL, vBox1, vBox2, toL, arrival_time, okB, cancelB);

        //stage setup
        scene = new Scene(layout,500,600);
        scene.getStylesheets().addAll("/Presentation/style.css");

        dialogStage = new Stage();
        dialogStage.getIcons().add(new javafx.scene.image.Image("/Presentation/icon.png"));
        dialogStage.setScene(scene);

        System.out.println("flight edit dialog initialized");
    }



    //getters
    public static Stage getDialogStage() {
        return dialogStage;
    }

    public static Scene getScene() {
        return scene;
    }

    public static Pane getLayout() {
        return layout;
    }

    public static Label getFlightL() {
        return flightL;
    }

    public static Label getTimeL() {
        return timeL;
    }

    public static Label getRouteL() {
        return routeL;
    }

    public static Label getDateL() {
        return dateL;
    }

    public static Label getPlaneL() {
        return planeL;
    }

    public static Label getToL() {
        return toL;
    }

    public static Label getPriceL() {
        return priceL;
    }

    public static ComboBox<String> getRouteC() {
        return routeC;
    }

    public static ComboBox<String> getDeparture_time() {
        return departure_time;
    }

    public static ComboBox<String> getArrival_time() {
        return arrival_time;
    }

    public static ComboBox<Integer> getPlane_id() {
        return plane_id;
    }

    public static DatePicker getDeparture_date() {
        return departure_date;
    }

    public static TextField getPrice() {
        return price;
    }

    public static Button getOkB() {
        return okB;
    }

    public static Button getCancelB() {
        return cancelB;
    }

    public static VBox getvBox1() {
        return vBox1;
    }

    public static VBox getvBox2() {
        return vBox2;
    }

}
