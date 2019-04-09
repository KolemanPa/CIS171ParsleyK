/**
 * Developer:       Koleman Pa
 * Date:            4/9/2019
 * Program:         IDK
 */


//IMPORTS
import static java.util.Collections.list;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author kp0885055
 */
public class Exercise24_7 {
    private LinkedList<Integer> list = new LinkedList<>();
    private LinkedListView view = new LinkedList<>();
    private Button btSearch = new Button("Search");
    private Button btInsert = new Button("Insert");
    private Button btDelete = new Button("Delete");
    private TextField tfNum = new TextField();
    private TextField tfIndex = new TextField();
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    





class LinkedListView extends Pane {
    private int startingX = 20;
    private int startingY = 20;
    private int boxWidth = 50;
    private int boxHeight = 30;
    private int arrowLineLength = 30;
    private int hGap = 80;
    
    protected void repaint(){
        getChildren().clear();
        
        if (list.size() == 0){
            getChildren().add(new Text(startingX, startingY, "head: null"));
            getChildren().add(new Text(startingX, startingY+15, "tail: null"));
        } // end of if
        else {
            getChildren().add(new Text(startingX, startingY, "head"));
            int x = startingX +30;
            int y = startingY +30;
            drawArrowLine(startingX +5, startingY,x,y);
            
            for (int i = 0; i <list.size(); i++){
                Rectangle rectangle = new Rectangle (x,y,boxWidth, boxHeight);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                getChildren().add(rectangle);
                getChildren().add(new Line(x+arrowLineLength, y, x+arrowLineLength, y+boxHeight));
                
                if (i < list.size() -1){
                    drawArrowLine(x+40,y+boxHeight/2, x+hGap, y+boxHeight/2);
                }
                getChildren().add(new Text(x+10,y+15,list.get(i)+""));
                x=x+hGap;
            }   // end of FOR
            getChildren().add(new Text(x, startingY,"tail"));
            drawArrowLine(x,startingY,x-hGap,y);
        }
    }
    public void drawArrowLine(double x1, double y1, double x2, double y2){
        getChildren().add(new Line(x1,y1,x2,y2));
        
        
        // FIND SLOPE OF LINE
        double slope = ((((double) y1) - (double) y2))/ (((double)x1)-(((double)x2)));
        // slope = (y1-y2)/(x1-x2)
        
        double arctan = Math.atan(slope);
        
        
        // FLIP THE ARROW 45 off of a
        // perpendicular line at pt x2
        double set45 = 1.57 /2;
        
        // arrows should allways point to i, not i+1
        if (x1<x2){
            set45 = -1.57 *1.5;
        }
        
        int arrLen = 15;
        // draw arrows on line
        getChildren().add(new Line(x2,y2,(x2+(Math.cos(arctan + set45) * arrLen)),((y2)) + (Math.sin(arctan+set45)*arrLen)));

        getChildren().add(new Line(x2,y2,(x2+(Math.cos(arctan - set45) * arrLen)),((y2)) + (Math.sin(arctan - set45)*arrLen)));
    }
}
}
