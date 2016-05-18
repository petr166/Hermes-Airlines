package Application.DataTypes;

/**
 * Created by Petru on 18-May-16.
 */

public class Admin {

    //fields
    private int admin_id;
    private String first_name, last_name, password;


    //constructors
    public Admin() {}

    public Admin(int admin_id, String first_name, String last_name, String password) {
        this.admin_id = admin_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }


    //getters, setters
    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //toString method
    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
