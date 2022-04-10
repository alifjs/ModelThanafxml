/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_thana;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author fnfbi
 */
public class LoginPageController implements Initializable {

    @FXML
    private AnchorPane LoginPageAnchorPane;
    @FXML
    private Button createAnAccountButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<String> comboBox;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboBox.setItems(FXCollections.observableArrayList("Officer in Charge","Inspector","Constable","Civilian"));
    }    

    @FXML
    private void createAnAccountButtonOnClick(MouseEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("SignupPage.fxml"));
        LoginPageAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loginButtonOnClick(MouseEvent event) {
        File f=null;
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        //System.out.println("Hello");
        
        try {
            f = new File("accounts.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            try {
                while(true){
                   LoginCredentials obj=(LoginCredentials)ois.readObject();
                   if(obj.getUsername().equals(username.getText()) && obj.getPassword().equals(password.getText()) && obj.getDesignation().equals(comboBox.getValue())){
                        //System.out.println(obj.getUsername());
                        Model_Thana.setLogged_in_username(username.getText());
                        if(obj.getDesignation().equals("Civilian")){
                            AnchorPane pane= FXMLLoader.load(getClass().getResource("Civilian_home.fxml"));
                            LoginPageAnchorPane.getChildren().setAll(pane);
                            break;
                        }else if(obj.getDesignation().equals("Officer in Charge")){
                            //Model_Thana.setLogged_in_user((Civilian)Model_Thana.search_and_return_user_obj_from_file(username.getText(),"OC_users.bin"));
                            AnchorPane pane= FXMLLoader.load(getClass().getResource("OC_home.fxml"));
                            LoginPageAnchorPane.getChildren().setAll(pane);
                            break;
                        }
                   }
                }
            } catch (Exception e) {
                //Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) {
                Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
