package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import models.client_server.Connection;

@SuppressWarnings("Duplicates")
public class NewGameController {
    @FXML
    Slider playerSlider, botSlider;
    @FXML
    public void handleCreateNewGame() {
        int bots = (int)botSlider.getValue();
        int players = (int)playerSlider.getValue();
        if (players==5 || bots>players) {
            System.out.println("Wrong values"); //TODO: make user friendly
        }
        else {
            Connection.sendCreateNewGameCommand(players, bots);
        }
    }
}