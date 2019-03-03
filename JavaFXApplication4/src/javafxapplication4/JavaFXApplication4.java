/*
* Program:  Hangman Picture
* Developer: Koleman Pa
* Date:     2/21/2019
* Purpose:  Create a Hangman picture using objects
 */
package javafxapplication4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class JavaFXApplication4 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
// good code - could be improved by using methods for each component
        
        //Creates the head of the man
        Circle circle = new Circle(50);
        circle.relocate(675,250);
        
//        Circle lEye = new Circle(8);
//        lEye.setFill(Color.BLUE);
//        lEye.relocate(695,270);
        // Creates all the body and hands and feet
        Line line1 = new Line(725,250,725,150);
        Line line2 = new Line(725,150,300,150);
        Line line3 = new Line(300,150,300,900);
        Line line4 = new Line(100,900,500,900);
        Line body = new Line(725,275,725,525);
        Line lLeg = new Line(725,525,650,700);
        Line rLeg = new Line(725,525,800,700);
        Line lArm = new Line(725,400,650,525);
        Line rArm = new Line(725,400,800,525);
        
        
        // Adds all the shapes to the pane to display them
        Pane root = new Pane();
        root.getChildren().addAll(line1,line2,line3,line4);
        root.getChildren().add(circle);
        root.getChildren().add(body);
        root.getChildren().add(lLeg);
        root.getChildren().add(rLeg);
        root.getChildren().addAll(lArm, rArm);
//        root.getChildren().add(lEye);
        
        Scene scene = new Scene(root, 1000, 1000);
        
        primaryStage.setTitle("Hangman Picture!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Shows the finished project :)
    public static void main(String[] args) {
        launch(args);
    }
    
}
