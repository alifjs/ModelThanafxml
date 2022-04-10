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
public class Officer_in_charge extends User implements Serializable{
    private String username;
    private String password;

    public Officer_in_charge(String username, String password) {
        super(username, password);
    }   
}
