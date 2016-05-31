package Presentation;

import Application.DataTypes.Booking;
import Application.DataTypes.BookingTable;
import Application.DataTypes.Customer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Date;

/**
 * Created by Administrator on 5/18/2016.
 */

public class ViewBookingScene {

    //fields
    private static Scene scene;
    private static Pane layout;
    private static TableView<BookingTable> table;
    private static TableColumn<BookingTable, String> dateColumn;
    private static TableColumn<BookingTable, String> nameColumn;
    private static TableColumn<BookingTable, String> routeColumn;
    private static Label flightLabel;
    private static Label departure_dateLabel;
    private static Label departure_dateObs;
    private static Label arrival_dateLabel;
    private static Label arrival_dateObs;
    private static Label categoryLabel;
    private static Label categoryObs;
    private static Label priceLabel;
    private static Label priceObs;
    private static VBox flight_details;
    private static VBox flight_detailsObs;


    private static Label customer_detailsLabel;

    private static Label first_nameLabel;
    private static Label first_nameObs;
    private static Label last_nameLabel;
    private static Label last_nameObs;
    private static Label ageLabel;
    private static Label ageObs;
    private static Label passportLabel;
    private static Label passportObs;
    private static Label phone_numberLabel;
    private static Label phone_numberObs;
    private static VBox customer_detailsVertical;
    private static VBox customer_detailsVerticalObs;

    private static TextField searchField;
    private static Button add_bookingButton;
    private static Button cancelButton;
    private static Button backButton;
    private static Button editButton;
    private static HBox buttonLayout;


    //initialization of objects
    public static void initialize(){

        //table columns
        dateColumn=new TableColumn<>("Departure date");
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().departure_dateProperty());

        nameColumn=new TableColumn<>("Customer name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().customerProperty());

        routeColumn=new TableColumn<>("\t\t\tRoute");
        routeColumn.setMinWidth(160);
        routeColumn.setCellValueFactory(cellData -> cellData.getValue().routeProperty());


        //table
        table=new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(dateColumn, routeColumn, nameColumn);
        table.relocate(32,34);
        table.setMinWidth(610);
        table.setMinHeight(580);

        //flightLabel
        flightLabel=new Label("Flight Details");
        flightLabel.getStyleClass().add("label-simple");
        flightLabel.setStyle("-fx-font-size: 20pt");
        flightLabel.relocate(700, 40);

        //departure_label
        departure_dateLabel = new Label("Departure");
        departure_dateLabel.getStyleClass().add("label-simple");

        departure_dateObs = new Label("");


        //arrival_dateLabel
        arrival_dateLabel = new Label("Arrival");
        arrival_dateLabel.getStyleClass().add("label-simple");

        arrival_dateObs = new Label("");

        //categoryLabel
        categoryLabel = new Label("Category");
        categoryLabel.getStyleClass().add("label-simple");

        categoryObs = new Label("");

        //priceLabel
        priceLabel = new Label("Price");
        priceLabel.getStyleClass().add("label-simple");
        priceObs = new Label("");

        //flight vboxs
        flight_details = new VBox();
        flight_details.getChildren().addAll(departure_dateLabel,arrival_dateLabel,categoryLabel,priceLabel);
        flight_details.relocate(700,100);
        flight_details.setSpacing(25);

        flight_detailsObs = new VBox();
        flight_detailsObs.getChildren().addAll(departure_dateObs,arrival_dateObs,categoryObs,priceObs);
        flight_detailsObs.relocate(900,100);
        flight_detailsObs.setSpacing(25);

        //customer_details
        customer_detailsLabel=new Label("Customer Details");
        customer_detailsLabel.getStyleClass().add("label-simple");
        customer_detailsLabel.setStyle("-fx-font-size:20pt");
        customer_detailsLabel.relocate(700,310);

        //first_nameLabel
        first_nameLabel = new Label("First Name");
        first_nameLabel.getStyleClass().add("label-simple");

        first_nameObs = new Label("");

        //last_nameLabel
        last_nameLabel = new Label("Last name");
        last_nameLabel.getStyleClass().add("label-simple");
        last_nameObs=new Label("");

        //age
        ageLabel=new Label("Age");
        ageLabel.getStyleClass().add("label-simple");

        ageObs = new Label("");

        //passport
        passportLabel=new Label("Passport");
        passportLabel.getStyleClass().add("label-simple");

        passportObs=new Label("");

        //phone
        phone_numberLabel=new Label("Phone number");
        phone_numberLabel.getStyleClass().add("label-simple");

        phone_numberObs=new Label("");

        //customer Vboxes
        customer_detailsVertical = new VBox();
        customer_detailsVertical.getChildren().addAll(first_nameLabel,last_nameLabel,ageLabel,passportLabel,phone_numberLabel);
        customer_detailsVertical.relocate(700,370);
        customer_detailsVertical.setSpacing(25);

        customer_detailsVerticalObs=new VBox();
        customer_detailsVerticalObs.getChildren().addAll(first_nameObs,last_nameObs,ageObs,passportObs,phone_numberObs);
        customer_detailsVerticalObs.relocate(900,370);
        customer_detailsVerticalObs.setSpacing(25);

        //searchField
        searchField=new TextField();
        searchField.setPromptText("search");
        searchField.relocate(32,642);
        searchField.setMinWidth(605);

        //buttons
        backButton=new Button("Back");
        add_bookingButton=new Button("Add..");
        editButton=new Button("Edit..");
        cancelButton=new Button("Remove");


        // layout for buttons
        buttonLayout=new HBox();
        buttonLayout.getChildren().addAll(add_bookingButton,editButton,cancelButton,backButton);
        buttonLayout.relocate(720,642);
        buttonLayout.setSpacing(20);

        //LAYOUT
        layout=new Pane();
        layout.getChildren().addAll(table,flight_details,flight_detailsObs,customer_detailsLabel,customer_detailsVertical,customer_detailsVerticalObs,flightLabel,buttonLayout,searchField);

        //Scene
        scene = new Scene(layout,1200,700);
        scene.getStylesheets().add("/Presentation/style.css");


        System.out.println("bookings scene initialized");
    }


    //getters
    public static Scene getScene() {
        return scene;
    }

    public static Pane getLayout() {
        return layout;
    }

    public static TableView<BookingTable> getTable() {
        return table;
    }

    public static TableColumn<BookingTable, String> getDateColumn() {
        return dateColumn;
    }

    public static TableColumn<BookingTable, String> getNameColumn() {
        return nameColumn;
    }

    public static TableColumn<BookingTable, String> getRouteColumn() {
        return routeColumn;
    }

    public static Label getFlightLabel() {
        return flightLabel;
    }

    public static Label getDeparture_dateLabel() {
        return departure_dateLabel;
    }

    public static Label getDeparture_dateObs() {
        return departure_dateObs;
    }

    public static Label getArrival_dateLabel() {
        return arrival_dateLabel;
    }

    public static Label getArrival_dateObs() {
        return arrival_dateObs;
    }

    public static Label getCategoryLabel() {
        return categoryLabel;
    }

    public static Label getCategoryObs() {
        return categoryObs;
    }

    public static Label getPriceLabel() {
        return priceLabel;
    }

    public static Label getPriceObs() {
        return priceObs;
    }

    public static VBox getFlight_details() {
        return flight_details;
    }

    public static VBox getFlight_detailsObs() {
        return flight_detailsObs;
    }

    public static Label getCustomer_detailsLabel() {
        return customer_detailsLabel;
    }

    public static Label getFirst_nameLabel() {
        return first_nameLabel;
    }

    public static Label getFirst_nameObs() {
        return first_nameObs;
    }

    public static Label getLast_nameLabel() {
        return last_nameLabel;
    }

    public static Label getLast_nameObs() {
        return last_nameObs;
    }

    public static Label getAgeLabel() {
        return ageLabel;
    }

    public static Label getAgeObs() {
        return ageObs;
    }

    public static Label getPassportLabel() {
        return passportLabel;
    }

    public static Label getPassportObs() {
        return passportObs;
    }

    public static Label getPhone_numberLabel() {
        return phone_numberLabel;
    }

    public static Label getPhone_numberObs() {
        return phone_numberObs;
    }

    public static VBox getCustomer_detailsVertical() {
        return customer_detailsVertical;
    }

    public static VBox getCustomer_detailsVerticalObs() {
        return customer_detailsVerticalObs;
    }

    public static TextField getSearchField() {
        return searchField;
    }

    public static Button getAdd_bookingButton() {
        return add_bookingButton;
    }

    public static Button getCancelButton() {
        return cancelButton;
    }

    public static Button getBackButton() {
        return backButton;
    }

    public static Button getEditButton() {
        return editButton;
    }

    public static HBox getButtonLayout() {
        return buttonLayout;
    }
}
