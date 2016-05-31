package DataAccess;

import Application.DataTypes.Schedule;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Administrator on 5/19/2016.
 */

public class ScheduleData {

    //fields
    private static Statement statement;
    private static ArrayList<Schedule> schedules;


    //get schedules
    public static ArrayList<Schedule> getSchedules(){
        schedules = new ArrayList<>();

        try{
            statement = DataConnection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT* FROM schedule");

            if(rs != null)
                while (rs.next()) {
                    Schedule schedule = new Schedule();
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



    //method to add a schedule
    public static void insertSchedule(Schedule schedule){
        try {
            statement.executeUpdate("INSERT INTO schedule VALUE(default, '" + schedule.getDeparture_date() + "', '" + schedule.getDeparture_time() + "', '" + schedule.getArrival_date() + "', '" + schedule.getArrival_time() + "');");
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

}
