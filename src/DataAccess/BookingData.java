package DataAccess;

import Application.DataTypes.Admin;
import Application.DataTypes.Airline;
import Application.DataTypes.Booking;
import Application.DataTypes.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Administrator on 5/19/2016.
 */
public class BookingData {
    private static Connection connection;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hermes_airline?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = DataConnection.password;
    private static Statement statement;
    private static ObservableList<Booking> bookings;


    public static ObservableList<Booking> getBookings(){
        bookings = FXCollections.observableArrayList();


        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT* FROM booking");
            if(rs != null)
                while (rs.next()) {
                    Booking booking = new Booking();
                    booking.setBooking_id(rs.getInt(1));
                    booking.setCustomer_id(rs.getInt(2));
                    booking.setFlight_id(rs.getInt(3));
                    booking.setFare_class(rs.getString(4));
                    booking.setReserved(rs.getBoolean(5));

                    bookings.add(booking);
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return bookings;
    }


    //method to add a booking
    public static void insertBooking(Booking booking)
    {
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO booking VALUE(default, " + booking.getCustomer_id() + ", " + booking.getFlight_id() + ", '" + booking.getFare_class() + "', " + 1 + ");");

            bookings.add(booking);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void updateBooking(Booking booking){
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement.executeUpdate("UPDATE booking SET customer_id = " + booking.getCustomer_id() + ", flight_id = " + booking.getFlight_id() + ", class = '" + booking.getFare_class() + "' WHERE booking_id = " + booking.getBooking_id() + ";" );

            bookings.set(booking.getBooking_id() - 1, booking);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }



    public static void deleteBooking(Booking booking){
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement.executeUpdate("DELETE FROM  booking WHERE booking_id = " + booking.getBooking_id() + ";");

            bookings.remove(booking);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

}
