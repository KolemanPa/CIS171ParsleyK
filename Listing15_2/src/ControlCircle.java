
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ControlCircle extends Application {
    //Class lvl Variable
    private CirclePane circlePane = new CirclePane();
    @Override
    public void start(Stage pStage){
//        StackPane pane = new StackPane();
//        Circle circle = new Circle(50);
//        circle.setStroke(Color.BLACK);
//        circle.setFill(Color.YELLOWGREEN);       
//        pane.getChildren().addAll(circle);
        
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        
        hbox.getChildren().addAll(btEnlarge, btShrink);
        
        // Create and register the handler
        btEnlarge.setOnAction(new EnlargeHandler());
        
        btShrink.setOnAction(new ShrinkHandler());
        
        BorderPane bPane = new BorderPane();
        bPane.setCenter(circlePane);
        bPane.setBottom(hbox);
        bPane.setAlignment(hbox, Pos.CENTER);
        
        Scene scene = new Scene(bPane, 300, 300);
        pStage.setTitle("SHOW CIRCLE PLS");
        pStage.setScene(scene);
        pStage.show();
        
    }
    
    // This class handles events for the enlarge button
    // it is an inner class
    class EnlargeHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e) {
            circlePane.enlarge();
    }
    } // End Enlarge Handler
    
    class ShrinkHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            circlePane.shrink();
        }
    }
    
    /**
     * 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}   // end of class

class CirclePane extends StackPane {
    private Circle circle = new Circle(50);
    
    //COnstructor for the class
    public CirclePane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.YELLOWGREEN);
    }
    public void enlarge(){
        circle.setRadius(circle.getRadius()+5);
}
    public void shrink() {  // ? means if this is true, : means else
        circle.setRadius(circle.getRadius() > 50 ? circle.getRadius() -5 : circle.getRadius());
    }
} //end of CirclePane Class