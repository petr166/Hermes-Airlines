package DataAccess;

import Application.DataTypes.Admin;
import Application.DataTypes.Booking;

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


    public static ArrayList<Booking> getBookings(){
        ArrayList<Booking> bookings = new ArrayList<>();
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
}
