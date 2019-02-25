
/**
* Program:             10x10
* Developer:           Koleman parsley
* Problem:             Create a 10 by 10 grid with either 1's or 0's
*/
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

        // Sets the stage and size
        @Override
        public void start(Stage primaryStage) {
            int size = 10;
            int length = size;
            int width = size;
                //if you want to make grid bigger change the size variable
            GridPane pane = new GridPane();    
                // for loop to create each box
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
                // SHows the grids, change it to false to hide them
            pane.setGridLinesVisible(true);   
            Scene scene = new Scene(pane, 700, 700);    
            primaryStage.setTitle("10 by 10 thingy");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        // show the program
        public static void main(String[] args) {    
            launch(args);
        }    
    }
