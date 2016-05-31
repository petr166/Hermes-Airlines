package DataAccess;

import Application.DataTypes.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by Petru on 19-May-16.
 */

public class CustomerData {

    //fields
    private static Statement statement;
    private static ObservableList<Customer> customers;


    //get customers
    public static ObservableList<Customer> getCustomers(){
        customers = FXCollections.observableArrayList();

        try{
            statement = DataConnection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT* FROM customer");

            if(rs != null)
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setCustomer_id(rs.getInt(1));
                    customer.setFirst_name(rs.getString(2));
                    customer.setLast_name(rs.getString(3));
                    customer.setAge(rs.getInt(4));
                    customer.setPassport_number(rs.getString(5));
                    customer.setPhone_nr(rs.getString(6));

                    customers.add(customer);
                }
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return customers;
    }



    //method to add a customer
    public static void insertCustomer(Customer customer)
    {
        try{
            statement.executeUpdate("INSERT INTO customer VALUE(default, '" + customer.getFirst_name() + "', '" + customer.getLast_name() + "', " + customer.getAge() + ", '" + customer.getPassport_number() + "', '" + customer.getPhone_nr() + "');");
            customers.add(customer);
            customer.setCustomer_id(customers.indexOf(customer) + 1);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    //method to update a customer
    public static void updateCustomer(Customer customer){
        try{
            statement.executeUpdate("UPDATE customer SET first_name = '" + customer.getFirst_name() +"', last_name = '" + customer.getLast_name() + "', age = " + customer.getAge() + ", passport_number = '" + customer.getPassport_number() + "', phone_nr = '" + customer.getPhone_nr() + "' WHERE customer_id = " + customer.getCustomer_id() + ";");
            customers.set(customer.getCustomer_id() - 1, customer);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

}
