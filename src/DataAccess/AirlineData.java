package DataAccess;

import Application.DataTypes.Airline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by Petru on 19-May-16.
 */

public class AirlineData {

    //fields
    private static Statement statement;
    private static ObservableList<Airline> airlines;


    //get airlines
    public static ObservableList<Airline> getAirlines(){
        airlines = FXCollections.observableArrayList();

        try{
            statement = DataConnection.getConnection().createStatement();
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

}
