package DataAccess;

import Application.DataTypes.Admin;
import Application.DataTypes.Schedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Administrator on 5/19/2016.
 */
public class ScheduleData {
    private static Connection connection;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hermes_airline?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = DataConnection.password;
    private static Statement statement;

    public static ArrayList<Schedule> getSchedules(){
        ArrayList<Schedule> schedules = new ArrayList<>();
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,user,password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT* FROM schedule");
            if(rs != null)
                while (rs.next()) {
                    Schedule schedule= new Schedule();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    schedule.setSchedule_id(rs.getInt(1));
                    schedule.setDeparture_date(rs.getDate(2));
                    schedule.setDeparture_time(rs.getString(3));
                    schedule.setArrival_date(rs.getDate(4));
                    schedule.setArrival_time(rs.getString(5));
                    schedules.add(schedule);
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return schedules;
    }
}
