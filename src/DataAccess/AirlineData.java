package DataAccess;

import Application.DataTypes.Admin;
import Application.DataTypes.Airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

    //get admins
    public static ArrayList<Airline> getAirlines(){

        ArrayList<Airline> airlines = new ArrayList<>();
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT* FROM airline");
            if(rs != null)

                while (rs.next()) {
                    Airline airline = new Airline();
                    airline.setAirline_id(rs.getInt(1));
                    airline.setDeparture_ciy(rs.getString(2));
                    airline.setArrival_city(rs.getString(3));

                    airlines.add(airline);

                }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return airlines;
    }
}
