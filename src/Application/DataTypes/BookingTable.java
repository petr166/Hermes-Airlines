package Application.DataTypes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Petru on 26-May-16.
 */

public class BookingTable {

    //fields
    private IntegerProperty booking_id;
    private StringProperty departure_date, route, customer;

    //constructors
    public BookingTable() {
        booking_id = new SimpleIntegerProperty();
        departure_date = new SimpleStringProperty();
        route = new SimpleStringProperty();
        customer = new SimpleStringProperty();
    }

    public BookingTable(int booking_id, String departure_date, String route, String customer) {
        this.booking_id = new SimpleIntegerProperty(booking_id);
        this.departure_date = new SimpleStringProperty(departure_date);
        this.route = new SimpleStringProperty(route);
        this.customer = new SimpleStringProperty(customer);
    }


    //getters, setters
    public int getBooking_id() {
        return booking_id.get();
    }

    public IntegerProperty booking_idProperty() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id.set(booking_id);
    }

    public String getDeparture_date() {
        return departure_date.get();
    }

    public StringProperty departure_dateProperty() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date.set(departure_date);
    }

    public String getRoute() {
        return route.get();
    }

    public StringProperty routeProperty() {
        return route;
    }

    public void setRoute(String route) {
        this.route.set(route);
    }

    public String getCustomer() {
        return customer.get();
    }

    public StringProperty customerProperty() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer.set(customer);
    }


    //toString method
    @Override
    public String toString() {
        return "BookingTable{" +
                "booking_id=" + booking_id +
                ", departure_date=" + departure_date +
                ", route=" + route +
                ", customer=" + customer +
                '}';
    }

}
