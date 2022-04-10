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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author fnfbi
 */
public class FIRs_display_pageController implements Initializable {

    @FXML
    private AnchorPane FIRsDisplayPageAnchorPane;
    @FXML
    public TextArea textAreaOfFIRs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File f=null;
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        
        try {
            f = new File("FIRs.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            //FIR obj;
            try {
                int counter=1;
                while(true){
                   //System.out.println("Hello");
                   FIR obj=(FIR)ois.readObject();
                   //System.out.println("hello");
                   String individual_FIR_display_text=
                           "FIR "+counter+"\n"+"Name of victim :"+obj.getName_of_victim()
                            +"\nAddress of victim :"+ obj.getAddress_of_victim()
                           +"\nName of perpetrator : " + obj.getName_of_perpetrator()
                           +"\nDescription of incident : "+ obj.getDescription()
                           +"\n_______________________________________________\n";
                   //System.out.println("Hello");
                   //System.out.println(individual_FIR_display_text);
                   textAreaOfFIRs.appendText(individual_FIR_display_text);
                   //obj.appendThisTextToTextArea(textAreaOfFIRs,"Allahu Akbar");
                   counter++;
                }
            } catch (Exception e) {
                //Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(FIRs_display_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) {
                Logger.getLogger(FIRs_display_pageController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }    

    @FXML
    private void goBackToHomePageOnClick(MouseEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("OC_home.fxml"));
        FIRsDisplayPageAnchorPane.getChildren().setAll(pane);
    }
    
}
