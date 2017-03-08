package biometricauth.controllers;



import biometricauth.db.MySQLConnection;
import biometricauth.models.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserController {
    private static Connection connection = MySQLConnection.getConnection();

    public static void addUser(String username, String password){
        String query = "insert into users (username, password) values ('" + username + "', '" + password + "')";
    }

    public static void addUser(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        String query = "insert into users (username, password) values ('" + username + "', '" + password + "')";

    }

    public static void removeUser(int uid){
        String query = "";
    }

    public static ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        String query = "select * from users";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int uid = rs.getInt("uid");
                String username = rs.getString("username");
                String password = rs.getString("password");

                User user = new User(Integer.toString(uid), username, password);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

