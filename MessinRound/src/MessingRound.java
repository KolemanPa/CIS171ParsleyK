/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author theko
 */
public class MessingRound extends Application {
    
    @Override
    public void start(Stage primaryStage) {
            primaryStage.setTitle("Javafx Welcome");        // Sets the title
            
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);                  // creates the grid pane
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));
            
            Text scenetitle = new Text("Welcome");            //sets the scene title and font
            scenetitle.setId("Welcome-text");
            grid.add(scenetitle, 0, 0, 2, 1);
            
            Label userName= new Label("User Name:");                        // Sets teh user name title
            grid.add(userName, 0, 1);
            
            TextField userTextField = new TextField();                      // Sets the user name text box
            grid.add(userTextField, 1, 1);
            
            Label pw = new Label("Password:");                              // sets the password title
            grid.add(pw, 0,2);
            
            PasswordField pwBox = new PasswordField();                      // sets the password text box
            grid.add(pwBox,1,2);
            
            grid.setGridLinesVisible(false);                                // if you put to "true" you can see grid lines on form
            
            Button btn = new Button("Sign in");
            HBox hbBtn = new HBox(10);
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);                           // formats the sign in submit button in bottom right
            hbBtn.getChildren().add(btn);
            grid.add(hbBtn, 1, 4);
            btn.setId("button");
            
            Hyperlink link = new Hyperlink("www.ParsleyPaintings.com");
            
            final Text actiontarget = new Text();                            // gives the sign in butotn an action
                grid.add(actiontarget, 1, 6);
                
                
               btn.setOnAction(new EventHandler<ActionEvent>() {               // tells the sign in button what the action is supposed to be
                   @Override
                   public void handle(ActionEvent e) {
                       actiontarget.setId("actiontarget");
                       helloWorld();
                   }
               });
                   
               
            
            Scene scene = new Scene(grid, 300, 275);
            
            
            primaryStage.setScene(scene);
            scene.getStylesheets().add(MessingRound.class.getResource("Login.css").toExternalForm());
            primaryStage.show();
        };
        

    /**
     * @param args the command line arguments
     */

   public void helloWorld(){
       GridPane grid2 = new GridPane();
            grid2.setAlignment(Pos.CENTER);                  // creates the grid pane
            grid2.setHgap(10);
            grid2.setVgap(10);
            grid2.setPadding(new Insets(25, 25, 25, 25));
          
            Text scenetitle2 = new Text("You are logged in");            //sets the scene title and font
            scenetitle2.setId("Welcome-text");
            grid2.add(scenetitle2, 0, 0, 2, 1);  
       
            
            Button btn2 = new Button("Say hi");
            HBox hbBtn = new HBox(10);
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);                           // formats the sign in submit button in bottom right
            hbBtn.getChildren().add(btn2);
            grid2.add(hbBtn, 1, 4);
            btn2.setId("button");
            
            
                final Text actiontarget1 = new Text();                            // gives the sign in butotn an action
                grid2.add(actiontarget1, 1, 6);
                
                
               btn2.setOnAction(new EventHandler<ActionEvent>() {               // tells the sign in button what the action is supposed to be
                   @Override
                   public void handle(ActionEvent e) {
                       actiontarget1.setId("actiontarget");
                       actiontarget1.setText("read outbpu");
                   }
               });
               
               

   }
   
        public static void main(String[] args) {                    // shows the scene
        launch(args);
    }
}