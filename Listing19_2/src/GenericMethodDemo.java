/**
 * Developer:       Koleman Pa
 * Program:         Using Generic Methods
 * Date:            3/21/2019
 */

public class GenericMethodDemo {

    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,5,6,7,8,9,10};
        String[] strings = {"London", "Paris", "Springfield", "Boston", "Austin", "Ozark"};
        
        // Compiler is determining data type
        print(integers);
        print(strings);
        
        // We are supplying data type
        GenericMethodDemo.<Integer>print(integers);
        GenericMethodDemo.<String>print(strings);
    }
    
    // Public = access node
    // static = unique - only one can be loaded in memory
    // <E> = Generic Specifier
    // Void = return type (no return)
    // Print = method name
    // E[] = Generic array
    // list = name of parameter array
    public static <E> void print(E[] list) {
        for (int i = 0; i <list.length; i++){
            System.out.println(list[i] + "\n");
        }
        System.out.println("-----------------------");
    }
    
}
