/**
 * Developer:       Koleman Pa
 * Date:            3/21/2019
 * Program:         CompareTo Method
 * 
 */
public class Max {
    
    // USES Raw type
    // Public = access mode
    // static = only one instance
    // Comparable = return type is a comparable object
    // max = method name
    // (Comparable o1, Comparable o2) = two objects to compare
        public static Comparable max(Comparable o1, Comparable o2){
            if (o1.compareTo(o2) > 0)
                return o1;
            else
                return o2;
        }
        
        public static <E extends Comparable<E>> E maxE(E o1, E o2){
                        if (o1.compareTo(o2) > 0)
                return o1;
            else
                return o2;
        }
        
    public static void main(String[] args) {
        Max.maxE("welcome", 43);
    }
    
}
