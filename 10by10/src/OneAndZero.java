
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author theko
 */
public class OneAndZero extends Application{




        @Override
        public void start(Stage primaryStage) {

            int size = 10;
            int length = size;
            int width = size;

            GridPane pane = new GridPane();    

            for(int y = 0; y < length; y++){
                for(int x = 0; x < width; x++){

                    Random random = new Random();
                    int rando1 = random.nextInt(2);

                    
                    
                    
                    // Creating the textfields!!
                    TextField tf = new TextField();
                    tf.setPrefHeight(50);
                    tf.setPrefWidth(50);
                    tf.setAlignment(Pos.CENTER);
                    tf.setText(" " + rando1 + " ");
                    pane.setRowIndex(tf,y);
                    pane.setColumnIndex(tf,x);    
                    pane.getChildren().add(tf);
                }
            }
            pane.setGridLinesVisible(true);   
            Scene scene = new Scene(pane, 700, 700);    
            primaryStage.setTitle("10 by 10 thingy");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {    
            launch(args);
        }    
    }
