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

    private static final Connection connection = MySQLConnection.getConnection();
    
    public static int getLastInsertId(){
        String query = "select max(id) from users";
        try {
            Statement st = connection.createStatement();
            System.out.println("Test 1");
            ResultSet rs = st.executeQuery(query);
            System.out.println("Test 2");
            int id = 0;
            while(rs.next()){
                id = rs.getInt("max(id)");
                if(id == 0){
                    id = 1;
                }
            }
            System.out.println("Test 3");
            System.out.println("Returing max(id): " + id);
            return id;
            
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static void addUser(String username, String password, HandGeometry hg) {
        String query = "insert into users (username, password) values (?, ?)";
        
        String query_hg = "insert into hand_geometry "
                + "(index_finger_height, middle_finger_height, ring_finger_height,"
                + " pinky_height, palm_across_length, palm_height, user_id) "
                + "values (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps1 = connection.prepareStatement(query);
            ps1.setString(1, username);
            ps1.setString(2, password);
            
            ps1.executeUpdate();
            
            PreparedStatement ps2 = connection.prepareStatement(query_hg);
            ps2.setString(1, hg.getIndexFingerHeight());
            ps2.setString(2, hg.getMiddleFingerHeight());
            ps2.setString(3, hg.getRingFingerHeight());
            ps2.setString(4, hg.getPinkyHeight());
            ps2.setString(5, hg.getPalmAcrossLength());
            ps2.setString(6, hg.getPalmHeight());
            
            ps2.setString(7, Integer.toString(getLastInsertId()));

            
            ps2.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static HandGeometry getHandGeometryOfUser(String username) {
        String query = "select * from hand_geometry where user_id = (select id from users where username = ?)";
        HandGeometry hg = new HandGeometry();
        try {
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                hg.setIndexFingerHeight(rs.getString("index_finger_height"));
                hg.setMiddleFingerHeight(rs.getString("middle_finger_height"));
                hg.setRingFingerHeight(rs.getString("ring_finger_height"));
                hg.setPinkyHeight(rs.getString("pinky_height"));
                hg.setPalmAcrossLength(rs.getString("palm_across_length"));
                hg.setPalmHeight(rs.getString("palm_height"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return hg;   
    }
    // end of getHandGeometryOfUser()

    public static String getPasswordOfUser(String username) {
        String query = "select password from users where username = ?";
        String password = null;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                password = rs.getString("password");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return password;
    }
    // end of getPasswordOfUser()

    public static ArrayList<String> getAllUsernames() {
        ArrayList<String> usernames = new ArrayList<>();
        String query = "select username from users";
        Statement st;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String currentUsername = rs.getString("username");
                usernames.add(currentUsername);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return usernames;
    }
    // end of getAllUsernames()

    public static void removeUser(int uid) {
        String query = "";
    }

    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String query = "select * from users";
        String handGeometryQuery = "select * from hand_geometry";
        User user = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
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

            while (rs.next()) {
                String indexFingerHeight = rs.getString("index_finger_height");
                String middleFingerHeight = rs.getString("middle_finger_height");
                String ringFingerHeight = rs.getString("ring_finger_height");
                String pinkyHeight = rs.getString("pinky_height");
                String palmAcrossLength = rs.getString("palm_across_length");
                String palmHeight = rs.getString("palm_height");

                HandGeometry hg = new HandGeometry();
                hg.setIndexFingerHeight(indexFingerHeight);
                hg.setMiddleFingerHeight(middleFingerHeight);
                hg.setRingFingerHeight(ringFingerHeight);
                hg.setPinkyHeight(pinkyHeight);
                hg.setPalmAcrossLength(palmAcrossLength);
                hg.setPalmHeight(palmHeight);

                if (user != null) {
                    user.setHandGeometry(hg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    } 
    // end of getAllUsers()
}
