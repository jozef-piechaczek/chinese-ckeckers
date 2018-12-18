package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import models.client_server.Connection;

/**
 * Kontroler dla okna Menu.
 */
public class MenuController {
    @FXML
    TextField textfieldAddress;
    @FXML
    public void menuExit() {
        System.exit(0);
    }
    @FXML
    public void menuNewGame() {
        if(Connection.establishConnection(textfieldAddress.getText())) {
            System.out.println("connection established");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Could not resolve hostname. Try again!");
            alert.showAndWait();
        }
        Connection.sendConnect();
        Connection.startConnectionLoop();
    }
}
