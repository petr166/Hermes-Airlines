package Application.DataTypes;

import java.util.Date;

/**
 * Created by Administrator on 5/18/2016.
 */
public class Schedule {

    //fields
    private  int schedule_id;
    private Date departure_date;
    private String departure_time;
    private Date arrival_date;
    private String arrival_time;


    //constructors
    public Schedule(){
        departure_date = new Date();
        arrival_date = new Date();
    }

    public Schedule(int schedule_id, Date departure_date, String departure_time, Date arrival_date, String arrival_time) {
        this.schedule_id = schedule_id;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.arrival_date = arrival_date;
        this.arrival_time = arrival_time;
    }



    //getters & setters
    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }


    //toString
    @Override
    public String toString() {
        return "Schedule{" +
                "schedule_id=" + schedule_id +
                ", departure_date=" + departure_date +
                ", departure_time='" + departure_time + '\'' +
                ", arrival_date=" + arrival_date +
                ", arrival_time='" + arrival_time + '\'' +
                '}';
    }
}
