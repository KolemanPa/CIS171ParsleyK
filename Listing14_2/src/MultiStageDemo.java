import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MultiStageDemo extends Application{
    @Override
    public void start(Stage primaryStage) {
        // Create a scene and place a button in the class
        Scene scene = new Scene(new Button("OK"), 200, 250);
        primaryStage.setTitle("MyJavaFx");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Stage stage = new Stage();
        stage.setTitle("Second Stage");
        // set a scene witha button in the stage
        stage.setScene (new Scene(new Button("newStage"), 250, 200));
        stage.show();
    }

    public static void main(String[] args) {
       launch(args);
    }
    
}
