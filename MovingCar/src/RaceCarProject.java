
/**
 *
 * Program:     Race Car Project
 * Developer:   Koleman Pa
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

//      Create class that extends the Application
public class RaceCarProject extends Application {

    @Override
    public void start(Stage pStage) {

        // creates the play, pause, and reverse buttons
        Button btPause = new Button("");
        Image pause = new Image("images/pause.png", 50, 50, false, false);
        btPause.setGraphic(new ImageView(pause));
        Button btResume = new Button("");
        Image resume = new Image("images/play.png", 50, 50, false, false);
        btResume.setGraphic(new ImageView(resume));
        Button btReverse = new Button("");
        Image reverse = new Image("images/reverse.gif", 50, 50, false, false);
        btReverse.setGraphic(new ImageView(reverse));
        HBox hbox = new HBox(5);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(btPause, btResume, btReverse);

        // creates a the car
        moveCar car1 = new moveCar();

        // adds both the car and the buttons to the pane
        Pane bPane = new Pane(hbox, car1);
        hbox.relocate(800, 800);

        // sets the animations
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), e -> car1.move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.pause();

        // assigns each button an animation
        btPause.setOnAction(e -> animation.pause());
        btResume.setOnAction(e -> animation.play());
        btReverse.setOnAction(e -> car1.reverse());

        Scene scene = new Scene(bPane, 2000, 1000);

        pStage.setTitle("Race Car");
        pStage.setScene(scene);
        pStage.show();

    }

    // launches the GUI
    public static void main(String[] args) {
        launch(args);
    }

}

class moveCar extends Pane {

    Pane pane1 = new Pane();

    private Circle rWheel = new Circle(75);
    private Rectangle car = new Rectangle(650, 300);
    private Rectangle fCar = new Rectangle(325, 150);
    Circle lWheel = new Circle(75);

    public void setValue() {
        lWheel.relocate(startX + 100, 550);
        fCar.relocate(startX + 550, 400);
        car.relocate(startX + 0, 250);
        rWheel.relocate(startX + 600, 550);
    }

    public moveCar() {
        car.setFill(Color.YELLOW);
        fCar.setFill(Color.YELLOW);
        getChildren().addAll(rWheel, car, fCar, lWheel);
        lWheel.relocate(100, 550);
        fCar.relocate(550, 400);
        car.relocate(0, 250);
        rWheel.relocate(600, 550);
        Image rImage = new Image("images/Wheel.jpg");
        rWheel.setStroke(Color.BLACK);
        rWheel.setFill(new ImagePattern(rImage));

        Image lImage = new Image("images/Wheel.jpg");
        lWheel.setStroke(Color.BLACK);
        lWheel.setFill(new ImagePattern(lImage));

    }
    private double startX = 5;
    private double increment = 5;

    public void move() {
        setStart(startX + increment);
    }

    public void setStart(double xCord) {
        this.startX = xCord;
        setValue();
    }

    public void reverse() {
        increment = -increment;
    }
}
