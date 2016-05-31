package Application.Control;

import Application.DataTypes.*;
import DataAccess.*;
import Presentation.BookingEditScene;
import javafx.scene.control.*;
import javafx.util.Callback;

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

    private static RadioButton firstC;
    private static RadioButton coachC;
    private static RadioButton economyC;

    private static Button addCustomer;
    private static Button okButton;
    private static Button cancelButton;
    private static Label priceLabelObs;
    private static boolean okPressed = false;
    private static Booking booking;
    private static BookingTable bookingTable;



    //initialize method
    public static void initialize() {

        //customerBox
        customerBox = BookingEditScene.getCustomerBox();
        //getting existing customers
        for(Customer c : CustomerData.getCustomers())
            if(!customerBox.getItems().contains(c.getFirst_name() + " " + c.getLast_name()))
            customerBox.getItems().add(c.getFirst_name() + " " + c.getLast_name());


        //routeBox
        routeBox = BookingEditScene.getRouteBox();
        routeBox.setOnAction(e -> setDatePicker());
        //getting routes
        for(Airline a : AirlineData.getAirlines())
            if(!routeBox.getItems().contains(a.getDeparture_city() + " -> " + a.getArrival_city()))
            routeBox.getItems().add(a.getDeparture_city() + " -> " + a.getArrival_city());


        //departure date picker
        departure_datePicker = BookingEditScene.getDeparture_datePicker();
        departure_datePicker.setOnAction(e-> setAvailableSeat());


        //fare class radio buttons
        firstC = BookingEditScene.getFirstC();
        firstC.setOnAction(e -> setPrice());
        coachC = BookingEditScene.getCoachC();
        coachC.setOnAction(e -> setPrice());
        economyC = BookingEditScene.getEconomyC();
        economyC.setOnAction(e -> setPrice());


        //add customer button
        addCustomer = BookingEditScene.getAddCustomer();
        addCustomer.setOnAction(e -> {
            ViewCustomerSceneControl.handle_addB();
            Customer customer = CustomerEditSceneControl.getCustomer();
            customerBox.getItems().add(customer.getFirst_name() + " " + customer.getLast_name());
            customerBox.setValue(customer.getFirst_name() + " " + customer.getLast_name());
        });


        //price label
        priceLabelObs = BookingEditScene.getPriceLabelObs();

        //cancel Button
        cancelButton = BookingEditScene.getCancelButton();
        cancelButton.setOnAction(e -> handleClose());

        //ok button
        okButton = BookingEditScene.getOkButton();
        okButton.setOnAction(e -> handle_okButton());
    }


    //method to disable buttons in case of no available seats
    public static void setAvailableSeat() {

        try{
            String flight_route = routeBox.getValue();
            String flight_date = departure_datePicker.getValue().toString();

            for (FlightTable f : FlightTableData.getFlightTableItems()) {
                if (f.getDeparture_date().equalsIgnoreCase(flight_date) &&
                        (f.getDeparture_city() + " -> " + f.getArrival_city()).equalsIgnoreCase(flight_route)) {

                    for(Flight flight: FlightData.getFlight())
                        if(flight.getFlight_id()==f.getFlight_id()){
                            if(flight.getEconomy_left() < 1) {
                                economyC.setDisable(true);
                                economyC.setSelected(false);
                            }
                            else {
                                economyC.setDisable(false);
                                economyC.setSelected(true);
                            }

                            if(flight.getCoach_left() < 1) {
                                coachC.setDisable(true);
                                coachC.setSelected(false);
                            }
                            else {
                                coachC.setDisable(false);
                            }

                            if(flight.getFirst_class_left() < 1) {
                                firstC.setDisable(true);
                                firstC.setSelected(false);
                            }
                            else {
                                firstC.setDisable(false);
                            }

                            break;
                        }

                    if (firstC.isSelected())
                        priceLabelObs.setText(String.valueOf(f.getPrice() + f.getPrice() * 1 / 2));
                    else
                    if (coachC.isSelected())
                        priceLabelObs.setText(String.valueOf(f.getPrice() + f.getPrice() * 1 / 4));

                    else priceLabelObs.setText(String.valueOf(f.getPrice()));

                    break;
                }
            }

        } catch(Exception e){}

    }


    public static void setPrice() {
        try{
            String flight_route = routeBox.getValue();
            String flight_date = departure_datePicker.getValue().toString();

            for (FlightTable f : FlightTableData.getFlightTableItems())
                if (f.getDeparture_date().equalsIgnoreCase(flight_date) &&
                        (f.getDeparture_city() + " -> " + f.getArrival_city()).equalsIgnoreCase(flight_route)) {

                    if (firstC.isSelected())
                        priceLabelObs.setText(String.valueOf(f.getPrice() + f.getPrice() * 1 / 2));
                    else
                    if (coachC.isSelected())
                        priceLabelObs.setText(String.valueOf(f.getPrice() + f.getPrice() * 1 / 4));

                    else priceLabelObs.setText(String.valueOf(f.getPrice()));

                    break;
                }

        } catch(Exception e){}
    }


    //setting booking for edit
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


            if(booking.getFare_class().equalsIgnoreCase("first class"))
                firstC.setSelected(true);
           else if(booking.getFare_class().equalsIgnoreCase("coach"))
                coachC.setSelected(true);
            else economyC.setSelected(true);

            setPrice();
        }
    }



    //ok button action
    public static void handle_okButton() {
        if(isInputValid()) {

            String customer = customerBox.getValue();
            for (Customer c : CustomerData.getCustomers()) {
                if ((c.getFirst_name() + " " + c.getLast_name()).equalsIgnoreCase(customer)) {
                    booking.setCustomer_id(c.getCustomer_id());
                    break;
                }
            }

            String flight_route = routeBox.getValue();
            String flight_date = departure_datePicker.getValue().toString();
            for (FlightTable f : FlightTableData.getFlightTableItems()) {
                if (f.getDeparture_date().equalsIgnoreCase(flight_date) &&
                        (f.getDeparture_city() + " -> " + f.getArrival_city()).equalsIgnoreCase(flight_route)) {
                    booking.setFlight_id(f.getFlight_id());
                    break;
                }
            }


            if (firstC.isSelected())
                booking.setFare_class("First class");
            else if (coachC.isSelected())
                booking.setFare_class("Coach");
            else booking.setFare_class("Economy");


            for (Flight f : FlightData.getFlight()) {
                if (f.getFlight_id() == booking.getFlight_id()) {
                    if (booking.getFare_class().equalsIgnoreCase("first class"))
                        f.setFirst_class_left(f.getFirst_class_left() - 1);
                    else if (booking.getFare_class().equalsIgnoreCase("coach"))
                        f.setCoach_left(f.getCoach_left() - 1);
                    else f.setEconomy_left(f.getEconomy_left() - 1);

                    FlightData.updateFlight(f);

                    break;
                }
            }

            okPressed = true;
            BookingEditScene.getDialogStage().close();
        }
    }



    //cancel button action
    public static void handleClose(){
        okPressed = false;
        BookingEditScene.getDialogStage().close();
    }


    //method to disable unavailable dates from calendar
    public static void setDatePicker() {
        ArrayList<String> flightDates = new ArrayList<>();

        if(!routeBox.getSelectionModel().isEmpty())
        try {
        for (FlightTable f : FlightTableData.getFlightTableItems()) {
            if(routeBox.getValue().equalsIgnoreCase(f.getDeparture_city() + " -> " + f.getArrival_city()) &&
                    LocalDate.parse(f.getDeparture_date()).isAfter(LocalDate.now()) &&
                    flightAvailable(f))
                flightDates.add(f.getDeparture_date());
        }

        if (flightDates.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(MainControl.getWindow());
            alert.setHeaderText("No flights available");
            alert.setContentText("There are no flights available on this route");
            alert.showAndWait();
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

                            for (int i = 0; i < flightDates.size(); i++)
                                if (item.isEqual(LocalDate.parse(flightDates.get(i)))) {
                                    setDisable(false);
                                    setStyle("-fx-background-color: limegreen");
                                }

                            if (item.isEqual(departure_datePicker.getValue()))
                                setStyle("-fx-border-color: white");
                        }
                    };
                }
            };

            departure_datePicker.setValue(LocalDate.parse(flightDates.get(0)));
            departure_datePicker.setDayCellFactory(dayCellFactory);
        }
        catch (Exception e) {
            departure_datePicker.setValue(null);
            priceLabelObs.setText("");
        }
    }


    //see if the flight has available seats
    public static boolean flightAvailable(FlightTable fTab) {
        boolean ok = false;

        for(Flight f : FlightData.getFlight()) {
            if (f.getFlight_id() == fTab.getFlight_id()) {
                if (f.getEconomy_left() >0 || f.getCoach_left() >0 || f.getFirst_class_left() >0)
                    ok = true;
                break;
            }
        }

        return ok;
    }


    //method to verify user input
    public static boolean isInputValid() {
        String error = "";

        if (customerBox == null || customerBox.getSelectionModel().isEmpty()) {
            error += "No customer selected\n";
        }
        if (routeBox == null || routeBox.getSelectionModel().isEmpty()) {
            error += "No route selected\n";
        }

        if (error.equalsIgnoreCase(""))
            return true;

        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MainControl.getWindow());
            alert.setHeaderText("Invalid booking!");
            alert.setContentText(error);
            alert.showAndWait();

            return false;
        }
    }


    //getters
    public static Booking getBooking() {
        return booking;
    }

    public static boolean isOkPressed() {
        return okPressed;
    }

}
