import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PathTransitionDemo extends Application{
    StackPane pane = new StackPane();
    Circle circle = new Circle(125,100,50);
    Rectangle rectangle = new Rectangle(0,0,25,50);    
    
    @Override
    public void start(Stage primaryStage){

        
        // Create a rectangle

        rectangle.setFill(Color.GREENYELLOW);
        
        //create a circle

        circle.setFill(Color.ALICEBLUE);
        circle.setStroke(Color.BLACK);
        
        pane.getChildren().addAll(rectangle, circle);
        
        Scene scene = new Scene(pane, 140,140);
        primaryStage.setTitle("ResizableCircleRectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.widthProperty().addListener(ov -> resize());
        pane.heightProperty().addListener(ov -> resize());
        
        
        
    }
        private void resize() {
            double length = Math.min(pane.getWidth(), pane.getHeight());
            circle.setRadius(length /2-15);
            rectangle.setWidth(length - 30);
            rectangle.setHeight(length - 30);
        }
    public static void main(String[] args) {
        launch(args);
    }
    
}

