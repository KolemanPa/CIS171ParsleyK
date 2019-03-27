
import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Developer:           Koleman Pa
 * Date:                3/22/19
 * Problem:             Create a shuffle array
 */
public class ShuffleHw<E> {

    /**
     * @param args the command line arguments
     */

    
    public static <E> void shuffle(ArrayList<E> list){
        
        Random rando = new Random();
        
        for(int i = 0; i< list.size();i++){
            int j = rando.nextInt(i+1);
            
            E obj = list.get(i);
            list.set(i, list.get(j));
            list.set(j, obj);
        }
    }
    
    
        public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList(Arrays.asList(1,2,3,4,5,6,23,14,15,75,432,63,13,8));
        
        shuffle(list);
        
        System.out.println(list);
    }
}
