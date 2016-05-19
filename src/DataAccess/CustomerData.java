package DataAccess;

import Application.DataTypes.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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


    //get admins
    public static ArrayList<Customer> getCustomers(){

        ArrayList<Customer> customers = new ArrayList<>();

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
                    //customer.setPhone_nr("0");

                    customers.add(customer);

                }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return customers;
    }
}
