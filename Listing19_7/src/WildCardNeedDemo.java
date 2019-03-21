/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kp0885055
 */
public class WildCardNeedDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);           //autoboxed into integer(1)
        intStack.push(2);           //Autobox
        intStack.push(-2);
        System.out.println("The max number is "+max(intStack));
        
    }
    
    public static double max(GenericStack<? extends Number> stack) {
        double max = stack.pop().doubleValue();
        
        while (!stack.isEmpty()){
            double value= stack.pop().doubleValue();
            if (value > max)
                max = value;
            // end of While
        }
        return max;
    }
    
}
