package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    @FXML
    public TextArea winChat;
    @FXML
    public TextField inputSend;



    @FXML
    public void onSendText(ActionEvent actionEvent) {
        winChat.appendText(inputSend.getText() + "\n");
        inputSend.requestFocus();
        inputSend.clear();
    }

    @FXML
    public void onCloseMenu( ActionEvent actionEvent ) {
        Platform.runLater(()->{
            Stage stage = (Stage)winChat.getScene().getWindow();
            stage.close();
        });
    }

    @FXML
    public void onClearMenu( ActionEvent actionEvent ) {
        winChat.clear();
    }

    @FXML
    public void onSaveLog() {
        try(FileWriter writer = new FileWriter("log_chat.txt", false))
        {
            writer.write(winChat.getText());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
