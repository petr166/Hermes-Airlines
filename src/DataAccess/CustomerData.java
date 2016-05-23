package DataAccess;

import Application.DataTypes.Customer;
import Application.DataTypes.Plane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Petru on 19-May-16.
 */
public class CustomerData {
    //fields
    private static Connection connection;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hermes_airline?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = DataConnection.password;
    private static Statement statement;
    private static ObservableList<Customer> customers = FXCollections.observableArrayList();


    //get admins
    public static ObservableList<Customer> getCustomers(){
        customers = FXCollections.observableArrayList();
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();

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
                    //customer.setPhone_nr("0");

                    customers.add(customer);

                }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return customers;
    }

    public static void insertCustomer(Customer customer)
    {
        customers.add(customer);
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            statement.executeUpdate("insert into customer values(default,'"+customer.getFirst_name()+"','"+customer.getLast_name()+"',"+customer.getAge()+",'"+customer.getPassport_number()+','+customer.getPhone_nr() +"');");
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
    public static void deleteCustomer(Customer customer){
        customers.remove(customer);
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            PreparedStatement st= connection.prepareStatement("DELETE FROM  customer WHERE customer_id = ?");
            st.setInt(1,customer.getCustomer_id());
            st.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void updateCustomer(Customer customer){
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            PreparedStatement st= connection.prepareStatement("UPDATE customer SET first_name = ?, last_name = ?, age = ?, passport_number = ?, phone_number = ? WHERE customer_id = ?");
            st.setString(1,customer.getFirst_name());
            st.setString(2,customer.getLast_name());
            st.setInt(3,customer.getAge());
            st.setString(4,customer.getPassport_number());
            st.setString(5,customer.getPhone_nr());
            st.setInt(6,customer.getCustomer_id());
            st.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
