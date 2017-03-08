/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricauth;

import biometricauth.controllers.UserController;
import biometricauth.models.User;
import java.util.ArrayList;

/**
 *
 * @author Max
 */
public class Main {

   public static void main(String[] args) {
        UserController.addUser("selena", "hero");
        ArrayList<User> users = UserController.getAllUsers();
        for(User user: users){
            System.out.println(user);
        }

//        UserSignUpForm signUpForm = new UserSignUpForm();
//        signUpForm.setVisible(true);
    }
    
}
