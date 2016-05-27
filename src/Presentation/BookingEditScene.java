package Presentation;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Petru on 5/26/2016.
 */

public class BookingEditScene {

    //fields
    private static Stage dialogStage;
    private static Scene scene;
    private static Pane layout;
    private static Label customerLabel, addCustomerLabel;
    private static Label bookingLabel;
    private static Label routeLabel;
    private static Label departure_dateLabel;
    private static Label categoryLabel;
    private static Label priceLabel;
    private static VBox labelsLayout;
    private static VBox detailsLayout;

    private static ComboBox<String> customerBox;
    private static ComboBox<String> routeBox;
    private static DatePicker departure_datePicker;
    private static ComboBox<String> categoryBox;
    private static Button addCustomer;
    private static Button okButton;
    private static Button cancelButton;
    private static Label priceLabelObs;

    //initialization of object
    public static void initialize(){

        //bookingLabel
        bookingLabel = new Label("Booking details");
        bookingLabel.relocate(41,51);

        //customer label
        customerLabel = new Label("Select customer");

        //add customer label
        addCustomerLabel = new Label("OR");

        //routeLabel
        routeLabel = new Label("Route");

        //departureLabel
        departure_dateLabel = new Label("Departure date");

        //categoryLabel
        categoryLabel = new Label("Category");

        //priceLabel
        priceLabel = new Label("Price");

        //labelsLayout
        labelsLayout = new VBox();
        labelsLayout.getChildren().addAll(customerLabel,addCustomerLabel, new Label(" "), routeLabel,departure_dateLabel,categoryLabel,priceLabel);
        labelsLayout.setSpacing(35);
        labelsLayout.relocate(41,138);


        //customer box
        customerBox = new ComboBox<>();

        //add customer button
        addCustomer = new Button("New customer");

        //route
        routeBox = new ComboBox<>();

        //departure date
        departure_datePicker = new DatePicker();


        //category box
        categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll("First Class", "Coach", "Economy");

        //price label obs
        priceLabelObs = new Label("");

        //details layout
        detailsLayout = new VBox();
        detailsLayout.getChildren().addAll(customerBox,addCustomer, new Label(" "), routeBox,departure_datePicker,categoryBox,priceLabelObs);
        detailsLayout.setSpacing(26);
        detailsLayout.relocate(210,139);

        //buttons
        cancelButton = new Button("Cancel");
        cancelButton.relocate(370,550);

        okButton = new Button("OK");
        okButton.relocate(310,550);

        //Pane
        layout = new Pane();
        layout.getChildren().addAll(bookingLabel,labelsLayout,detailsLayout,okButton,cancelButton);

        //Scene
        scene = new Scene(layout,500,600);

        //Stage
        dialogStage = new Stage();
        dialogStage.setScene(scene);

    }


    //getters
    public static Scene getScene() {
        return scene;
    }

    public static Pane getLayout() {
        return layout;
    }

    public static Label getCustomerLabel() {
        return customerLabel;
    }

    public static Label getAddCustomerLabel() {
        return addCustomerLabel;
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

    public static ComboBox<String> getCustomerBox() {
        return customerBox;
    }

    public static ComboBox<String> getRouteBox() {
        return routeBox;
    }

    public static DatePicker getDeparture_datePicker() {
        return departure_datePicker;
    }

    public static ComboBox<String> getCategoryBox() {
        return categoryBox;
    }

    public static Button getAddCustomer() {
        return addCustomer;
    }

    public static Button getOkButton() {
        return okButton;
    }

    public static Button getCancelButton() {
        return cancelButton;
    }

    public static Label getPriceLabelObs() {
        return priceLabelObs;
    }

    public static Stage getDialogStage() {
        return dialogStage;
    }

}
