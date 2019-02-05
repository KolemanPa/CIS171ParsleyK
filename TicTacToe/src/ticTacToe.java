/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author theko
 */
public class ticTacToe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Image imageX = new Image("Img/x.gif");      //Calls the images
        Image imageO = new Image("Img/o.gif");      // Calls image
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);              //Sets position
        pane.setHgap(5);
        pane.setVgap(5);
        
        for (int j = 0; j < 3; j++) {               // For loop
            for (int i = 0; i<3; i++) {
        
            int status = (int) (Math.random() * 3); // sets each section on a random image
            if (status == 0) {
                pane.add(new ImageView(imageX), i, j);
        }
            else if (status == 1) {
                pane.add(new ImageView(imageO), i, j);
            }
        }
        }
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
