package Application.Control;

import Application.DataTypes.Booking;
import Application.DataTypes.BookingTable;
import Application.DataTypes.Customer;
import Application.DataTypes.FlightTable;
import DataAccess.BookingData;
import DataAccess.BookingTableData;
import DataAccess.CustomerData;
import DataAccess.FlightTableData;
import Presentation.ViewBookingScene;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;

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

        table = ViewBookingScene.getTable();
        table.setItems(BookingTableData.getBookingTableItems());
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> displayBookingInfo(newValue));

        departure_dateObs = ViewBookingScene.getDeparture_dateObs();
        arrival_dateObs = ViewBookingScene.getArrival_dateObs();
        categoryObs = ViewBookingScene.getCategoryObs();
        priceObs = ViewBookingScene.getPriceObs();

        first_nameObs = ViewBookingScene.getFirst_nameObs();
        last_nameObs = ViewBookingScene.getLast_nameObs();
        ageObs = ViewBookingScene.getAgeObs();
        passportObs = ViewBookingScene.getPassportObs();
        phone_numberObs = ViewBookingScene.getPhone_numberObs();

        add_bookingButton = ViewBookingScene.getAdd_bookingButton();


        cancelButton = ViewBookingScene.getCancelButton();


        backButton = ViewBookingScene.getBackButton();
        backButton.setOnAction(e -> handle_backButton());


        editButton = ViewBookingScene.getBackButton();


        search = ViewBookingScene.getSearchField();
        bookings = table.getItems();
        initializeSearch();
    }


    //back button action
    public static void handle_backButton() {
        MainControl.showMenuScene();
    }


    //method to display the booking details
    public static void displayBookingInfo(BookingTable buk) {

        if(buk != null) {
            Booking booking = new Booking();
            for(Booking b : BookingData.getBookings())
                if(b.getBooking_id() == buk.getBooking_id())
                    booking = b;

            FlightTable flight = new FlightTable();
            for(FlightTable f : FlightTableData.getFlightTableItems())
                if(f.getFlight_id() == booking.getFlight_id())
                    flight = f;

            Customer customer = new Customer();
            for(Customer c : CustomerData.getCustomers())
                if(c.getCustomer_id() == booking.getCustomer_id())
                    customer = c;

            departure_dateObs.setText(flight.getDeparture_date() + ", from " + flight.getDeparture_city());
            arrival_dateObs.setText(flight.getArrival_date() + ", from " + flight.getArrival_city());
            categoryObs.setText(booking.getFare_class());
            priceObs.setText(String.valueOf(flight.getPrice()));

            first_nameObs.setText(customer.getFirst_name());
            last_nameObs.setText(customer.getLast_name());
            ageObs.setText(String.valueOf(customer.getAge()));
            passportObs.setText(customer.getPassport_number());
            phone_numberObs.setText(customer.getPhone_nr());
        }

        else {
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
