package DataAccess;

import Application.DataTypes.Admin;
import Application.DataTypes.Flight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by DragonClau on 19/5/2016.
 */
public class FlightData {
        //fields
        private static Connection connection;
        private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hermes_airline?autoReconnect=true&useSSL=false";
        private static String user = "root";
        private static String password = DataConnection.password;
        private static Statement statement;

        //get admins
        public static ArrayList<Flight> getFlight(){
            ArrayList<Flight> flights = new ArrayList<>();
            try{
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL,user,password);
                statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT* FROM flight");
                if(rs != null)
                    while (rs.next()) {
                        Flight flight = new Flight();
                        flight.setFlight_id(rs.getInt(1));
                        flight.setPlane_id(rs.getInt(2));
                        flight.setAirline_id(rs.getInt(3));
                        flight.setSchedule_id(rs.getInt(4));
                        flight.setFirst_class_left(rs.getInt(5));
                        flight.setCoach_left(rs.getInt(6));
                        flight.setEconomy_left(rs.getInt(7));
                        flight.setPrice(rs.getDouble(8));
                        flights.add(flight);
                    }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return flights;
        }
}

