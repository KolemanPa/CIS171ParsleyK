/*
* Program:      Button Demo
* Developer:    Koleman Pa
* Date:         2/21/2019
* Purpose:      Demo buttons
*/
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;

public class ButtonDemo extends Application{
    //class level (instance) varriable
    protected Text text = new Text(50,50,"JavaFx Programming");
    
    protected BorderPane getPane(){
        HBox paneForButtons = new HBox(20);
        Button btLeft = new Button("",new ImageView("images/leftArrow.png"));
        Button btRight = new Button("", new ImageView("images/rightArrow.png"));
        paneForButtons.getChildren().addAll(btLeft,btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: green");
        
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);
        
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);
        
        btLeft.setOnAction(e -> text.setX(text.getX()-10));                                 // Set the btLeft button to move left
        btRight.setOnAction(e ->text.setX(text.getX()+10));                                 // Set the btRight button to move right
        
        return pane;                                                                        //Return to Caller
    }

    @Override 
    public void start(Stage pStage){
        Scene scene = new Scene(getPane(),450,200);
        pStage.setTitle("BUTTON DEMO");
        pStage.setScene(scene);
        pStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
