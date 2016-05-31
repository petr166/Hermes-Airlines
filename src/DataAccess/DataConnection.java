package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Petru on 19-May-16.
 */

public class DataConnection {

    //fields
    private static Connection connection;
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hermes_airline?autoReconnect=true&useSSL=false";
    private static String userName = UserPass.getUserName();
    private static String password = UserPass.getPassword();


    //method to connect to the database
    public static void connect() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, userName, password);

            System.out.println("database connection success");
        }

        catch (Exception e) {
            e.printStackTrace();

            System.out.println("problem with database connection");
        }
    }


    //getters
    public static Connection getConnection() {
        return connection;
    }

}
