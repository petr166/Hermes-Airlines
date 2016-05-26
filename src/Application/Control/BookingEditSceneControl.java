package Application.Control;

import Application.DataTypes.*;
import DataAccess.CustomerData;
import DataAccess.FlightTableData;
import Presentation.BookingEditScene;
import Presentation.FlightsEditScene;
import javafx.scene.control.*;

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
        for(FlightTable f : FlightTableData.getFlightTableItems())
            routeBox.getItems().add(f.getDeparture_city() + " -> " + f.getArrival_city());

        departure_datePicker = BookingEditScene.getDeparture_datePicker();

        categoryBox = BookingEditScene.getCategoryBox();

        addCustomer = BookingEditScene.getAddCustomer();
        addCustomer.setOnAction(e -> ViewCustomerSceneControl.handle_addB());

        priceLabelObs = BookingEditScene.getPriceLabelObs();

        cancelButton = BookingEditScene.getCancelButton();
        cancelButton.setOnAction(e -> handleClose());

        okButton = BookingEditScene.getOkButton();
    }


    public static void handleClose(){
        okPressed = false;
        BookingEditScene.getDialogStage().close();
    }


    //getters
    public static Booking getBooking() {
        return booking;
    }

    public static boolean isOkPressed() {
        return okPressed;
    }
}
