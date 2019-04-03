/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcandelete;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author theko
 */
public class YouCanDelete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        try(
                DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17.dat",true));
                ) {
            for (int i=0;i<100;i++){
                output.writeInt((int)(Math.random()*10000));
            }
        }
        System.out.println("DONE");
    }
    
}
