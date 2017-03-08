package biometricauth.controllers;

import biometricauth.db.MySQLConnection;
import biometricauth.models.HandGeometry;
import biometricauth.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserController {
    private static Connection connection = MySQLConnection.getConnection();

    public static void addUser(String username, String password, HandGeometry hg){
        String query = "insert into users (username, password) values (?, ?)";
        String query_hg = "insert into hand_geometry "
                + "(index_finger_height, middle_finger_height, ring_finger_height,"
                + " pinky_height, palm_across_length, palm_height) "
                + "values (?, ?, ?, ?, ?, ?)";
 
        try {
            PreparedStatement ps1 = connection.prepareStatement(query);
            ps1.setString(1, username);
            ps1.setString(2, password);
            
            PreparedStatement ps2 = connection.prepareStatement(query_hg);
            ps2.setString(1, hg.getIndexFingerHeight());
            ps2.setString(2, hg.getMiddleFingerHeight());
            ps2.setString(3, hg.getRingFingerHeight());
            ps2.setString(4, hg.getPinkyHeight());
            ps2.setString(5, hg.getPalmAcrossLength());
            ps2.setString(6, hg.getPalmHeight());
            
            ps1.executeQuery();
            ps2.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
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
        String handGeometryQuery = "select * from hand_geometry";
        User user = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int uid = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                user = new User(Integer.toString(uid), username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(handGeometryQuery);
            
            while(rs.next()){
                String indexFingerHeight = rs.getString("index_finger_height");
                String middleFingerHeight = rs.getString("middle_finger_height");
                String ringFingerHeight = rs.getString("ring_finger_height");
                String pinkyHeight = rs.getString("pinky_height");
                String palmAcrossLength = rs.getString("palm_across_lenght");
                String palmHeight = rs.getString("palm_height");
                
                HandGeometry hg = new HandGeometry();
                hg.setIndexFingerHeight(indexFingerHeight);
                hg.setMiddleFingerHeight(middleFingerHeight);
                hg.setRingFingerHeight(ringFingerHeight);
                hg.setPinkyHeight(pinkyHeight);
                hg.setPalmAcrossLength(palmAcrossLength);
                hg.setPalmHeight(palmHeight);
                
                if(user != null){
                    user.setHandGeometry(hg);
                }
                
            }
        } catch (Exception e) {
        }
        return users;
    }
}

