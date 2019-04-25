
//IMPORTS
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Developer : Koleman Pa Date : 4/23/2019 Program : Raise Flags
 *
 * @author theko
 */
public class RaiseFlags extends Application {

    @Override
    public void start(Stage pStage) {
        
        Button upFlag = new Button("play");             // Play button
        Button downFlag = new Button("reverse");        // Reverse Button
        Button pause = new Button("pause");             // Pause button
        HBox hbox = new HBox(5);                        // Hbox to hold button
        hbox.setAlignment(Pos.CENTER);                  // Alignment
        hbox.getChildren().addAll(upFlag, pause,downFlag);// add elements to pane

        Pane bPane = new Pane(hbox, flagView, pole);        // main pane
        hbox.relocate(800, 800);                            // relocate

        Timeline upAnimation = new Timeline(new KeyFrame(Duration.millis(100), e -> up()));// animation
        upAnimation.setCycleCount(Timeline.INDEFINITE);                                     // cycle
        upAnimation.pause();
        
        pause.setOnAction(e -> upAnimation.pause());                    // Actions
        upFlag.setOnAction(e -> upAnimation.play());
        downFlag.setOnAction(e -> down());

        Scene scene = new Scene(bPane, 1500, 900);

        pStage.setTitle("Raise Flags");
        pStage.setScene(scene);
        pStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    Rectangle pole = new Rectangle(10,790);
    
    Image flag = new Image("flag.png");
    ImageView flagView = new ImageView(flag);
    Pane flagPane = new Pane();

    private double startY = 5;
    private double increment = -5;

    public void up() {
        pole.relocate(600, 0);
        flagView.setFitHeight(100);
        flagView.setFitWidth(100);
        setStart(startY + increment);
    }

    public void setStart(double yCord) {
        this.startY = yCord;
        setValue();
    }

    public void setValue() {
        flagView.relocate(600, startY + 500);
    }

    public void down() {
        increment = -increment;
    }
}
