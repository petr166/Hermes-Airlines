package DataAccess;

import Application.DataTypes.BookingTable;
import Application.DataTypes.FlightTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Petru on 26-May-16.
 */

public class BookingTableData {

    //fields
    private static Connection connection;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hermes_airline?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = DataConnection.password;
    private static Statement statement;
    private static ObservableList<BookingTable> bookingTableItems;


    //
    public static ObservableList<BookingTable> getBookingTableItems() {
        bookingTableItems = FXCollections.observableArrayList();


        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
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
