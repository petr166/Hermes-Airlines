package DataAccess;

import Application.DataTypes.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by DragonClau on 19/5/2016.
 */

public class FlightData {

    //fields
    private static Statement statement;
    private static ObservableList<Flight> flights;


    //get flights
    public static ObservableList<Flight> getFlight(){
        flights = FXCollections.observableArrayList();

        try{
            statement = DataConnection.getConnection().createStatement();
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



    //method to add a flight
    public static void insertFlight(Flight flight)
    {
        try{
            statement.executeUpdate("INSERT INTO flight VALUE(default, " + flight.getPlane_id() + ", " + flight.getAirline_id() + ", " + flight.getSchedule_id() + ", " + flight.getFirst_class_left() + ", " + flight.getCoach_left() + ", " + flight.getEconomy_left() + ", " + flight.getPrice() +");");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    //method to update a flight
    public static void updateFlight(Flight flight){
        try{
            statement.executeUpdate("UPDATE flight SET plane_id = "+flight.getPlane_id()+", schedule_id = "+flight.getSchedule_id()+", airline_id = "+flight.getAirline_id()+", first_class_left = "+flight.getFirst_class_left()+", coach_left = "+flight.getCoach_left()+",economy_left = "+flight.getEconomy_left()+",price = "+flight.getPrice()+" WHERE flight_id = "+flight.getFlight_id()+ ";");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    //method to export flight list to .txt
    public static void exportFlights()
    {
        String filePath = "C:\\test.txt";
        try{
            FileOutputStream out = new FileOutputStream(filePath);
            for(Flight f : flights)
            {
                String flightData = f.toString();
                out.write(flightData.getBytes());
            }
            out.close();


        }catch (Exception e){}


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Flights Exported!");
        alert.setHeaderText("Success!");
        alert.showAndWait();
    }

}

