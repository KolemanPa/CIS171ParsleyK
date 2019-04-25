/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author kp0885055
 */
public class Server extends Application {

    @Override
    public void start(Stage pStage) {
        TextArea ta = new TextArea();
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        pStage.setTitle("Server");
        pStage.setScene(scene);
        pStage.show();

        new Thread(() -> {
            try {
                // CREATE SERVER SOCKET
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(()
                        -> ta.appendText("Server started at " + new Date() + "\n"));

                // LISTEN FOR CONNNECTION REQUEST
                Socket socket = serverSocket.accept();

                // CREATE data input / output streams
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    // recieve a radius from client
                    double radius = inputFromClient.readDouble();

                    // comput area
                    double area = radius * radius * Math.PI;

                    outputToClient.writeDouble(area);

                    Platform.runLater(() -> {
                        ta.appendText("Radius Recieved from client: " + radius + "\n");
                        ta.appendText("Area is: " + area + "\n");
                    }); // END of run later
                }       // end of while
            }           // end of try
            catch (IOException ex){
                ex.printStackTrace();
            }
        }).start();
    }                   // End of start method

    public static void main(String[] args) {
    launch(args);
    }

}
