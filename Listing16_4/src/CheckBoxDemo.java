/**
 * Program:     Check Box Demo
 * Developer:   Koleman Pa
 * Date:        2/26/2019
 * Problem:     
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class CheckBoxDemo extends ButtonDemo {
    
    @Override
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();          //Run the method in the super class
        
        Font fontBoldItalic = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC,20);
        Font fontBold = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font fontItalic = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fontNormal = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20);
        
        
        text.setFont(fontNormal);
        
        //CREATE THE CHECKBOXES
        VBox paneForCheckBoxes = new VBox(50);
        paneForCheckBoxes.setPadding(new Insets(5,5,5,5));
        paneForCheckBoxes.setStyle("-fx-border-color: yellow");
        
        //Set Up CHeckboxes
        CheckBox chkBold = new CheckBox("BOLD");
        CheckBox chkItalic = new CheckBox("ITALIC");
        paneForCheckBoxes.getChildren().addAll(chkBold,chkItalic);
        
        pane.setRight(paneForCheckBoxes);
        
        // EVENT HANDLER FOR CHECKBOXES
        
        EventHandler<ActionEvent> handler = e -> {
            if(chkBold.isSelected() && chkItalic.isSelected()){
                text.setFont(fontBoldItalic);
            }
            else if (chkBold.isSelected()){
                text.setFont(fontBold);
            }
            else if(chkItalic.isSelected()){
                text.setFont(fontItalic);
                
            }
            else {
                text.setFont(fontNormal);
            }
        };
        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);
        
        return pane;
    }
//    public static void main(String[] args) {
//        launch(args);
//    }
    
}
