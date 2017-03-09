package biometricauth.controllers;

import biometricauth.models.HandGeometry;
import biometricauth.models.User;
import java.util.ArrayList;

/**
 *
 * @author Max
 */
public class AuthController {
    public static void matchHandGeometry(HandGeometry hg1, HandGeometry hg2){
        int score = 0;
        
        //
        
    }
    
   
    
    public static boolean matchUsernamePassword(String username, String enteredPassword){
        String realPassword = UserController.getPasswordOfUser(username);
        boolean passwordMatches = false;
        
        if(enteredPassword.equals(realPassword)){
            passwordMatches = true;
        }
        
        return passwordMatches;
    }
    
    public static boolean usernameExists(String username){
        ArrayList<String> usernames = UserController.getAllUsernames();
        boolean usernameExists = false;
        for(String currentUsername: usernames){
            if(currentUsername.equals(username)){
                usernameExists = true;
            }
        }
        
        return usernameExists;
    }
}
