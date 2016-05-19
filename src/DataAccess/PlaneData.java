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

    public static ArrayList<Plane> getPlanes(){
        ArrayList<Plane> planes = new ArrayList<>();
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT* FROM plane");
            if(rs != null)
                while (rs.next()) {
                    Plane plane = new Plane();
                    plane.setPlane_id(rs.getInt(1));
                    plane.setFirst_class(rs.getInt(2));
                    plane.setCoach(rs.getInt(3));
                    plane.setEconomy(rs.getInt(4));
                    plane.setPlane_name(rs.getString(5));
                    planes.add(plane);

                }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return planes;
    }
}
