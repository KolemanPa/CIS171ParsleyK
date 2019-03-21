
import java.util.ArrayList;

/**
 * Date:        3/19/2019
 * Developer:   Koleman Pa
 * Purpose:     Develeping Generic Stack
 * 
 * @author kp0885055
 */
public class GenericStack<E> {
    // USE full path to arraylist class, instead of import
    // ADD generic specification to the class " <E> " data type and the constructor
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
    
    public int getSize() {
        return list.size();
    }
    // E is the genereic data type as our return type
    public E peek() {
        return list.get(getSize() -1);
    }
    // E is the generic Data type as a parameter type
    public void push(E o) {
        list.add(o);
    }
    public E pop() {
        E o = list.get(getSize() -1);
        list.remove(getSize() -1);
        return o;
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    @Override 
    public String toString(){
        return "stack: " + list.toString();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>();
        stack1.push("london");
        stack1.push("Paris");
        stack1.push("Berlin");
        System.out.println(stack1);
        stack1.pop();
        System.out.println(stack1);
        
        
        GenericStack<Integer> stack2 = new GenericStack<>();
        stack2.push(3);                 // autoboxing 1 to new integer
        stack2.push(4);
        stack2.push(2);
        System.out.println(stack2);
        System.out.println(stack2.peek());
        
        ArrayList arlist = new ArrayList();
        arlist.add(1);
        arlist.add("sanFran");
        System.out.println(arlist);
    }
    
}
