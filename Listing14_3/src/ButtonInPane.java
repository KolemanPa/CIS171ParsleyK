import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class ButtonInPane extends Application{
    public void start(Stage primaryStage){
        // Create a scene
//        StackPane pane = new StackPane();
//        FlowPane pane = new FlowPane();
        GridPane pane = new GridPane();
        pane.getChildren().add(new Button("OK"));
        pane.getChildren().add(new Button("Another"));
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setTitle("Button In a pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
