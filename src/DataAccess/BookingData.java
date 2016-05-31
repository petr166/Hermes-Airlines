package DataAccess;

import Application.DataTypes.Booking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 5/19/2016.
 */

public class BookingData {

    //fields
    private static Statement statement;
    private static ObservableList<Booking> bookings;


    //get bookings
    public static ObservableList<Booking> getBookings(){
        bookings = FXCollections.observableArrayList();

        try{
            statement = DataConnection.getConnection().createStatement();
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
            statement.executeUpdate("INSERT INTO booking VALUE(default, " + booking.getCustomer_id() + ", " + booking.getFlight_id() + ", '" + booking.getFare_class() + "', " + 1 + ");");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }



    //method to edit a booking
    public static void updateBooking(Booking booking){
        try{
            statement.executeUpdate("UPDATE booking SET customer_id = " + booking.getCustomer_id() + ", flight_id = " + booking.getFlight_id() + ", class = '" + booking.getFare_class() + "' WHERE booking_id = " + booking.getBooking_id() + ";" );
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }



    //method to remove a booking
    public static void deleteBooking(Booking booking){
        try{
            statement.executeUpdate("DELETE FROM booking WHERE booking_id = " + booking.getBooking_id() + ";");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

}
