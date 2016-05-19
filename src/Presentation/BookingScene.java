package Presentation;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by Administrator on 5/19/2016.
 */
public class BookingScene {

    //fields
    private static Scene scene;
    private static Pane layout;
    private static Label bookingLabel;
    private static Label routeLabel;
    private static Label departure_dateLabel;
    private static Label arrival_dateLabel;
    private static Label categoryLabel;
    private static Label priceLabel;
    private static VBox labelsLayout;
    private static VBox detailsLayout;

    private static ComboBox<String> departure_cityBox;
    private static ComboBox<String> arrival_cityBox;
    private static DatePicker departure_datePicker;
    private static DatePicker arrival_datePicker;
    private static ComboBox<String> categoryBox;
    private static Button select_customerButton;
    private static Button cancelButton;
    private static Label priceLabelObs;

    //initialization of object
    public static void initialize(){

        //bookingLabel
        bookingLabel = new Label("Booking details");
        bookingLabel.relocate(41,51);
        //routeLabel
        routeLabel = new Label("Route");

        //departureLabel
        departure_dateLabel = new Label("Departure date");

        //arrivalLabel
        arrival_dateLabel = new Label("Arrival date");

        //categoryLabel
        categoryLabel = new Label("Catgeory");

        //priceLabel
        priceLabel = new Label("Price");

        //labelsLayout
        labelsLayout = new VBox();
        labelsLayout.getChildren().addAll(routeLabel,departure_dateLabel,arrival_dateLabel,categoryLabel,priceLabel);
        labelsLayout.setSpacing(34);
        labelsLayout.relocate(41,139);

        //departure Choice Box
        departure_cityBox = new ComboBox<>();

        //arrival city Box
        arrival_cityBox = new ComboBox<>();
        arrival_cityBox.relocate(336,139);

        //departure date
        departure_datePicker = new DatePicker();

        //arrival date
        arrival_datePicker = new DatePicker();

        //category box
        categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll("First Class", "Coach", "Economy");

        //price label obs
        priceLabelObs = new Label("");

        //details layout
        detailsLayout = new VBox();
        detailsLayout.getChildren().addAll(departure_cityBox,departure_datePicker,arrival_datePicker,categoryBox,priceLabelObs);
        detailsLayout.setSpacing(25);
        detailsLayout.relocate(180,139);

        //buttons
        cancelButton = new Button("Cancel");
        cancelButton.relocate(310,550);

        select_customerButton = new Button("Select Customer");
        select_customerButton.relocate(370,550);

        //Pane
        layout = new Pane();
        layout.getChildren().addAll(bookingLabel,labelsLayout,detailsLayout,arrival_cityBox,cancelButton,select_customerButton);

        //Scene
        scene = new Scene(layout,500,600);




    }

    public static Scene getScene() {
        return scene;
    }

    public static Pane getLayout() {
        return layout;
    }

    public static Label getBookingLabel() {
        return bookingLabel;
    }

    public static Label getRouteLabel() {
        return routeLabel;
    }

    public static Label getDeparture_dateLabel() {
        return departure_dateLabel;
    }

    public static Label getArrival_dateLabel() {
        return arrival_dateLabel;
    }

    public static Label getCategoryLabel() {
        return categoryLabel;
    }

    public static Label getPriceLabel() {
        return priceLabel;
    }

    public static VBox getLabelsLayout() {
        return labelsLayout;
    }

    public static VBox getDetailsLayout() {
        return detailsLayout;
    }

    public static ComboBox<String> getDeparture_cityBox() {
        return departure_cityBox;
    }

    public static ComboBox<String> getArrival_cityBox() {
        return arrival_cityBox;
    }

    public static DatePicker getDeparture_datePicker() {
        return departure_datePicker;
    }

    public static DatePicker getArrival_datePicker() {
        return arrival_datePicker;
    }

    public static ComboBox<String> getCategoryBox() {
        return categoryBox;
    }

    public static Button getSelect_customerButton() {
        return select_customerButton;
    }

    public static Button getCancelButton() {
        return cancelButton;
    }

    public static Label getPriceLabelObs() {
        return priceLabelObs;
    }
}
