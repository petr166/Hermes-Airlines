package Application.Control;

import Application.DataTypes.*;
import DataAccess.*;
import Presentation.BookingEditScene;
import Presentation.FlightsEditScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.util.Callback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.print.Book;
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
  //  private static ComboBox<String> categoryBox;

    //dd

    private static RadioButton firstC;
    private static RadioButton coachC;
    private static RadioButton economyC;
   // private static ToggleGroup g;

    //dd


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
        ObservableList<String> ca = FXCollections.observableArrayList();

        for(Customer c : CustomerData.getCustomers())
            if(!customerBox.getItems().contains(c.getFirst_name() + " " + c.getLast_name()))
            customerBox.getItems().add(c.getFirst_name() + " " + c.getLast_name());

        routeBox = BookingEditScene.getRouteBox();
        routeBox.setOnAction(e-> {
            setDatePicker();
        });




        for(Airline a : AirlineData.getAirlines())
            if(!routeBox.getItems().contains(a.getDeparture_city() + " -> " + a.getArrival_city()))
            routeBox.getItems().add(a.getDeparture_city() + " -> " + a.getArrival_city());


        departure_datePicker = BookingEditScene.getDeparture_datePicker();
        departure_datePicker.setOnAction(e->
        {
            handleRouteAction();
         //   handle_disableCategory();
        }
        );

      /*  categoryBox = BookingEditScene.getCategoryBox();
        categoryBox.setOnAction(e->handleRouteAction());
*/
        //dd
        firstC = BookingEditScene.getFirstC();
        firstC.setOnAction(e->handleRouteAction1());
        coachC = BookingEditScene.getCoachC();
        coachC.setOnAction(e->handleRouteAction1());
        economyC = BookingEditScene.getEconomyC();
        economyC.setOnAction(e->handleRouteAction1());


        //dd
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

                    for(Flight flight: FlightData.getFlight())
                        if(flight.getFlight_id()==f.getFlight_id()){
                            if(flight.getFirst_class_left()<1&&!firstC.isSelected())
                                firstC.setDisable(true);
                            else firstC.setDisable(false);

                            if(flight.getCoach_left()<1&&!coachC.isSelected())
                                coachC.setDisable(true);
                            else coachC.setDisable(false);


                            if(flight.getEconomy_left()<1&&!economyC.isSelected())
                                economyC.setDisable(true);
                            else economyC.setDisable(false);
                        }


                    if (firstC.isSelected())
                        priceLabelObs.setText(String.valueOf(f.getPrice() + f.getPrice() * 1 / 2));
                    else
                        if (coachC.isSelected())
                            priceLabelObs.setText(String.valueOf(f.getPrice() + f.getPrice() * 1 / 4));

                    else priceLabelObs.setText(String.valueOf(f.getPrice()));


                }
            }

        } catch(Exception e){}

    }

    public static void handleRouteAction1() {

        try{
            String flight_route = routeBox.getValue();
            String flight_date = departure_datePicker.getValue().toString();
            for (FlightTable f : FlightTableData.getFlightTableItems()) {
                if (f.getDeparture_date().equalsIgnoreCase(flight_date) &&
                        (f.getDeparture_city() + " -> " + f.getArrival_city()).equalsIgnoreCase(flight_route))


                    if (firstC.isSelected())
                        priceLabelObs.setText(String.valueOf(f.getPrice() + f.getPrice() * 1 / 2));
                    else
                    if (coachC.isSelected())
                        priceLabelObs.setText(String.valueOf(f.getPrice() + f.getPrice() * 1 / 4));

                    else priceLabelObs.setText(String.valueOf(f.getPrice()));


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


            if(booking.getFare_class().equalsIgnoreCase("first class"))
                firstC.setSelected(true);
           else if(booking.getFare_class().equalsIgnoreCase("coach"))
                coachC.setSelected(true);
            else economyC.setSelected(true);


            priceLabelObs.setText(String.valueOf(flight.getPrice()));
            handleRouteAction();
        }
    }



    public static void handle_okButton() {
        okPressed = true;

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
        //dd
        if(firstC.isSelected())
        booking.setFare_class("First class");
        else
            if(coachC.isSelected())
                booking.setFare_class("Coach");
        else booking.setFare_class("Economy");
        //dd


        for(Flight f: FlightData.getFlight()){
            if(f.getFlight_id()==booking.getFlight_id()){
                if(booking.getFare_class().equalsIgnoreCase("first class"))
                    f.setFirst_class_left(f.getFirst_class_left() - 1);
                else if(booking.getFare_class().equalsIgnoreCase("coach"))
                    f.setCoach_left(f.getCoach_left()-1);
                else f.setEconomy_left(f.getEconomy_left()-1);
                FlightData.updateFlight(f);
            }
        }


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
