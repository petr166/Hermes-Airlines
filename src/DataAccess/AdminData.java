package DataAccess;

import Application.DataTypes.Admin;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Administrator on 5/19/2016.
 */

public class AdminData {

    //fields
    private static ArrayList<Admin> admins;
    private static Statement statement;


    //get admins
    public static ArrayList<Admin> getAdmins(){
        admins = new ArrayList<>();

        try{
            statement = DataConnection.getConnection().createStatement();
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
