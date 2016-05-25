package DataAccess;

import Application.DataTypes.Admin;
import Application.DataTypes.Airline;
import Application.DataTypes.Customer;
import Application.DataTypes.Plane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Petru on 19-May-16.
 */
public class AirlineData {
    //fields
    private static Connection connection;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hermes_airline?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = DataConnection.password;
    private static Statement statement;
    private static ObservableList<Airline> airlines = FXCollections.observableArrayList();

    //get admins
    public static ObservableList<Airline> getAirlines(){


        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT* FROM airline");
            if(rs != null)

                while (rs.next()) {
                    Airline airline = new Airline();
                    airline.setAirline_id(rs.getInt(1));
                    airline.setDeparture_city(rs.getString(2));
                    airline.setArrival_city(rs.getString(3));
                    airlines.add(airline);

                }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return airlines;
    }


    public static void insertAirline(Airline airline)
    {
        airlines.add(airline);
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            statement.executeUpdate("insert into airline values(default,'"+airline.getDeparture_city()+"','"+airline.getArrival_city()+"');");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void deleteAirline(Airline airline){
        airlines.remove(airline);
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement.executeUpdate("DELETE FROM  airline WHERE airline_id = " + airline.getAirline_id() + ";");

            airlines.remove(airline);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
