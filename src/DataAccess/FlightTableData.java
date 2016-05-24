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
    public static ObservableList<FlightTable> flightTableItems;

    //
    public static ObservableList<FlightTable> getFlightTableItems(){
        flightTableItems = FXCollections.observableArrayList();


        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT departure_date, arrival_date, departure_city, arrival_city " +
                    "FROM flight f JOIN  schedule s " +
                    "ON f.schedule_id = s.schedule_id " +
                    "JOIN airline a " +
                    "ON f.airline_id = a.airline_id");
            if(rs!=null)
                while(rs.next()){
                    FlightTable f = new FlightTable();
                    f.setDeparture_date(rs.getDate(1).toString());
                    f.setArrival_date(rs.getDate(2).toString());
                    f.setDeparture_city(rs.getString(3));
                    f.setArrival_city(rs.getString(4));
                    f.setPrice(10);
                    flightTableItems.add(f);
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }




        return  flightTableItems;
    }
}
