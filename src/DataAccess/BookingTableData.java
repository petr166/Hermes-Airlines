package DataAccess;

import Application.DataTypes.BookingTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Petru on 26-May-16.
 */

public class BookingTableData {

    //fields
    private static Statement statement;
    private static ObservableList<BookingTable> bookingTableItems;


    //get booking table items
    public static ObservableList<BookingTable> getBookingTableItems() {
        bookingTableItems = FXCollections.observableArrayList();

        try{
            statement = DataConnection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT departure_date, departure_city, arrival_city, first_name, last_name, booking_id " +
                    "FROM booking b JOIN flight f " +
                    "ON b.flight_id = f.flight_id " +
                    "JOIN customer c " +
                    "ON b.customer_id = c.customer_id " +
                    "JOIN schedule s " +
                    "ON f.schedule_id = s.schedule_id " +
                    "JOIN airline a " +
                    "ON f.airline_id = a.airline_id " +
                    "ORDER BY departure_date;");

            if(rs!=null)
                while(rs.next()){
                    BookingTable b = new BookingTable();
                    b.setDeparture_date(rs.getDate(1).toString());
                    b.setRoute(rs.getString(2) + " -> " + rs.getString(3));
                    b.setCustomer(rs.getString(4) + " " + rs.getString(5));
                    b.setBooking_id(rs.getInt(6));

                    bookingTableItems.add(b);
                }
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return  bookingTableItems;
    }

}
