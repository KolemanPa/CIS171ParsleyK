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
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class conversionApp extends Application{
    @Override
    public void start(Stage primaryStage) {
        
        // CREATES the placeholder for text fields
        double usDollars = 0;
        double canDollars = 0;
        String stuff;
        
        // CREATES the main pain
        BorderPane pane = new BorderPane();
        
        // CREATES the pane for american dollars
        BorderPane paneForAmericanDollars = new BorderPane();
        
        // SETS alignment for new pane
        paneForAmericanDollars.setPadding(new Insets(5,5,5,5));
        
        // CREATES label for new pane
        paneForAmericanDollars.setLeft(new Label("American Dollars: "));
        
        // CREATES text field for americanDollars pane
        TextField fieldForAmericanDollars = new TextField(""+usDollars);
        
        //SETS alignment for textfield in AmericanDOllars pane
        fieldForAmericanDollars.setAlignment(Pos.TOP_RIGHT);
        paneForAmericanDollars.setCenter(fieldForAmericanDollars);
        
        // SETS alignemnt for AmericanDOllars pane in main pane
        pane.setTop(paneForAmericanDollars);
        
        /**
         *  Now for the Canadian textfield
         */
        
        // CREATES the pane for canadian dollars
        BorderPane paneForCanadianDollars = new BorderPane();
        
        // SETS the alignment for new pane
        paneForCanadianDollars.setPadding(new Insets(5,5,5,5));
        
        // CREATES label for new pane
        paneForCanadianDollars.setLeft(new Label("Canadian Dollars: "));
        
        // CREATES text field for Canadian Dollars pane
        TextField fieldForCanadianDollars = new TextField(" "+canDollars);
        
        fieldForCanadianDollars.setAlignment(Pos.TOP_RIGHT);
        paneForCanadianDollars.setTop(fieldForCanadianDollars);
        
        // SETS alignment for canadian dollars pane in main pane
        pane.setCenter(paneForCanadianDollars);
        
        Text tempoText = new Text();
        
        // Adds an action to text field
        fieldForAmericanDollars.setOnAction(e ->{
            
            tempoText.setText(fieldForAmericanDollars.getText());
            String sstuff = tempoText.getText();
            double someM = Double.parseDouble(sstuff);
            fieldForCanadianDollars.setText("$"+someM*1.5);
            });
        
        
        // Adds an action to text field
        fieldForCanadianDollars.setOnAction(e ->{
            
            tempoText.setText(fieldForCanadianDollars.getText());
            String sstuff = tempoText.getText();
            double someM = Double.parseDouble(sstuff);
            someM = (someM*.67);
            fieldForAmericanDollars.setText("$"+someM);
            });
        
        
        
                
        
        // CREATES the scene
        Scene scene = new Scene(pane,450,200);
        primaryStage.setTitle("CONVERSION");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
