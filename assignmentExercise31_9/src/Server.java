/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.*;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author kp0885055
 */
public class Server extends Application {
    DataOutputStream toClient = null;
    DataInputStream fromClient = null;

    @Override
    public void start(Stage pStage) {
        
        
        BorderPane paneForMsgField = new BorderPane();
        paneForMsgField.setPadding(new Insets(5,5,5,5));
        paneForMsgField.setStyle("-fx-border-color: green");
        paneForMsgField.setLeft(new Label("enter a message: "));
        
        TextField mF = new TextField();
        mF.setAlignment(Pos.BOTTOM_RIGHT);
        paneForMsgField.setCenter(mF);
        
        
        
        BorderPane mainPane = new BorderPane();
         TextArea mA = new TextArea();
        mainPane.setCenter(new ScrollPane(mA));
        mainPane.setTop(paneForMsgField);
        
        
       Scene scene = new Scene(mainPane,450,200);
        pStage.setTitle("Server");
        pStage.setScene(scene);
        pStage.show();

        new Thread(() -> {
            try {
                // CREATE SERVER SOCKET
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(()
                        -> mA.appendText("Messages started at " + new Date() + "\n"));

                // LISTEN FOR CONNNECTION REQUEST
                Socket socket = serverSocket.accept();

                // CREATE data input / output streams
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    // recieve a radius from client
                    String text = inputFromClient.readUTF();

                    // comput area

                    outputToClient.writeUTF(text);

                    Platform.runLater(() -> {
                        mA.appendText("Person > " + text + "\n");
                    }); // END of run later
                }       // end of while
            }           // end of try
            catch (IOException ex){
                ex.printStackTrace();
            }
        }).start();
        
        mF.setOnAction(e -> {
            try{
                // Get radius from text field
                String text = (mF.getText().trim());
                // Send to server
                toClient.writeUTF(text);
                toClient.flush();
                
                // get Area from the server
                String msg = fromClient.readUTF();
                // Display to text area
                mA.appendText("Person > "+msg+"\n");
            }
            catch(IOException ex){
                System.err.println(ex);
            }
        });
        
        
    }                   // End of start method

    public static void main(String[] args) {
    launch(args);
    }

}
