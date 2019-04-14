/**
 * Program:             Conversion App
 * Developer:           Koleman Pa
 * Date:                3/18/2019
 * Problem:             creating an app that converts US dollars to Canadian money, the conversion rate is
 *                      1.5 US dollars for 1 Canadian DOllars
 * 
 */

// HERE I IMPORT STUFF
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class conversionApp extends Application{
    @Override
    public void start(Stage primaryStage) {
        // CREATES the main pain
        BorderPane pane = new BorderPane();
        
        // CREATES the pane for american dollars
        BorderPane paneForAmericanDollars = new BorderPane();
        
        // SETS alignment for new pane
        paneForAmericanDollars.setPadding(new Insets(5,5,5,5));
        
        // CREATES label for new pane
        paneForAmericanDollars.setLeft(new Label("American Dollars: "));
        
        // CREATES text field for americanDollars pane
        TextField fieldForAmericanDollars = new TextField();
        
        //SETS alignment for textfield in AmericanDOllars pane
        fieldForAmericanDollars.setAlignment(Pos.TOP_RIGHT);
        paneForAmericanDollars.setCenter(fieldForAmericanDollars);
        
        // SETS alignemnt for AmericanDOllars pane in main pane
        pane.setTop(paneForAmericanDollars);
        
//* This action event could calculate the converted value? Maybe call a method to do the work?        
        
        // Adds an action to text field
        fieldForAmericanDollars.setOnAction(e -> fieldForCanadianDollars.setText(fieldForAmericanDollars.getText()));
        
        // CREATES the pane for canadian dollars
        BorderPane paneForCanadianDollars = new BorderPane();
        
        // SETS the alignment for new pane
        paneForCanadianDollars.setPadding(new Insets(5,5,5,5));
        
        // CREATES label for new pane
        paneForCanadianDollars.setLeft(new Label("Canadian Dollars: "));
        
        // CREATES text field for Canadian Dollars pane
        TextField fieldForCanadianDollars = new TextField("PlaceHolder");
        
        fieldForCanadianDollars.setAlignment(Pos.TOP_RIGHT);
        paneForCanadianDollars.setCenter(fieldForCanadianDollars);
        
        // SETS alignment for canadian dollars pane in main pane
        pane.setCenter(paneForCanadianDollars);
        
        
        
        
        
        
        
        
    }

    public static void main(String[] args) {
        
    }
    
}
