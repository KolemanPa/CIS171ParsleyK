
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author theko
 */
public class PrimeNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int count = 0;
    try(
            DataInputStream dis = 
                    new DataInputStream(new FileInputStream("Exercise17.dat"));
     ){
        int total = 0;
        while(dis.available()>0){
            int temp = dis.readInt();
            total += temp;
            count++;
            System.out.print(temp+" ");
        }
        System.out.println("\nCount is "+count);
        System.out.println("\nTotal is "+total);
    }
    catch(FileNotFoundException ex){
            System.out.println("File Not Found");
    }
    catch(IOException ex){
        System.out.println(ex.getMessage());
    }
    
    
}
}