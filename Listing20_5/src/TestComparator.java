
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class TestComparator {
        public static void main(String[] args){
            GeometricObject g1 = new Rectangle(5,5);
            GeometricObject g2 = new Circle(5);
            
            GeometricObject g = max(g1, g2, new GeometricObjectComparator());
            System.out.println("The area of the larger object is "+ g.getArea());
            
            
        }
        
        public static GeometricObject max(GeometricObject g1, GeometricObject g2, Comparator<GeometricObject> c){
            if (c.compare(g1, g2) >= 0)
                return g1;
            else
                return g2;
        }
}
