import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FontDemo extends Application{
    public void start(Stage primaryStage){
        Pane pane = new StackPane();
        
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setStroke(Color.BURLYWOOD);
        circle.setFill(new Color(0.5,0.5,0.5,0.1));
//        pane.getChildren().add(circle);
        
        // Create a label
        Label label = new Label("JavaFx");
        label.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC,20));
        pane.getChildren().addAll(label, circle);
        
        
        
        Scene scene = new Scene(pane);
        
        primaryStage.setTitle("Font Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 public static void main(String[] args) {
        launch(args);
    }
    
}
