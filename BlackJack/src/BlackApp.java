
// IMPORTS
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Developer: Koleman Pa Date: 5/3/2019 Program: Black Jack Game
 *
 * @author theko
 */
public class BlackApp extends Application {

    List<Image> deck = new ArrayList<Image>();
        int count;

    public void load() {
        for (int i = 0; i < 13; i++) {
            deck.add(new Image("file:images/c" + (i + 1) + ".png"));
            System.out.println("file:images/c" + (i + 1) + ".png");
            count++;

        }
        for (int j = 0; j < 13; j++) {
            deck.add(new Image("file:images/d" + (j + 1) + ".png"));
//            deck.add().getClass().getResource("images/d"+(j+1)+".png");
            System.out.println("file:images/c" + (j + 1) + ".png");
            count++;
        }
        for (int k = 0; k < 13; k++) {
            deck.add(new Image("file:images/h" + (k + 1) + ".png"));
            System.out.println("file:images/c" + (k + 1) + ".png");
            count++;

        }
        for (int l = 0; l < 13; l++) {
            deck.add(new Image("file:images/s" + (l + 1) + ".png"));
            System.out.println("file:images/c" + (l + 1) + ".png");
            count++;
        }
        System.out.println(count);
    }

    @Override
    public void start(Stage primaryStage) {

        load();

        primaryStage.setTitle("Shuffling Deck Program");

        BorderPane bPane1 = new BorderPane();
        HBox pane1 = new HBox(10);
        HBox pane2 = new HBox(10);

        ImageView view0 = new ImageView(deck.get(0));
        ImageView view1 = new ImageView(deck.get(1));
        ImageView view2 = new ImageView(deck.get(2));
//        ImageView view3 = new ImageView(deck.get(3));
        ImageView view3 = new ImageView("images/c1.png");

        Button refresh = new Button("Refresh");

        refresh.setOnAction(e -> {

            Collections.shuffle(deck);

            view0.setImage(deck.get(0));
            view1.setImage(deck.get(1));
            view2.setImage(deck.get(2));
            view3.setImage(deck.get(3));

        });

        pane1.setAlignment(Pos.CENTER);
        pane2.setAlignment(Pos.CENTER);

        pane1.getChildren().addAll(view0, view1, view2, view3);
        pane2.getChildren().addAll(refresh, view3);

        bPane1.setCenter(pane1);
        bPane1.setBottom(pane2);
        bPane1.setTop(view3);

        Scene scene1 = new Scene(bPane1, 600, 650);
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
