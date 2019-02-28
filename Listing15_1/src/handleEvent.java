
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class handleEvent extends Application{
    @Override
    public void start(Stage pStage){
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        
        
        Button btOK = new Button("OK");
        OkHandlerClass handleOk = new OkHandlerClass();
        btOK.setOnAction(handleOk);
        
        
        Button btCancel = new Button("Cancel");
        CancelHandlerClass handleCancel = new CancelHandlerClass();
        btCancel.setOnAction(handleCancel);
        
        
        pane.getChildren().addAll(btOK,btCancel);
        
        Scene scene = new Scene(pane);
        
        pStage.setTitle("Handle Event");
        pStage.setScene(scene);
        pStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}


class OkHandlerClass implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        System.out.println("OK BUTTON CLICKED");
    } // End of handle
}   // End of OKHandler class


class CancelHandlerClass implements EventHandler<ActionEvent> {
    @Override 
    public void handle(ActionEvent e){
        System.out.println("Cancel Button Clicked");
    } // end of handle
}   //end of cancel handler class