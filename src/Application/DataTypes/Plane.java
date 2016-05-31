package Application.DataTypes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Petru on 18-May-16.
 */

public class Plane {

    //fields
    private IntegerProperty plane_id, first_class, coach, economy;
    private StringProperty plane_name;


    //constructors
    public Plane() {
        this.plane_id = new SimpleIntegerProperty();
        this.first_class = new SimpleIntegerProperty();
        this.coach = new SimpleIntegerProperty();
        this.economy = new SimpleIntegerProperty();
        this.plane_name = new SimpleStringProperty();

    }

    public Plane(int plane_id, int first_class, int coach, int economy, String plane_name) {
        this.plane_id = new SimpleIntegerProperty(plane_id);
        this.first_class = new SimpleIntegerProperty(first_class);
        this.coach = new SimpleIntegerProperty(coach);
        this.economy = new SimpleIntegerProperty(economy);
        this.plane_name = new SimpleStringProperty(plane_name);
    }


    //getters, setters
    public int getPlane_id() {
        return plane_id.get();
    }

    public IntegerProperty plane_idProperty() {
        return plane_id;
    }

    public void setPlane_id(int plane_id) {
        this.plane_id.set(plane_id);
    }

    public int getFirst_class() {
        return first_class.get();
    }

    public IntegerProperty first_classProperty() {
        return first_class;
    }

    public void setFirst_class(int first_class) {
        this.first_class.set(first_class);
    }

    public int getCoach() {
        return coach.get();
    }

    public IntegerProperty coachProperty() {
        return coach;
    }

    public void setCoach(int coach) {
        this.coach.set(coach);
    }

    public int getEconomy() {
        return economy.get();
    }

    public IntegerProperty economyProperty() {
        return economy;
    }

    public void setEconomy(int economy) {
        this.economy.set(economy);
    }

    public String getPlane_name() {
        return plane_name.get();
    }

    public StringProperty plane_nameProperty() {
        return plane_name;
    }

    public void setPlane_name(String plane_name) {
        this.plane_name.set(plane_name);
    }


    //toString method
    @Override
    public String toString() {
        return "Plane{" +
                "plane_id=" + plane_id +
                ", first_class=" + first_class +
                ", coach=" + coach +
                ", economy=" + economy +
                ", plane_name=" + plane_name +
                '}';
    }

}
