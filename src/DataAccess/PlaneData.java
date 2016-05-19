package DataAccess;

import Application.DataTypes.Plane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaneData {
    //fields
    private static Connection connection;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hermes_airline?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = DataConnection.password;
    private static Statement statement;
    private static  ArrayList<Plane> planes = new ArrayList<>();
    public static ArrayList<Plane> getPlanes(){

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

    public static void insertPlanes(Plane plane)
    {
        planes.add(plane);
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            statement.executeUpdate("insert into plane values(default,\'"+plane.getPlane_name()+"\',"+plane.getFirst_class()+","+plane.getCoach()+","+plane.getEconomy()+");");

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
