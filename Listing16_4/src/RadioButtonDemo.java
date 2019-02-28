/**
 * Program:             RadioButotnDemo
 * Developer:   `       Koleman Pa
 * Date:                2/21/19
*
 */

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RadioButtonDemo extends CheckBoxDemo {
  @Override // Override the getPane() method in the super class
  protected BorderPane getPane() {
    BorderPane pane = super.getPane();
    
    VBox paneForRadioButtons = new VBox(20);
    paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5)); 
    paneForRadioButtons.setStyle
      ("-fx-border-width: 2px; -fx-border-color: green");

    RadioButton rbRed = new RadioButton("PURPLE");                      //SETS the text for rbRED to purple
    RadioButton rbGreen = new RadioButton("YELLOWGREEN");               // sets the text for rbGreen to YELLOWGREEN
    RadioButton rbBlue = new RadioButton("AQUAMARINE");                 // Sets the text for rbBlue to AQUAMARINE
    paneForRadioButtons.getChildren().addAll(rbRed, rbGreen, rbBlue);
    pane.setLeft(paneForRadioButtons);

    ToggleGroup group = new ToggleGroup();                              // adds all the buttons to the group "group"
    rbRed.setToggleGroup(group);
    rbGreen.setToggleGroup(group);
    rbBlue.setToggleGroup(group);
    
    rbRed.setOnAction(e -> {
      if (rbRed.isSelected()) {
        text.setFill(Color.PURPLE);                                                 // sets the button value to PURPLE
      }
    });
    
    rbGreen.setOnAction(e -> {
      if (rbGreen.isSelected()) {
        text.setFill(Color.YELLOWGREEN);                                // sets the button to yellowgreen
      }
    });

    rbBlue.setOnAction(e -> {
      if (rbBlue.isSelected()) {
        text.setFill(Color.AQUAMARINE);                                 // sets the button to aquamarine
      }
    });
    
    return pane;
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);                                                   // launches it
  }
}