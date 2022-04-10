/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_thana;

import java.io.Serializable;
import javafx.scene.control.TextArea;
/**
 *
 * @author fnfbi
 */
public class FIR implements Serializable{
    /*Name of victim,address of victim,mobile no. of victim,
NID no. of victim,picture of NID,date of incident,time of incident,
location of incident,name of perpetrator,description of incident.*/
    private String name_of_victim;
    private String address_of_victim;
    private String name_of_perpetrator;
    private String description;

    public FIR(String name_of_victim, String address_of_victim, String name_of_perpetrator, String description) {
        this.name_of_victim = name_of_victim;
        this.address_of_victim = address_of_victim;
        this.name_of_perpetrator = name_of_perpetrator;
        this.description = description;
    }

    public String getName_of_victim() {
        return name_of_victim;
    }

    public String getAddress_of_victim() {
        return address_of_victim;
    }

    public String getName_of_perpetrator() {
        return name_of_perpetrator;
    }

    public String getDescription() {
        return description;
    }
    /*
    public void appendThisTextToTextArea(TextArea t,String text){
        t.appendText(text);
    }*/
    
}
