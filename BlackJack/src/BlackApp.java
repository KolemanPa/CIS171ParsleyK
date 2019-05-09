
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Developer: Koleman Pa Date: 5/3/2019 Program: Black Jack Game
 *
 * @author theko
 */
public class BlackApp extends Application {

    Stage window;
    // creates 4 decks
    List<Image> deck1 = new ArrayList<Image>();
    List<Image> deck2 = new ArrayList<Image>();
    List<Image> deck3 = new ArrayList<Image>();
    List<Image> deck4 = new ArrayList<Image>();

    RadioButton oneDeck = new RadioButton("1 deck");
    RadioButton twoDeck = new RadioButton("2 deck");
    RadioButton threeDeck = new RadioButton("3 deck");
    RadioButton fourDeck = new RadioButton("4 deck");

    //makes sure each class has 40 number cards
    int count;

    // creates the prefixes for decks
    List<String> prefix = Arrays.asList("c", "d", "h", "s");
    List<String> prefixFace = Arrays.asList("j", "q", "k");

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        // loads 4 decks with cards
        primaryStage.setTitle("Shuffling Deck Program");

        // Radio Button for rules page
        ToggleGroup amntOfDecks = new ToggleGroup();
        oneDeck.setToggleGroup(amntOfDecks);
        twoDeck.setToggleGroup(amntOfDecks);
        threeDeck.setToggleGroup(amntOfDecks);
        fourDeck.setToggleGroup(amntOfDecks);

        HBox deckBox = new HBox(15);
        deckBox.getChildren().addAll(new Label("How many Decks?:     "), oneDeck, twoDeck, threeDeck, fourDeck);
        deckBox.setAlignment(Pos.BOTTOM_CENTER);
        
        BorderPane bPane1 = new BorderPane();
        BorderPane mainbPane = new BorderPane();
        BorderPane chooseRules = new BorderPane();

        HBox pane1 = new HBox(10);
        HBox pane2 = new HBox(10);
        HBox pane3 = new HBox(10);
        HBox welcomeMsg = new HBox(10);
        HBox startHbox = new HBox(10);

        ImageView view0 = new ImageView();
        ImageView view1 = new ImageView();
        ImageView view2 = new ImageView();
        ImageView view3 = new ImageView();

        Button refresh = new Button("Refresh");
        Button chooseRulesbtn = new Button("Choose Rules");
        Button startGame = new Button("Start Game");
        mainbPane.setCenter(new Label("Hi welcome to Black Jack created by Koleman Parsley"));
        mainbPane.setBottom(chooseRulesbtn);
        chooseRules.setBottom(startGame);
        chooseRules.setTop(deckBox);

        refresh.setOnAction(e -> {

            Collections.shuffle(deck1);

            view0.setImage(deck1.get(0));
            view1.setImage(deck1.get(1));
            view2.setImage(deck1.get(2));
            view3.setImage(deck1.get(3));

        });

        pane1.setAlignment(Pos.CENTER);
        pane2.setAlignment(Pos.CENTER);
        pane3.setAlignment(Pos.CENTER);
        startHbox.setAlignment(Pos.CENTER);

        pane1.getChildren().addAll(view0, view1, view2, view3);
        pane2.getChildren().addAll(refresh);
        pane3.getChildren().addAll(chooseRulesbtn);

        mainbPane.setBottom(pane3);
        bPane1.setCenter(pane1);
        bPane1.setBottom(pane2);
        mainbPane.setBottom(pane3);

        mainbPane.setCenter(welcomeMsg);
        Scene scene1 = new Scene(bPane1, 600, 650);
        Scene welcomeScene = new Scene(mainbPane, 600, 650);
        Scene chooseRulesScn = new Scene(chooseRules, 600,650);
        chooseRulesbtn.setOnAction(e -> window.setScene(chooseRulesScn));
        startGame.setOnAction(e -> {
           setDeckNum();
           
           window.setScene(scene1);
        });

        primaryStage.setScene(welcomeScene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setDeckNum() {
        if (oneDeck.isSelected()) {
            setDecks(1);
        } else if (twoDeck.isSelected()) {
            setDecks(2);
        } else if (threeDeck.isSelected()) {
            setDecks(3);
        } else {
            setDecks(4);
        }
    }

    public void setDecks(Integer amntDecks) {
        if (amntDecks == 1) {
            deck1 = load(deck1);

        } else if (amntDecks == 2) {
            deck1 = load(deck1);
            deck2 = load(deck2);
        } else if (amntDecks == 3) {
            deck1 = load(deck1);
            deck2 = load(deck2);
            deck3 = load(deck3);
        } else if (amntDecks == 4) {
            deck1 = load(deck1);
            deck2 = load(deck2);
            deck3 = load(deck3);
            deck4 = load(deck4);
        }
    }

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
}
