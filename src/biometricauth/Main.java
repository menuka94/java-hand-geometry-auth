/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricauth;

import biometricauth.controllers.UserController;
import biometricauth.guis.StartForm;
import biometricauth.models.User;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Max
 */
public class Main {

   public static void main(String[] args) {
        ArrayList<User> users = UserController.getAllUsers();
        for(User user: users){
            System.out.println(user);
        }
        
        ArrayList<String> usernames = UserController.getAllUsernames();
        for(String username: usernames){
            System.out.println(username);
        }
        
        StartForm sf = new StartForm();
        sf.setVisible(true);
//        sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
