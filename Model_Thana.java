 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_thana;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author fnfbi
 */
public class Model_Thana extends Application {
    private static String logged_in_username;

    public static String getLogged_in_username() {
        return logged_in_username;
    }

    public static void setLogged_in_username(String logged_in_username) {
        Model_Thana.logged_in_username = logged_in_username;
    }
    /*experiment
    
    
    */
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
//        //experiment2
//        File f2=null;
//        FileOutputStream fos=null;
//        ObjectOutputStream oos=null;
//        Civilian obj2=new Civilian("Alif","1");
//        //System.out.println(obj2.getPassword());
//        try {
//            f2=new File("Civilian_users.bin");
//            if(f2.exists()){
//                fos = new FileOutputStream(f2,true);
//                oos = new AppendableObjectOutputStream(fos);                
//            }
//            else{
//                fos = new FileOutputStream(f2);
//                oos = new ObjectOutputStream(fos);               
//            }
//            oos.writeObject(obj2);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(SignupPageController.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            if(oos != null) oos.close();
//        }
//        //
//        //experiment
//        File f=null;
//        FileInputStream fis=null;
//        ObjectInputStream ois=null;
//        Civilian obj=null;
//        //System.out.println("Hello");
//        try {
//            f = new File("Civilian_users.bin");
//            fis = new FileInputStream(f);
//            ois = new ObjectInputStream(fis);
//            try {
//                while(true){
//                   System.out.println("RHYTTTTTHHHHM");
//                   obj=(Civilian)ois.readObject();
//                   System.out.println("Object :");
//                   //System.out.println(obj.getPassword());
//                   /*if(obj.getUsername().equals(username)){
//                       //System.out.println("The obj.getUsername().equals(username) line has been printed");
//                       break;
//                   }*/
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(Civilian.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (IOException ex) {
//           Logger.getLogger(Civilian.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            try {
//                if(ois != null) ois.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Model_Thana.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        //end of experiment
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
