//IMPORTS
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Developer:           Koleman Pa
 * Date:                3/26/2019
 * Program:             Test Collection
 * @author kp0885055
 */
public class TestCollection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> co1 = new ArrayList<>();
        
        co1.add("New York");
        co1.add("Atlanta");
        co1.add("Dallas");
        co1.add("maddison");
        
        co1.forEach(e -> System.out.print(e.toUpperCase() + " "));
        
        
        
        
        
        
//        Iterator<String> iterator = co1.iterator();
//        
//        while (iterator.hasNext()){
//            System.out.println(iterator.next().toUpperCase() + " ");
//            
//        }
//        System.out.println("done");
        
        
        
//        System.out.println("A list of citties in co1: ");
//        System.out.println(co1);
//        
//        System.out.println("\nIs Dalllis in co1?    " +co1.contains("Dallas"));
//        
//        co1.remove("Dallas");
//        System.out.println("\n"+co1.size() + " Cities are in co1 now");
//        
//        
//        
//        // NEW collections
//        Collection<String> co2 = new ArrayList<>();
//        co2.add("Seatle");
//        co2.add("Portland");
//        co2.add("Pheonix");
//        co2.add("Atlanta");
//        System.out.println("\nA List of cities in co2:  ");
//        System.out.println(co2);
//        
//        // CLONE ONE
//        ArrayList<String> clone1 = (ArrayList<String>) co1.clone();
//        System.out.println(clone1);
//        clone1.retainAll(co2);
//        
//        System.out.println("\nSome Stuff"+clone1);
//        
//        clone1 = (ArrayList<String>) co1.clone();
//        clone1.removeAll(co2);
//        System.out.println(clone1);
    }
    
}
