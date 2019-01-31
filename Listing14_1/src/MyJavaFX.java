import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyJavaFX extends Application{
    
            @Override
        public void start(Stage primaryStage){
        Button btOK = new Button("OK");
        
        Scene scene = new Scene(btOK, 200, 250);
        
        primaryStage.setTitle("MyJavaFX");          // title of our window
        primaryStage.setScene(scene);               // Set up our scene
        primaryStage.show();                        // Display the stage
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
