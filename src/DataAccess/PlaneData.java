package DataAccess;

import Application.DataTypes.Plane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.FileOutputStream;
import java.sql.*;

public class PlaneData {

    //fields
    private static Statement statement;
    private static ObservableList<Plane> planes;


    //get planes
    public static ObservableList<Plane> getPlanes(){
        planes = FXCollections.observableArrayList();

        try{
            statement = DataConnection.getConnection().createStatement();
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
            statement.executeUpdate("INSERT INTO plane VALUE (default, '" + plane.getPlane_name() + "', " + plane.getFirst_class() + ", " + plane.getCoach() + ", " + plane.getEconomy() + ");");
            planes.add(plane);
            plane.setPlane_id(planes.indexOf(plane) + 1);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }



    //method to update a plane details
    public static void updatePlane(Plane plane){
        try{
            statement.executeUpdate("UPDATE plane SET plane_name = '" + plane.getPlane_name() + "', first_class = " + plane.getFirst_class() + ", coach = " + plane.getCoach() + ", economy = " + plane.getEconomy() + " WHERE plane_id = " + plane.getPlane_id() + ";");
            planes.set(plane.getPlane_id() - 1, plane);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }



    //method to export plane list to .txt
    public static void exportPlanes()
    {
        String filePath = "C:/Exported_Planes.txt";
        try{
            FileOutputStream out = new FileOutputStream(filePath);
            for(Plane p : planes)
            {
                String planesData = p.toString();
                out.write(planesData.getBytes());
            }
            out.close();


        }catch (Exception e){}


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Planes Exported!");
        alert.setHeaderText("Success!");
        alert.showAndWait();
    }

}
