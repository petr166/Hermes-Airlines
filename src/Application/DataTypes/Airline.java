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
    private StringProperty departure_ciy, arrival_city;


    //constructors
    public Airline(){
        airline_id = new SimpleIntegerProperty();
        departure_ciy = new SimpleStringProperty();
        arrival_city = new SimpleStringProperty();
    }

    public Airline(int airline_id, String departure_city, String arrival_city){
        this.airline_id = new SimpleIntegerProperty(airline_id);
        this.departure_ciy = new SimpleStringProperty(departure_city);
        this.arrival_city = new SimpleStringProperty(arrival_city);
    }


    //getters & seters
    public int getAirline_id() {
        return airline_id.get();
    }

    public IntegerProperty airline_idProperty() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id.set(airline_id);
    }

    public String getDeparture_ciy() {
        return departure_ciy.get();
    }

    public StringProperty departure_ciyProperty() {
        return departure_ciy;
    }

    public void setDeparture_ciy(String departure_ciy) {
        this.departure_ciy.set(departure_ciy);
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
                ", departure_ciy=" + departure_ciy +
                ", arrival_city=" + arrival_city +
                '}';
    }

}
