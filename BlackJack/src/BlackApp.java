
// IMPORTS
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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

    // creates 4 decks
    List<Image> deck1 = new ArrayList<Image>();
    List<Image> deck2 = new ArrayList<Image>();
    List<Image> deck3 = new ArrayList<Image>();
    List<Image> deck4 = new ArrayList<Image>();

    //makes sure each class has 40 number cards
    int count;

    // creates the prefixes for decks
    List<String> prefix = Arrays.asList("c", "d", "h", "s");
    List<String> prefixFace = Arrays.asList("j", "q", "k");

    public List load(List<Image> newDeck) {
        count = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 10; k++) {
                newDeck.add(new Image("images/" + prefix.get(i) + "" + (k + 1) + ".png"));
                count++;
            }// end number card for loop
            for (int l = 0; l < 3; l++) {
                newDeck.add(new Image("images/" + prefix.get(l) + "" + prefixFace.get(l) + ".png"));
                count++;
            }// end face card for loop
        }// end deck for loop
//        
        System.out.println(count);
        Collections.shuffle(newDeck);
        return newDeck;
    }

    @Override
    public void start(Stage primaryStage) {
        // loads 4 decks with cards
        deck1 = load(deck1);
        deck2 = load(deck2);
        deck3 = load(deck3);
        deck4 = load(deck4);
        primaryStage.setTitle("Shuffling Deck Program");

        BorderPane bPane1 = new BorderPane();
        HBox pane1 = new HBox(10);
        HBox pane2 = new HBox(10);

        ImageView view0 = new ImageView(deck1.get(0));
        ImageView view1 = new ImageView(deck1.get(1));
        ImageView view2 = new ImageView(deck1.get(2));
        ImageView view3 = new ImageView(deck1.get(3));

        Button refresh = new Button("Refresh");

        refresh.setOnAction(e -> {

            Collections.shuffle(deck1);

            view0.setImage(deck1.get(0));
            view1.setImage(deck1.get(1));
            view2.setImage(deck1.get(2));
            view3.setImage(deck1.get(3));

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
