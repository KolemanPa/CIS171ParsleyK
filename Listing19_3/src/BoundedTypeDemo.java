/**
 * Developer:       Koleman Pa
 * Program:         Using bounded type
 * Date:            3/21/2019
 */
public class BoundedTypeDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // This ones 
        Rectangle rectangle = new Rectangle(2,2);
        Circle circle = new Circle(2);
        
        
        
        // this ones true
        Rectangle rectangle1 = new Rectangle(2,2);
        Rectangle rectangle2 = new Rectangle(4,1);
        
        System.out.println("Same Area? " + equalArea(rectangle, circle));
    
        System.out.println("Same Area? " + equalArea(rectangle2, rectangle1));
    }
    
    
    
    // Public = Access Mode
    // Static = only one instance
    // <E extends GeometricObject> = E is a bounded type generic it will be some sort of Geometric Object
    // Boolean = return Type
    // equalArea is method name
    // (E object1, E object2) = two object - each will be of geometricObject type
    public static <E extends GeometricObject> boolean equalArea(E object1, E object2){
        return object1.getArea() == object2.getArea();
    }
    
}
