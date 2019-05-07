
//IMPORTS
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

public class Client extends Application {

    //IO strings
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    @Override
    public void start(Stage pStage) {
        BorderPane paneForMsgField = new BorderPane();
        paneForMsgField.setPadding(new Insets(5, 5, 5, 5));
        paneForMsgField.setStyle("-fx-border-color: green");
        paneForMsgField.setLeft(new Label("enter a message: "));

        TextField mF = new TextField();
        mF.setAlignment(Pos.BOTTOM_RIGHT);
        paneForMsgField.setCenter(mF);

        BorderPane mainPane = new BorderPane();
        // TEXT area to display contents
        TextArea mA = new TextArea();
        mainPane.setCenter(new ScrollPane(mA));
        mainPane.setTop(paneForMsgField);

        // Create our scene
        Scene scene = new Scene(mainPane, 450, 200);
        pStage.setTitle("Client");
        pStage.setScene(scene);
        pStage.show();

        mF.setOnAction(e -> {
            try {
                // Get radius from text field
                String text = (mF.getText().trim());
                // Send to server
                toServer.writeUTF(text);
                toServer.flush();

                // get Area from the server
                String msg = fromServer.readUTF();
                // Display to text area
                mA.appendText("Person > " + msg + "\n");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });

        try {
            // create a socket ot connect ot server
            Socket socket = new Socket("localhost", 8000);

            // create an input data stream from the server
            fromServer = new DataInputStream(socket.getInputStream());

            // Create output data stream to the server
            toServer = new DataOutputStream(socket.getOutputStream());

        } catch (IOException ex) {
            mA.appendText(ex.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
