/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listing14_5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author theko
 */
public class ShowCircleCentered extends Application{
    
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        
        Circle circle = new Circle();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.AQUA);
        circle.setFill(Color.CORAL);
        
        
        pane.getChildren().add(circle);         // add circle to pane
        
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Show Circle Centered");
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
