package Application.DataTypes;

/**
 * Created by Petru on 18-May-16.
 */

public class Plane {

    //fields
    private int plane_id, first_class, coach, economy;
    private String plane_name;


    //constructors
    public Plane() {}

    public Plane(int plane_id, int first_class, int coach, int economy, String plane_name) {
        this.plane_id = plane_id;
        this.first_class = first_class;
        this.coach = coach;
        this.economy = economy;
        this.plane_name = plane_name;
    }


    //getters, setters
    public int getPlane_id() {
        return plane_id;
    }

    public void setPlane_id(int plane_id) {
        this.plane_id = plane_id;
    }

    public int getFirst_class() {
        return first_class;
    }

    public void setFirst_class(int first_class) {
        this.first_class = first_class;
    }

    public int getCoach() {
        return coach;
    }

    public void setCoach(int coach) {
        this.coach = coach;
    }

    public int getEconomy() {
        return economy;
    }

    public void setEconomy(int economy) {
        this.economy = economy;
    }

    public String getPlane_name() {
        return plane_name;
    }

    public void setPlane_name(String plane_name) {
        this.plane_name = plane_name;
    }


    //toString method
    @Override
    public String toString() {
        return "Plane{" +
                "plane_id=" + plane_id +
                ", first_class=" + first_class +
                ", coach=" + coach +
                ", economy=" + economy +
                ", plane_name='" + plane_name + '\'' +
                '}';
    }
}
