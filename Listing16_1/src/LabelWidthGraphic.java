
/**
 * Program:     LabelWidthGrphic
 * Developer:   Koleman Pa
 * Date:        2/21/2019
 * Purpose:     Format a GUI with a label (From revel textbook)
 * 
 */
// all the imports you ever need :)
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;

public class LabelWidthGraphic extends Application{
    // Overides the start method and assigns pStage as the stage
    public void start(Stage pStage){
        ImageView painting = new ImageView(new Image("images/US.JPG"));
        Label lbl = new Label("US\nPaintings", painting);
        lbl.setStyle("-fx-border-color: green; -fx-border-width: 2");
        lbl.setContentDisplay(ContentDisplay.BOTTOM);
        lbl.setTextFill(Color.RED);
        
        Label lb2 = new Label("Circle", new Circle(50,50,25));
        lb2.setContentDisplay(ContentDisplay.TOP);
        lb2.setTextFill(Color.ORANGE);
        
        Label lb3 = new Label("Rectangle", new Rectangle(10,10,50,25));
        lb3.setContentDisplay(ContentDisplay.RIGHT);
        
        Label lb4 = new Label("Ellipse", new Ellipse(50,50,50,25));
        lb4.setContentDisplay(ContentDisplay.LEFT);
        
        Ellipse ellipse = new Ellipse(50,50,50,25);
        ellipse.setStroke(Color.GREEN);
        ellipse.setFill(Color.WHITESMOKE);
        
        StackPane sPane = new StackPane();
        sPane.getChildren().addAll(ellipse, new Label("Javafx"));
        
        Label lb5 = new Label("A pane inside a label", sPane);
        lb5.setContentDisplay(ContentDisplay.BOTTOM);
        
        HBox pane = new HBox(20);
        pane.getChildren().addAll(lbl,lb2,lb3,lb4,lb5);
        
        Scene scene = new Scene(pane,1000,1000);
        pStage.setTitle("LabelWidthGraphic");
        pStage.setScene(scene);
        pStage.show();
        
    }
    
    public static void main(String[] args) {
     launch(args);   
    }
    
}
