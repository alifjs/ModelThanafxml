/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_thana;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author fnfbi
 */
public class Civilian_homeController implements Initializable {

    @FXML
    private AnchorPane CivilianHomeAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fileAnFIRButtonOnClick(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("FileFIR.fxml"));
        CivilianHomeAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void logOutButtonOnClick(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        CivilianHomeAnchorPane.getChildren().setAll(pane);
    }
    
}
