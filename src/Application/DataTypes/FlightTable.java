package Application.DataTypes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Administrator on 5/24/2016.
 */
public class FlightTable {
    //fields
    private  StringProperty departure_date, arrival_date, departure_city, arrival_city;
    private  DoubleProperty price;

    //constructors
    public FlightTable() {
        departure_date = new SimpleStringProperty("");
        arrival_date = new SimpleStringProperty("");
        departure_city = new SimpleStringProperty("");
        arrival_city = new SimpleStringProperty("");
        price = new SimpleDoubleProperty(0);
    }
    public FlightTable(String departure_date, String arrival_date, String departure_city, String arrival_city, double price){
        this.departure_date = new SimpleStringProperty(departure_date);
        this.arrival_date = new SimpleStringProperty(arrival_date);
        this.departure_city = new SimpleStringProperty(departure_city);
        this.arrival_city = new SimpleStringProperty(arrival_city);
        this.price = new SimpleDoubleProperty(price);

    }

    //getters setters

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
