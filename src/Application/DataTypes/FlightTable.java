package Application.DataTypes;

import javafx.beans.property.*;

import java.util.Date;

/**
 * Created by Administrator on 5/24/2016.
 */
public class FlightTable {
    //fields
    private IntegerProperty flight_id;
    private  StringProperty departure_date, arrival_date, departure_city, arrival_city;
    private  DoubleProperty price;


    //constructors
    public FlightTable() {
        flight_id = new SimpleIntegerProperty(0);
        departure_date = new SimpleStringProperty(new Date().toString());
        arrival_date = new SimpleStringProperty(new Date().toString());
        departure_city = new SimpleStringProperty("");
        arrival_city = new SimpleStringProperty("");
        price = new SimpleDoubleProperty(0);
    }

    public FlightTable(String departure_date, String arrival_date, String departure_city, String arrival_city, double price, int flight_id){
        this.departure_date = new SimpleStringProperty(departure_date);
        this.arrival_date = new SimpleStringProperty(arrival_date);
        this.departure_city = new SimpleStringProperty(departure_city);
        this.arrival_city = new SimpleStringProperty(arrival_city);
        this.price = new SimpleDoubleProperty(price);
        this.flight_id = new SimpleIntegerProperty(flight_id);

    }

    //getters setters


    public int getFlight_id() {
        return flight_id.get();
    }

    public IntegerProperty flight_idProperty() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id.set(flight_id);
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

    public String getArrival_date() {
        return arrival_date.get();
    }

    public StringProperty arrival_dateProperty() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date.set(arrival_date);
    }

    public String getDeparture_city() {
        return departure_city.get();
    }

    public StringProperty departure_cityProperty() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city.set(departure_city);
    }

    public String getArrival_city() {
        return arrival_city.get();
    }

    public StringProperty arrival_cityProperty() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city.set(arrival_city);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    //toString

    @Override
    public String toString() {
        return "FlightTable{" +
                "departure_date=" + departure_date +
                ", arrival_date=" + arrival_date +
                ", departure_city=" + departure_city +
                ", arrival_city=" + arrival_city +
                ", price=" + price +
                '}';
    }
}
