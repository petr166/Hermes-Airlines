package Application.Control;

import Application.DataTypes.*;
import DataAccess.*;
import Presentation.BookingEditScene;
import Presentation.FlightsEditScene;
import javafx.scene.control.*;
import javafx.util.Callback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Petru on 26-May-16.
 */

public class BookingEditSceneControl {

    //fields
    private static ComboBox<String> customerBox;
    private static ComboBox<String> routeBox;
    private static DatePicker departure_datePicker;
    private static ComboBox<String> categoryBox;
    private static Button addCustomer;
    private static Button okButton;
    private static Button cancelButton;
    private static Label priceLabelObs;
    private static boolean okPressed = false;
    private static Booking booking;
    private static BookingTable bookingTable;


    //initialize method
    public static void initialize() {

        customerBox = BookingEditScene.getCustomerBox();
        for(Customer c : CustomerData.getCustomers())
            customerBox.getItems().add(c.getFirst_name() + " " + c.getLast_name());

        routeBox = BookingEditScene.getRouteBox();
        routeBox.setOnAction(e-> {
            setDatePicker();
        });
        for(Airline a : AirlineData.getAirlines())
            routeBox.getItems().add(a.getDeparture_city() + " -> " + a.getArrival_city());


        departure_datePicker = BookingEditScene.getDeparture_datePicker();
        departure_datePicker.setOnAction(e-> handleRouteAction());

        categoryBox = BookingEditScene.getCategoryBox();
        categoryBox.setOnAction(e->handleRouteAction());

        addCustomer = BookingEditScene.getAddCustomer();
        addCustomer.setOnAction(e -> {
            ViewCustomerSceneControl.handle_addB();
            Customer customer = CustomerEditSceneControl.getCustomer();
            customerBox.setValue(customer.getFirst_name() + " " + customer.getLast_name());
        });

        priceLabelObs = BookingEditScene.getPriceLabelObs();

        cancelButton = BookingEditScene.getCancelButton();
        cancelButton.setOnAction(e -> handleClose());

        okButton = BookingEditScene.getOkButton();
        okButton.setOnAction(e -> handle_okButton());
    }

    public static void handleRouteAction() {

        try{
            String flight_route = routeBox.getValue();
            String flight_date = departure_datePicker.getValue().toString();
            for (FlightTable f : FlightTableData.getFlightTableItems()) {
                if (f.getDeparture_date().equalsIgnoreCase(flight_date) &&
                        (f.getDeparture_city() + " -> " + f.getArrival_city()).equalsIgnoreCase(flight_route)) {
                    if (categoryBox.getValue().equalsIgnoreCase("first class"))
                        priceLabelObs.setText(String.valueOf(f.getPrice() + f.getPrice() * 1 / 2));
                    else if (categoryBox.getValue().equalsIgnoreCase("coach"))
                        priceLabelObs.setText(String.valueOf(f.getPrice() + f.getPrice() * 1 / 4));
                    else priceLabelObs.setText(String.valueOf(f.getPrice()));


                }
            }

        } catch(Exception e){}

    }

    public static void setBooking(BookingTable bTab, Booking b) {

        bookingTable = bTab;
        booking = b;

        boolean existing = false;

        for(Booking bk : BookingData.getBookings())
            if(bookingTable.getBooking_id() == bk.getBooking_id()) {
                booking = bk;
                existing = true;
                break;
            }

        if(existing) {
            Customer customer = new Customer();
            for (Customer c : CustomerData.getCustomers())
                if (booking.getCustomer_id() == c.getCustomer_id()) {
                    customer = c;
                    break;
                }

            FlightTable flight = new FlightTable();
            for (FlightTable f : FlightTableData.getFlightTableItems()) {
                if(booking.getFlight_id() == f.getFlight_id()) {
                    flight = f;
                    break;
                }
            }


            customerBox.setValue(customer.getFirst_name() + " " + customer.getLast_name());
            routeBox.setValue(flight.getDeparture_city() + " -> " + flight.getArrival_city());
            setDatePicker();
            departure_datePicker.setValue(LocalDate.parse(flight.getDeparture_date()));
            categoryBox.setValue(booking.getFare_class());
            priceLabelObs.setText(String.valueOf(flight.getPrice()));
        }
    }



    public static void handle_okButton() {
        String customer = customerBox.getValue();
        for(Customer c : CustomerData.getCustomers()) {
            if((c.getFirst_name() + " " + c.getLast_name()).equalsIgnoreCase(customer)) {
                booking.setCustomer_id(c.getCustomer_id());
                break;
            }
        }

        String flight_route = routeBox.getValue();
        String flight_date = departure_datePicker.getValue().toString();
        for(FlightTable f : FlightTableData.getFlightTableItems()) {
            if(f.getDeparture_date().equalsIgnoreCase(flight_date) &&
                    (f.getDeparture_city() + " -> " + f.getArrival_city()).equalsIgnoreCase(flight_route)) {
                booking.setFlight_id(f.getFlight_id());
                break;
            }
        }

        booking.setFare_class(categoryBox.getValue());

        okPressed = true;
        BookingEditScene.getDialogStage().close();
    }



    public static void handleClose(){
        okPressed = false;
        BookingEditScene.getDialogStage().close();
    }


    //
    public static void setDatePicker() {
        ArrayList<String> flightDates = new ArrayList<>();

        for (FlightTable f : FlightTableData.getFlightTableItems()) {
            if(routeBox.getValue().equalsIgnoreCase(f.getDeparture_city() + " -> " + f.getArrival_city()))
                flightDates.add(f.getDeparture_date());
        }

        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {

                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        setDisable(true);
                        setStyle("-fx-background-color: #ffc0cb;");

                        for(int i = 0; i < flightDates.size(); i++)
                            if (item.isEqual(LocalDate.parse(flightDates.get(i)))) {
                                setDisable(false);
                                setStyle("-fx-background-color: limegreen");
                            }

                        if(item.isEqual(departure_datePicker.getValue()))
                            setStyle("-fx-border-color: white");
                    }
                };
            }
        };

        departure_datePicker.setValue(LocalDate.parse(flightDates.get(0)));
        departure_datePicker.setDayCellFactory(dayCellFactory);
    }


    //getters
    public static Booking getBooking() {
        return booking;
    }

    public static boolean isOkPressed() {
        return okPressed;
    }

    public static ComboBox<String> getCustomerBox() {
        return customerBox;
    }

    public static Button getAddCustomer() {
        return addCustomer;
    }

    public static BookingTable getBookingTable() {
        return bookingTable;
    }

}