
//IMPORTS
import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class Client extends Application{
    //IO strings
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    @Override
    public void start(Stage pStage){
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5,5,5,5));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("enter a radius: "));
        
        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);
        
        BorderPane mainPane = new BorderPane();
        // TEXT area to display contents
        TextArea ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);
        
        // Create our scene
        Scene scene = new Scene(mainPane,450,200);
        pStage.setTitle("Client");
        pStage.setScene(scene);
        pStage.show();
        
        tf.setOnAction(e -> {
            try{
                // Get radius from text field
                double radius = Double.parseDouble(tf.getText().trim());
                // Send to server
                toServer.writeDouble(radius);
                toServer.flush();
                
                // get Area from the server
                double area = fromServer.readDouble();
                // Display to text area
                ta.appendText("Radius is "+ radius + "\n Area is " + area+ " \n");
            }
            catch(IOException ex){
                System.err.println(ex);
            }
        });
        
        try {
            // create a socket ot connect ot server
            Socket socket = new Socket("localhost",8000);
            
            // create an input data stream from the server
            fromServer = new DataInputStream(socket.getInputStream());
            
            // Create output data stream to the server
            toServer = new DataOutputStream(socket.getOutputStream());
            
        }
        catch (IOException ex){
            ta.appendText(ex.toString()+"\n");
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
