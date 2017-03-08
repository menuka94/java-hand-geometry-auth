package biometricauth.db;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Max
 */
public class MySQLConnection {
    private static Connection connection;
    private static void setupConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String conString = "jdbc:mysql://" + Constants.DB_HOST + ":" + Constants.DB_PORT + "/" + Constants.DB_NAME;
            System.out.println("Connection Stirng: " + conString);
            connection = (Connection) DriverManager.getConnection(conString, Constants.DB_USERNAME, Constants.DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if(connection == null){
            setupConnection();
        }
        return connection;
    }
}
