package Application.DataTypes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import jdk.nashorn.internal.objects.DataPropertyDescriptor;

import java.util.Date;

/**
 * Created by Administrator on 5/23/2016.
 */
public class FlightTable {

    //fields
    private static StringProperty departure_date, arrival_date, departure_city, arrival_city;
    private static DoubleProperty price;

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


    //getters & setters
    public static String getDeparture_date() {
        return departure_date.get();
    }

    public static StringProperty departure_dateProperty() {
        return departure_date;
    }

    public static void setDeparture_date(String departure_date) {
        FlightTable.departure_date.set(departure_date);
    }

    public static String getArrival_date() {
        return arrival_date.get();
    }

    public static StringProperty arrival_dateProperty() {
        return arrival_date;
    }

    public static void setArrival_date(String arrival_date) {
        FlightTable.arrival_date.set(arrival_date);
    }

    public static String getDeparture_city() {
        return departure_city.get();
    }

    public static StringProperty departure_cityProperty() {
        return departure_city;
    }

    public static void setDeparture_city(String departure_city) {
        FlightTable.departure_city.set(departure_city);
    }

    public static String getArrival_city() {
        return arrival_city.get();
    }

    public static StringProperty arrival_cityProperty() {
        return arrival_city;
    }

    public static void setArrival_city(String arrival_city) {
        FlightTable.arrival_city.set(arrival_city);
    }

    public static double getPrice() {
        return price.get();
    }

    public static DoubleProperty priceProperty() {
        return price;
    }

    public static void setPrice(double price) {
        FlightTable.price.set(price);
    }

    //toString




}
