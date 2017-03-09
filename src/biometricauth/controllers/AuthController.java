package biometricauth.controllers;

import biometricauth.models.HandGeometry;
import biometricauth.models.User;
import java.util.ArrayList;

/**
 *
 * @author Max
 */
public class AuthController {
    public static double getHandGeometryMatchScore(HandGeometry typed, HandGeometry stored){
        double deviation = 0;
        
        deviation += Math.abs(Double.parseDouble(typed.getIndexFingerHeight()) - Double.parseDouble(stored.getIndexFingerHeight()));
        deviation += Math.abs(Double.parseDouble(typed.getMiddleFingerHeight()) - Double.parseDouble(stored.getMiddleFingerHeight()));
        deviation += Math.abs(Double.parseDouble(typed.getRingFingerHeight()) - Double.parseDouble(stored.getRingFingerHeight()));
        deviation += Math.abs(Double.parseDouble(typed.getPinkyHeight()) - Double.parseDouble(stored.getPinkyHeight()));
        deviation += Math.abs(Double.parseDouble(typed.getPalmAcrossLength()) - Double.parseDouble(stored.getPalmAcrossLength()));
        deviation += Math.abs(Double.parseDouble(typed.getPalmHeight()) - Double.parseDouble(stored.getPalmHeight()));
        
        return deviation;
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
                break;
            }
        }
        
        return usernameExists;
    }
}
