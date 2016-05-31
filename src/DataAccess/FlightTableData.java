package DataAccess;

import Application.DataTypes.FlightTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 5/24/2016.
 */
public class FlightTableData {

    //fields
    private static Connection connection;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hermes_airline?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = DataConnection.password;
    private static Statement statement;
    private static ObservableList<FlightTable> flightTableItems;

    //
    public static ObservableList<FlightTable> getFlightTableItems(){
        flightTableItems = FXCollections.observableArrayList();


        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT departure_date, departure_city, arrival_city, flight_id, price, first_class_left, coach_left, economy_left " +
                    "FROM flight f JOIN  schedule s " +
                    "ON f.schedule_id = s.schedule_id " +
                    "JOIN airline a " +
                    "ON f.airline_id = a.airline_id " +
                    "ORDER BY departure_date;");

            if(rs!=null)
                while(rs.next()){
                    FlightTable f = new FlightTable();
                    f.setDeparture_date(rs.getDate(1).toString());
                    f.setDeparture_city(rs.getString(2));
                    f.setArrival_city(rs.getString(3));
                    f.setFlight_id(rs.getInt(4));
                    f.setPrice(rs.getDouble(5));
                    f.setFirst_classLeft(rs.getInt(6));
                    f.setCoachLeft(rs.getInt(7));
                    f.setEconomyLeft(rs.getInt(8));

                    flightTableItems.add(f);
                }
        }

        catch(Exception e){
            e.printStackTrace();
        }


        return  flightTableItems;
    }

}
