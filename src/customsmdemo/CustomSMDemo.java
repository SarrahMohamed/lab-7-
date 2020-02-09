/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customsmdemo;

import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.security.AccessControlContext;
import java.security.AccessController;

/**
 *
 * @author sara
 */
public class CustomSMDemo extends SecurityManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AccessControlContext con = AccessController.getContext();
        File file = new File("pol.policy"); 
        System.setProperty("java.security.policy", "file:/" + file.getAbsolutePath());
        CustomSMDemo sm = new CustomSMDemo(); 
        System.setSecurityManager(sm);
        sm.checkPermission(new FilePermission("Data.txt", "write"), con); 
        System.out.println("Allowed!");  
    }
    
}
