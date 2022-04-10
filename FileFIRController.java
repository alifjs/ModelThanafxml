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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author fnfbi
 */
public class FileFIRController implements Initializable {

    @FXML
    private TextField nameOfVictim;
    @FXML
    private TextField addressOfVictim;
    @FXML
    private TextField nameOfPerpetrator;
    @FXML
    private TextField description;
    @FXML
    private AnchorPane FileFIRAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SubmitButtonOnClick(MouseEvent event) throws IOException {
        FIR obj=new FIR(nameOfVictim.getText(),addressOfVictim.getText(),nameOfPerpetrator.getText(),description.getText());
        //System.out.println(Model_Thana.getLogged_in_username());
        Civilian civilian_user=Civilian.search_and_return_civilian_user_obj_from_file(Model_Thana.getLogged_in_username());
        //System.out.println(civilian_user.getUsername());
        civilian_user.file_FIR(obj);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Civilian_home.fxml"));
        FileFIRAnchorPane.getChildren().setAll(pane);        
    }
    
}
