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
public class OC_homeController implements Initializable {

    @FXML
    private AnchorPane OcHomeAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showAllFIRsButtonOnClick(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("FIRs_display_page.fxml"));
        OcHomeAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void logOutButtonOnclick(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        OcHomeAnchorPane.getChildren().setAll(pane);
    }
    
}
