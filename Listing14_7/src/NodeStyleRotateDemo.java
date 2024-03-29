<<<<<<< HEAD
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class NodeStyleRotateDemo extends Application{
    public void start(Stage primaryStage){
        StackPane pane = new StackPane();
        Button btOK = new Button("Ok");
        btOK.setStyle("-fx-border-color: blue;");
        pane.getChildren().add(btOK);
        
        pane.setRotate(45);
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
        
        Scene scene = new Scene(pane, 200,200);
        btOK.setStyle("-fx-border-color: red;");
        primaryStage.setTitle("Node Style Rotate Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
=======
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class NodeStyleRotateDemo extends Application{
    public void start(Stage primaryStage){
        StackPane pane = new StackPane();
        Button btOK = new Button("Ok");
        btOK.setStyle("-fx-border-color: blue;");
        pane.getChildren().add(btOK);
        
        pane.setRotate(45);
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
        
        Scene scene = new Scene(pane, 200,200);
        btOK.setStyle("-fx-border-color: red;");
        primaryStage.setTitle("Node Style Rotate Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
>>>>>>> 85f77407adb09ad1ef28be580281812626a28f79
