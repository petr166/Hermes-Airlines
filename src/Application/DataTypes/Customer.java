package Application.DataTypes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Petru on 18-May-16.
 */

public class Customer {

    //fields
    private IntegerProperty customer_id, age;
    private StringProperty first_name, last_name, phone_nr, passport_number;


    //constructors
    public Customer() {
        customer_id = new SimpleIntegerProperty(1);
        age = new SimpleIntegerProperty(1);
        first_name = new SimpleStringProperty("");
        last_name = new SimpleStringProperty("");
        phone_nr = new SimpleStringProperty("123");
        passport_number = new SimpleStringProperty("");

    }

    public Customer(int customer_id, int age, String passport_number, String first_name, String last_name, String phone_nr) {
        this.customer_id = new SimpleIntegerProperty(customer_id);
        this.age = new SimpleIntegerProperty(age);
        this.passport_number = new SimpleStringProperty(passport_number);
        this.first_name = new SimpleStringProperty(first_name);
        this.last_name = new SimpleStringProperty(last_name);
        this.phone_nr = new SimpleStringProperty(phone_nr);

    }


    //getters, setters
    public int getCustomer_id() {
        return customer_id.get();
    }

    public IntegerProperty customer_idProperty() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id.set(customer_id);
    }

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getPassport_number() {
        return passport_number.get();
    }

    public StringProperty passport_numberProperty() {
        return passport_number;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number.set(passport_number);
    }

    public String getFirst_name() {
        return first_name.get();
    }

    public StringProperty first_nameProperty() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
    }

    public String getLast_name() {
        return last_name.get();
    }

    public StringProperty last_nameProperty() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }

    public String getPhone_nr() {
        return phone_nr.get();
    }

    public StringProperty phone_nrProperty() {
        return phone_nr;
    }

    public void setPhone_nr(String phone_nr) {
        this.phone_nr.set(phone_nr);
    }


    //toString method
    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", age=" + age +
                ", passport_number=" + passport_number +
                ", first_name=" + first_name +
                ", last_name=" + last_name +
                ", phone_nr" + phone_nr +
                '}';
    }

}
