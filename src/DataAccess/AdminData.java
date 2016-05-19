package DataAccess;

import Application.DataTypes.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 5/19/2016.
 */
public class AdminData {
    //fields
    private static Connection connection;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hermes_airline?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = DataConnection.password;
    private static Statement statement;

    //get admins
    public static ArrayList<Admin> getAdmins(){
        ArrayList<Admin> admins = new ArrayList<>();
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT* FROM admin");
            if(rs != null)
                while (rs.next()) {
                    Admin admin = new Admin();
                    admin.setAdmin_id(rs.getInt(1));
                    admin.setFirst_name(rs.getString(2));
                    admin.setLast_name(rs.getString(3));
                    admin.setPassword(rs.getString(4));
                    admins.add(admin);

                }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return admins;
    }



}
