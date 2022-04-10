/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_thana;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author fnfbi
 */
public class SignupPageController implements Initializable {

    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button signupButton;
    @FXML
    private AnchorPane signupPageAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboBox.setItems(FXCollections.observableArrayList("Officer in Charge","Inspector","Constable","Civilian"));
    }    

    @FXML
    private void signupButtonOnClick(MouseEvent event) throws IOException{//write the user object in accounts.bin and civilian_users.bin
        LoginCredentials obj=new LoginCredentials(username.getText(),password.getText(),comboBox.getValue());
        //User obj2=null;
        //String filename="";
        File f=null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        if(comboBox.getValue().equals("Officer in Charge")){
//            obj2=new Officer_in_charge(username.getText(),password.getText());
//            filename="OC_users.bin";
        }else if(comboBox.getValue().equals("Inspector")){
//            obj2=new Civilian(username.getText(),password.getText());
//            filename="Civilian_users.bin";
        }else if(comboBox.getValue().equals("Constable")){
//            obj2=new Civilian(username.getText(),password.getText());
//            filename="Civilian_users.bin";
        }else if(comboBox.getValue().equals("Civilian")){
            Civilian obj2=new Civilian(username.getText(),password.getText());
            try {
                f=new File("Civilian_users.bin");
                if(f.exists()){
                    fos = new FileOutputStream(f,true);
                    oos = new AppendableObjectOutputStream(fos);                
                }
                else{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);               
                }
                oos.writeObject(obj2);
            }catch (FileNotFoundException ex) {
                Logger.getLogger(SignupPageController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if(oos != null) oos.close();
            }
               
        }
        //write this object to the accounts.bin file
        
        try {
            f=new File("accounts.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(obj);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SignupPageController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(oos != null) oos.close();
        }
        //we write the civilian user in the "civilian_users.bin" file
        //end of writing in files
        AnchorPane pane=FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        signupPageAnchorPane.getChildren().setAll(pane);
    }
    
}
