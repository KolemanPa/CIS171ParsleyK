
//IMPORTS
import java.util.Random;

/**
 * Developer:       KolemanPa
 * Date:            4/4/2019
 * Program:         creates array
 * @author kp0885055
 */
public class SortMaint {
    static Random rand = new Random();
        public static int[] randomArray(int size){
            Random rand = new Random();
            int[] theArray = new int[size];
            for(int i = 0; i < size;i++){
                theArray[i] = rand.nextInt(100);        // Rando nums from 1-99
                
            }       // end for loop
            
            return theArray;
        }
        
        public static void printArray(int[] theArray){
            System.out.println("------BEGINNING ARRAY PRINT------");
            for (int i = 0; i < theArray.length; i++) {
                System.out.print(theArray[i]+" ");
            }   // end for loop
            System.out.println("\n-----END ARRAY PRINT--------");
        }
}
