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
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fnfbi
 */
public class Civilian extends User implements Serializable{

    public Civilian(String username, String password) {
        super(username, password);
    }
    
    public static Civilian search_and_return_civilian_user_obj_from_file(String username){
        File f=null;
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        //System.out.println("Hello");
        Civilian obj=null;
        try {
            f = new File("Civilian_users.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            try {
                while(true){
//                   System.out.println("RHYTTTTTHHHHM");
                   obj=(Civilian)ois.readObject();
//                   System.out.println(ois.readObject());
//                   System.out.println("RHYTTTTTHHHHM222222222");
                   if(obj.getUsername().equals(username)){
                       //System.out.println("The obj.getUsername().equals(username) line has been printed");
                       break;
                   }
                }
            } catch (Exception ex) {
                Logger.getLogger(Civilian.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
           Logger.getLogger(Civilian.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) {
                Logger.getLogger(Model_Thana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return obj;
    }
    public void file_FIR(FIR obj) throws IOException{
        File f=null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        //
        //System.out.println(this.username);
        try {
            f=new File("FIRs.bin");
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
            Logger.getLogger(FileFIRController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(oos != null) oos.close();
        }
    }
            
}
//////////
