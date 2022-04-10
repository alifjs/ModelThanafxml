/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_thana;

import java.io.Serializable;

/**
 *
 * @author fnfbi
 */
public class LoginCredentials implements Serializable{
    private final String username;
    private final String password;
    private final String designation;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDesignation() {
        return designation;
    }
    
    public LoginCredentials(String a,String b,String c){
        username=a;
        password=b;
        designation=c;
    }
}
