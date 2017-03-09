/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometricauth;

import biometricauth.controllers.UserController;
import biometricauth.guis.StartForm;
import biometricauth.models.HandGeometry;
import biometricauth.models.User;
import java.util.ArrayList;

/**
 *
 * @author Max
 */
public class Main {

    public static void main(String[] args) {
        HandGeometry hg = UserController.getHandGeometryOfUser("harry");
        System.out.println(hg);

        StartForm sf = new StartForm();
        sf.setVisible(true);
        
        System.out.println(hg);
    }

}
