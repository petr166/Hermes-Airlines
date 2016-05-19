package Application.DataTypes;

import javafx.beans.property.*;

/**
 * Created by Petru on 18-May-16.
 */

public class Booking {

    //fields
    private IntegerProperty booking_id, customer_id, flight_id;
    private StringProperty fare_class;
    private BooleanProperty reserved;


    //constructors
    public Booking() {
        booking_id = new SimpleIntegerProperty();
        customer_id = new SimpleIntegerProperty();
        flight_id = new SimpleIntegerProperty();
        fare_class = new SimpleStringProperty();
        reserved = new SimpleBooleanProperty();
    }

    public Booking(int booking_id, int customer_id, int flight_id, String fare_class, boolean reserverd) {
        this.booking_id = new SimpleIntegerProperty(booking_id);
        this.customer_id = new SimpleIntegerProperty(customer_id);
        this.flight_id = new SimpleIntegerProperty(flight_id);
        this.fare_class = new SimpleStringProperty(fare_class);
        this.reserved = new SimpleBooleanProperty(reserverd);
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

    public int getCustomer_id() {
        return customer_id.get();
    }

    public IntegerProperty customer_idProperty() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id.set(customer_id);
    }

    public int getFlight_id() {
        return flight_id.get();
    }

    public IntegerProperty flight_idProperty() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id.set(flight_id);
    }

    public String getFare_class() {
        return fare_class.get();
    }

    public StringProperty fare_classProperty() {
        return fare_class;
    }

    public void setFare_class(String fare_class) {
        this.fare_class.set(fare_class);
    }

    public boolean getReserved() {
        return reserved.get();
    }

    public BooleanProperty reservedProperty() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved.set(reserved);
    }


    //toString method
    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", customer_id=" + customer_id +
                ", flight_id=" + flight_id +
                ", fare_class=" + fare_class +
                ", reserved=" + reserved +
                '}';
    }

}
