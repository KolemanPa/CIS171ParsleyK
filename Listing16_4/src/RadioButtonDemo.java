/**
 * Program:     Check Box Demo
 * Developer:   Koleman Pa
 * Date:        2/26/2019
 * Problem:     
 */

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.util.Scanner;

public class RadioButtonDemo extends CheckBoxDemo{
    @Override
    protected BorderPane getPane(){
        BorderPane pane = super.getPane();
        
        VBox paneForRBt = new VBox(20);
        paneForRBt.setPadding(new Insets(5,5,5,5));
        paneForRBt.setStyle("-fx.border-width: 2px; -fx-border-color: green");
        
        // create the radio buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("green");
        RadioButton rbBlue = new RadioButton("Blue");
        paneForRBt.getChildren().addAll(rbRed,rbGreen,rbBlue);
        
        //Create the toggle group = radio button group
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbGreen.setToggleGroup(group);
        rbBlue.setToggleGroup(group);
        
        pane.setLeft(paneForRBt);
        
        //Set up action Event
       rbRed.setOnAction(e ->{
            if(rbRed.isSelected()){
                System.out.println("ACTION EVENT IS RED");
           text.setFill(Color.RED);                 
            }     
       }); 
       
            rbGreen.setOnAction(e ->{
            if (rbGreen.isSelected()){
                System.out.println("ACTION EVENT IS GREEN");
                text.setFill(Color.GREEN);
            }                
            });
            
            rbBlue.setOnAction(e->{
            if(rbBlue.isSelected()){
                System.out.println("ACTION EVENT IS BLUE");
                text.setFill(Color.BLUE);
            }                
            });

       //Complete lambda expression
        
        return pane;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a string");
        String txt = sc.nextLine();
        launch(args);
    }
    
}
