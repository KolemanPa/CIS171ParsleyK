
// IMPORTS
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
import java.net.*;
import java.io.*;
import java.util.Random;

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
    List<Image> mainDeck = new ArrayList<Image>();
    List<String> nameDeck = new ArrayList<String>();
    HashMap<Image, String> nameData = new HashMap<Image, String>();
    List<String> name1 = new ArrayList<String>();
    List<String> name2 = new ArrayList<String>();
    List<String> name3 = new ArrayList<String>();
    List<String> name4 = new ArrayList<String>();

    // USE THIS TO SHUFFLE IN SAME WAY
    long seed = System.nanoTime();
    boolean didYouLoose = false;
    

    List<String> deckURL = new ArrayList<String>();

    RadioButton oneDeck = new RadioButton("1 deck");
    RadioButton twoDeck = new RadioButton("2 deck");
    RadioButton threeDeck = new RadioButton("3 deck");
    RadioButton fourDeck = new RadioButton("4 deck");
    int cardsInHand = 2;

    //makes sure each class has 40 number cards
    int count;
    int totalPoints = 0;

    Boolean win = false;

    int howClose;

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

        BorderPane mainbPane = new BorderPane();
        BorderPane chooseRules = new BorderPane();
        BorderPane gamebPane = new BorderPane();
        BorderPane buttons = new BorderPane();
        BorderPane rulesBox = new BorderPane();
        BorderPane youLostPane = new BorderPane();

        HBox deckBox = new HBox(15);
//        deckBox.getChildren().addAll(new Label("How many Decks?:     "), oneDeck, twoDeck, threeDeck, fourDeck);

        deckBox.setAlignment(Pos.CENTER);

        HBox pane1 = new HBox(10);
        HBox pane2 = new HBox(10);
        HBox pane3 = new HBox(10);
        HBox startHbox = new HBox(10);

        // Image views for decks
        ImageView view0 = new ImageView();
        ImageView view1 = new ImageView();
        ImageView view2 = new ImageView();
        ImageView view3 = new ImageView();
        ImageView view4 = new ImageView();

        Button shuffle = new Button("Refresh");
        Button chooseRulesbtn = new Button("Choose Rules");
        Button startGame = new Button("Start Game");
        Button hitMe = new Button("hit Me");
        Button end = new Button("End");
        mainbPane.setCenter(new Label("Hi welcome to Black Jack created by Koleman Parsley"));
        youLostPane.setCenter(new Label("You Lost"));
        chooseRules.setBottom(startGame);
        deckBox.getChildren().addAll(new Label("How many Decks?:     "), oneDeck, twoDeck, threeDeck, fourDeck);

        chooseRules.setCenter(deckBox);

        pane1.setAlignment(Pos.CENTER);
        pane2.setAlignment(Pos.CENTER);
        pane3.setAlignment(Pos.CENTER);
        startHbox.setAlignment(Pos.CENTER);
        hitMe.setAlignment(Pos.BOTTOM_CENTER);
        end.setAlignment(Pos.TOP_CENTER);

        pane1.getChildren().addAll(view0, view1, view2, view3, view4);
        pane2.getChildren().addAll(shuffle);
        pane3.getChildren().addAll(chooseRulesbtn);
        pane3.setAlignment(Pos.CENTER);
        mainbPane.setBottom(pane3);

        buttons.setCenter(hitMe);
        buttons.setBottom(end);

        Scene youLost = new Scene(youLostPane, 600, 650);
        Scene welcomeScene = new Scene(mainbPane, 600, 650);
        welcomeScene.getStylesheets().add("style.css");
        Scene chooseRulesScn = new Scene(chooseRules, 600, 650);
        chooseRulesScn.getStylesheets().add("style.css");
        Scene game = new Scene(gamebPane, 600, 650);
        game.getStylesheets().add("style.css");

        chooseRulesbtn.setOnAction(e -> window.setScene(chooseRulesScn));

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

//        List<Image> mainDeck = new ArrayList<Image>();
//        //population of the list
//        HashMap<Image, String> nameData = new HashMap<Image, String>();
//        for (Image card : mainDeck) {
//            String path = card.getUrl();
//            String name = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
//            nameData.put(card, name);
//        }
        // ACtions
        startGame.setOnAction(e -> {
            setDeckNum();
            window.setScene(game);
            gamebPane.setCenter(null);
            gamebPane.setRight(buttons);
            gamebPane.setCenter(pane1);
            view0.setImage(mainDeck.get(0));
            getPoints(nameDeck.get(0));
            view1.setImage(mainDeck.get(1));
            getPoints(nameDeck.get(1));

        });

        shuffle.setOnAction(e -> {

            System.out.println("Shuffled");
        });

        hitMe.setOnAction(e -> {
            didIWin();
            if (win == true) {
                window.setScene(youLost);
            } else if (cardsInHand == 2) {
                view2.setImage(mainDeck.get(2));
                getPoints(nameDeck.get(2));
                cardsInHand++;
            } else if (cardsInHand == 3) {
                view3.setImage(mainDeck.get(3));
                getPoints(nameDeck.get(3));

                cardsInHand++;
            } else if (cardsInHand == 4) {
                view4.setImage(mainDeck.get(4));
                getPoints(nameDeck.get(4));

                cardsInHand++;
            }

        });

        end.setOnAction(e -> {
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
            deck1 = loadImage(deck1);
            name1 = loadName(name1);
            mainDeck.addAll(deck1);
            nameDeck.addAll(name1);
            Collections.shuffle(mainDeck, new Random(seed));
            Collections.shuffle(nameDeck, new Random(seed));

        } else if (amntDecks == 2) {
            deck1 = loadImage(deck1);
            deck2 = loadImage(deck2);

            name2 = loadName(name2);
            name2 = loadName(name2);

            mainDeck.addAll(deck1);
            mainDeck.addAll(deck2);
            nameDeck.addAll(name1);
            nameDeck.addAll(name2);

            Collections.shuffle(mainDeck, new Random(seed));
            Collections.shuffle(nameDeck, new Random(seed));

        } else if (amntDecks == 3) {
            deck1 = loadImage(deck1);
            deck2 = loadImage(deck2);
            deck3 = loadImage(deck3);
            name1 = loadName(name1);
            name2 = loadName(name2);
            name3 = loadName(name3);

            mainDeck.addAll(deck1);
            mainDeck.addAll(deck2);
            mainDeck.addAll(deck3);
            nameDeck.addAll(name1);
            nameDeck.addAll(name2);
            nameDeck.addAll(name3);

            // UPDATE THIS
            mainDeck.addAll(deck1);
            mainDeck.addAll(deck2);
            mainDeck.addAll(deck3);
            Collections.shuffle(mainDeck, new Random(seed));
            Collections.shuffle(nameDeck, new Random(seed));

        } else if (amntDecks == 4) {
            deck1 = loadImage(deck1);
            deck2 = loadImage(deck2);
            deck3 = loadImage(deck3);
            deck4 = loadImage(deck4);
            name1 = loadName(name1);
            name2 = loadName(name2);
            name3 = loadName(name3);
            name4 = loadName(name4);

            mainDeck.addAll(deck1);
            mainDeck.addAll(deck2);
            mainDeck.addAll(deck3);
            mainDeck.addAll(deck4);
            nameDeck.addAll(name1);
            nameDeck.addAll(name2);
            nameDeck.addAll(name3);
            nameDeck.addAll(name4);

            Collections.shuffle(mainDeck, new Random(seed));
            Collections.shuffle(nameDeck, new Random(seed));

        }
    }

    public List loadImage(List<Image> newDeck) {
        count = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 13; k++) {
                newDeck.add(new Image("images/" + prefix.get(i) + "" + (k + 1) + ".png"));
//                System.out.println("images/" + prefix.get(i) + "" + (k + 1) + ".png");
                count++;
            }// end number card for loop
        }// end deck for loop
//        
//        System.out.println(count);
        return newDeck;
    }

    public List loadName(List<String> newName) {
        count = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 13; k++) {
                newName.add(("images/" + prefix.get(i) + "" + (k + 1) + ".png"));
                count++;
            }// end number card for loop
        }// end deck for loop
//        
        System.out.println(count);
        return newName;
    }

    public Integer getPoints(String s) {
        int numPoints = 0;

        String numberOnly = s.replaceAll("[^0-9]", "");

        int result = Integer.parseInt(numberOnly);
        if (result == 1) {
            numPoints = 1;
        }
        if (result == 2) {
            numPoints = 2;
        }
        if (result == 3) {
            numPoints = 3;
        }
        if (result == 4) {
            numPoints = 4;
        }
        if (result == 5) {
            numPoints = 5;
        }
        if (result == 6) {
            numPoints = 6;
        }
        if (result == 7) {
            numPoints = 7;
        }
        if (result == 8) {
            numPoints = 8;
        }
        if (result == 9) {
            numPoints = 9;
        }
        if (result == 10) {
            numPoints = 10;
        }
        if (result == 11) {
            numPoints = 10;
        }
        if (result == 12) {
            numPoints = 10;
        }
        if (result == 13) {
            numPoints = 10;
        }

        totalPoints += numPoints;
        didIWin();
//        System.out.println(numPoints );
        System.out.println(s);
        System.out.println(totalPoints);
        return numPoints;

    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void didIWin() {
        if (totalPoints > 21) {
            win = true;
            didYouLoose = true;
        } else {
            howClose = (21 - totalPoints);
            win = false;
        }
    }
}
