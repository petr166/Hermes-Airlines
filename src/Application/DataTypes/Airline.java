package Application.DataTypes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Tudor on 5/18/2016.
 */

public class Airline {

    //fields
    private IntegerProperty airline_id;
    private StringProperty departure_city, arrival_city;


    //constructors
    public Airline(){
        airline_id = new SimpleIntegerProperty();
        departure_city = new SimpleStringProperty("");
        arrival_city = new SimpleStringProperty("");
    }

    public Airline(int airline_id, String departure_city, String arrival_city){
        this.airline_id = new SimpleIntegerProperty(airline_id);
        this.departure_city = new SimpleStringProperty(departure_city);
        this.arrival_city = new SimpleStringProperty(arrival_city);
    }


    //getters, setters
    public int getAirline_id() {
        return airline_id.get();
    }

    public IntegerProperty airline_idProperty() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id.set(airline_id);
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


    //toString
    @Override
    public String toString() {
        return "Airline{" +
                "airline_id=" + airline_id +
                ", departure_city=" + departure_city +
                ", arrival_city=" + arrival_city +
                '}';
    }

}
