package Application.Control;

import Application.DataTypes.*;
import DataAccess.*;
import Presentation.ViewBookingScene;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.Optional;

/**
 * Created by Petru on 26-May-16.
 */

public class ViewBookingSceneControl {

    //fields
    private static TableView<BookingTable> table;
    private static Label departure_dateObs;
    private static Label arrival_dateObs;
    private static Label categoryObs;
    private static Label priceObs;

    private static Label first_nameObs;
    private static Label last_nameObs;
    private static Label ageObs;
    private static Label passportObs;
    private static Label phone_numberObs;

    private static TextField search;
    private static Button add_bookingButton;
    private static Button cancelButton;
    private static Button backButton;
    private static Button editButton;

    private static ObservableList<BookingTable> bookings, tableItems;


    //initialize method
    public static void initialize() {

        //table
        table = ViewBookingScene.getTable();
        table.setItems(BookingTableData.getBookingTableItems());
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> displayBookingInfo(newValue));

        //flight info labels
        departure_dateObs = ViewBookingScene.getDeparture_dateObs();
        arrival_dateObs = ViewBookingScene.getArrival_dateObs();
        categoryObs = ViewBookingScene.getCategoryObs();
        priceObs = ViewBookingScene.getPriceObs();

        //customer info labels
        first_nameObs = ViewBookingScene.getFirst_nameObs();
        last_nameObs = ViewBookingScene.getLast_nameObs();
        ageObs = ViewBookingScene.getAgeObs();
        passportObs = ViewBookingScene.getPassportObs();
        phone_numberObs = ViewBookingScene.getPhone_numberObs();

        //buttons
        add_bookingButton = ViewBookingScene.getAdd_bookingButton();
        add_bookingButton.setOnAction(e -> handle_addButton());

        cancelButton = ViewBookingScene.getCancelButton();
        cancelButton.setOnAction(e -> handle_cancelButton());

        backButton = ViewBookingScene.getBackButton();
        backButton.setOnAction(e -> handle_backButton());

        editButton = ViewBookingScene.getEditButton();
        editButton.setOnAction(e -> handle_editButton());


        //search field setup
        search = ViewBookingScene.getSearchField();
        bookings = table.getItems();
        initializeSearch();
    }


    //back button action
    public static void handle_backButton() {
        MainControl.showMenuScene();
    }


    //add button action
    public static void handle_addButton(){
        BookingTable bookingTable = new BookingTable();
        Booking booking = new Booking();

        boolean okPressed = MainControl.showBookingEditScene(bookingTable, booking);

        if (okPressed) {
            booking = BookingEditSceneControl.getBooking();
            BookingData.insertBooking(booking); //add booking to database

            table.setItems(BookingTableData.getBookingTableItems()); //set the table items
            bookings = table.getItems();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(MainControl.getWindow());
            alert.setContentText("Booking added!");
            alert.showAndWait();

            System.out.println("new booking added");
        }

    }


    //edit button action
    public static void handle_editButton(){
        BookingTable bookingTable = table.getSelectionModel().getSelectedItem();
        Booking booking = new Booking();

        if(bookingTable != null) {
            //assuming that the customer is going to change the ticket category
            for(Flight f: FlightData.getFlight()){
                if(booking.getFlight_id()==f.getFlight_id())
                    if(booking.getFare_class().equalsIgnoreCase("first class"))
                        f.setFirst_class_left(f.getFirst_class_left() + 1);
                    else if(booking.getFare_class().equalsIgnoreCase("coach"))
                        f.setCoach_left(f.getCoach_left() + 1);
                    else f.setEconomy_left(f.getEconomy_left() + 1);
                FlightData.updateFlight(f);
                break;
            }

            boolean okPressed = MainControl.showBookingEditScene(bookingTable, booking);

            if (okPressed) {
                booking = BookingEditSceneControl.getBooking();
                BookingData.updateBooking(booking); //edit booking in database

                table.setItems(BookingTableData.getBookingTableItems()); //set the table items
                bookings = table.getItems();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initOwner(MainControl.getWindow());
                alert.setContentText("Booking edited!");
                alert.showAndWait();

                System.out.println("a booking edited");
            }
        }

        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MainControl.getWindow());
            alert.setHeaderText("Select booking!");
            alert.setContentText("No booking selected!");
            alert.showAndWait();
        }
    }


    //remove button action
    public static void handle_cancelButton(){
        BookingTable bookingTable = table.getSelectionModel().getSelectedItem();
        Booking booking = new Booking();

        if(bookingTable != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(MainControl.getWindow());
            alert.setHeaderText("Remove booking");
            alert.setContentText("Are you sure you want to remove " + bookingTable.getCustomer() + "'s booking?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) { //confirmed
                for(Booking b : BookingData.getBookings())
                    if(bookingTable.getBooking_id() == b.getBooking_id())
                        booking = b;

                BookingData.deleteBooking(booking); //delete booking from database

                table.setItems(BookingTableData.getBookingTableItems()); //set table items
                bookings = table.getItems();

                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.initOwner(MainControl.getWindow());
                alert1.setContentText("Booking removed!");
                alert1.showAndWait();

                System.out.println("a booking removed");
            }
            else {
                alert.close();
            }
        }

        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MainControl.getWindow());
            alert.setHeaderText("Select booking!");
            alert.setContentText("No booking selected!");
            alert.showAndWait();
        }

    }

    //method to display the booking details
    public static void displayBookingInfo(BookingTable buk) {
        if(buk != null) {

            Booking booking = new Booking();
            for(Booking b : BookingData.getBookings())
                if(b.getBooking_id() == buk.getBooking_id()) {
                    booking = b;
                    break;
                }

            FlightTable flight = new FlightTable();
            for(FlightTable f : FlightTableData.getFlightTableItems())
                if(f.getFlight_id() == booking.getFlight_id()) {
                    flight = f;
                    break;
                }

            Customer customer = new Customer();
            for(Customer c : CustomerData.getCustomers())
                if(c.getCustomer_id() == booking.getCustomer_id()) {
                    customer = c;
                    break;
                }


            departure_dateObs.setText(flight.getDeparture_date() + ", " + flight.getDeparture_city());
            arrival_dateObs.setText(flight.getDeparture_date() + ", " + flight.getArrival_city());
            categoryObs.setText(booking.getFare_class());

            if(booking.getFare_class().equalsIgnoreCase("first class"))
            priceObs.setText(String.valueOf(flight.getPrice()+flight.getPrice()*1/2));
            else if(booking.getFare_class().equalsIgnoreCase("coach"))
                priceObs.setText(String.valueOf((flight.getPrice()+flight.getPrice()*1/4)));
            else
                priceObs.setText(String.valueOf(flight.getPrice()));


            first_nameObs.setText(customer.getFirst_name());
            last_nameObs.setText(customer.getLast_name());
            ageObs.setText(String.valueOf(customer.getAge()));
            passportObs.setText(customer.getPassport_number());
            phone_numberObs.setText(customer.getPhone_nr());
        }

        else { //no selection
            departure_dateObs.setText("");
            arrival_dateObs.setText("");
            categoryObs.setText("");
            priceObs.setText("");
            first_nameObs.setText("");
            last_nameObs.setText("");
            ageObs.setText("");
            passportObs.setText("");
            phone_numberObs.setText("");
        }
    }


    //search bar setup
    public static void initializeSearch(){
        search.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (search.textProperty().get().isEmpty()) {
                    table.setItems(bookings);
                    return;
                }

                tableItems = FXCollections.observableArrayList();

                for(BookingTable b : bookings){
                    if(b.getRoute().toUpperCase().contains(search.getText().toUpperCase())||
                            b.getCustomer().toUpperCase().contains(search.getText().toUpperCase())) {

                        tableItems.add(b);
                    }
                }

                table.setItems(tableItems);
            }
        });
    }

}
