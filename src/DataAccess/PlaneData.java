package DataAccess;

import Application.DataTypes.Plane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PlaneData {
    //fields
    private static Connection connection;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hermes_airline?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = DataConnection.password;
    private static Statement statement;
    private static ObservableList<Plane> planes;


    //method to get planes list
    public static ObservableList<Plane> getPlanes(){
        planes = FXCollections.observableArrayList();
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT* FROM plane");

            if(rs != null)
                while (rs.next()) {
                    Plane plane = new Plane();
                    plane.setPlane_id(rs.getInt(1));
                    plane.setFirst_class(rs.getInt(3));
                    plane.setCoach(rs.getInt(4));
                    plane.setEconomy(rs.getInt(5));
                    plane.setPlane_name(rs.getString(2));

                    planes.add(plane);
                }
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return planes;
    }


    //method to add a plane
    public static void insertPlanes(Plane plane)
    {
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO plane VALUE (default, '" + plane.getPlane_name() + "', " + plane.getFirst_class() + ", " + plane.getCoach() + ", " + plane.getEconomy() + ");");
            planes.add(plane);
            plane.setPlane_id(planes.indexOf(plane) + 1);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    //method to remove a plane
    public static void deletePlane(Plane plane) {
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM  plane WHERE plane_id = " + plane.getPlane_id() + ";");
            planes.remove(plane);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    //method to update a plane details
    public static void updatePlane(Plane plane){
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement.executeUpdate("UPDATE plane SET plane_name = '" + plane.getPlane_name() + "', first_class = " + plane.getFirst_class() + ", coach = " + plane.getCoach() + ", economy = " + plane.getEconomy() + " WHERE plane_id = " + plane.getPlane_id() + ";");
            planes.set(plane.getPlane_id() - 1, plane);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}
