package Application.DataTypes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by Petru on 18-May-16.
 */

public class Flight {

    //fields
    private IntegerProperty flight_id, plane_id, airline_id, schedule_id, first_class_left, coach_left, economy_left;
    private DoubleProperty price;


    //constructors
    public Flight() {
        flight_id = new SimpleIntegerProperty(0);
        plane_id = new SimpleIntegerProperty(1);
        schedule_id = new SimpleIntegerProperty(0);
        airline_id = new SimpleIntegerProperty(0);
        first_class_left = new SimpleIntegerProperty(0);
        coach_left = new SimpleIntegerProperty(0);
        economy_left = new SimpleIntegerProperty(0);
        price = new SimpleDoubleProperty(0);
    }

    public Flight(int flight_id, int plane_id, int airline_id, int schedule_id, int first_class_left, int coach_left, int economy_left, int price) {
        this.flight_id = new SimpleIntegerProperty(flight_id);
        this.plane_id = new SimpleIntegerProperty(plane_id);
        this.airline_id = new SimpleIntegerProperty(airline_id);
        this.schedule_id = new SimpleIntegerProperty(schedule_id);
        this.first_class_left = new SimpleIntegerProperty(first_class_left);
        this.coach_left = new SimpleIntegerProperty(coach_left);
        this.economy_left = new SimpleIntegerProperty(economy_left);
        this.price = new SimpleDoubleProperty(price);
    }


    //getters, setters
    public int getFlight_id() {
        return flight_id.get();
    }

    public IntegerProperty flight_idProperty() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id.set(flight_id);
    }

    public int getPlane_id() {
        return plane_id.get();
    }

    public IntegerProperty plane_idProperty() {
        return plane_id;
    }

    public void setPlane_id(int plane_id) {
        this.plane_id.set(plane_id);
    }

    public int getAirline_id() {
        return airline_id.get();
    }

    public IntegerProperty airline_idProperty() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id.set(airline_id);
    }

    public int getSchedule_id() {
        return schedule_id.get();
    }

    public IntegerProperty schedule_idProperty() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id.set(schedule_id);
    }

    public int getFirst_class_left() {
        return first_class_left.get();
    }

    public IntegerProperty first_class_leftProperty() {
        return first_class_left;
    }

    public void setFirst_class_left(int first_class_left) {
        this.first_class_left.set(first_class_left);
    }

    public int getCoach_left() {
        return coach_left.get();
    }

    public IntegerProperty coach_leftProperty() {
        return coach_left;
    }

    public void setCoach_left(int coach_left) {
        this.coach_left.set(coach_left);
    }

    public int getEconomy_left() {
        return economy_left.get();
    }

    public IntegerProperty economy_leftProperty() {
        return economy_left;
    }

    public void setEconomy_left(int economy_left) {
        this.economy_left.set(economy_left);
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


    //toString method
    @Override
    public String toString() {
        return getFlight_id()+","+getAirline_id()+","+getPlane_id()+","+getSchedule_id()+","+getCoach_left()+","+getEconomy_left()+","+getFirst_class_left()+","+getPrice()+"\n";
    }

}
