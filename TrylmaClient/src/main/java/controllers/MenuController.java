package controllers;

import javafx.fxml.FXML;
import models.client_server.Connection;
import views.BoardView;

import java.io.IOException;

/**
 * Kontroler dla okna Menu.
 */
public class MenuController {
    @FXML
    public void menuExit() {
        System.exit(0);
    }
    @FXML
    public void menuNewGame() {
            Connection.commandInterpreter("newgame");
    }
    @FXML
    public void handleNewGame() {
        BoardView.initialize(600, 4, 1, 0);
        BoardView.show();
        BoardView.initializeFields();
    }
}
