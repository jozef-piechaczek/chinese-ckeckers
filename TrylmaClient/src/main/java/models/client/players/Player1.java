package models.client.players;

import javafx.scene.paint.*;
import models.client.FieldGenerator;
import views.BoardViewManager;

public class Player1 extends Player{
    Player1(boolean isThisMe, double radius, int ch, double wGap, double hGap) {
        this.setID(1);
        this.generateFields(isThisMe, radius, ch, wGap, hGap);
        this.addPlayerHandlers();
    }
    @Override
    public void generateFields(boolean isThisMe, double radius, int ch, double wGap, double hGap) {
        Paint color = new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#ffb4a5")), new Stop(1, Color.web("#ab0000")));
        if (isThisMe) BoardViewManager.setMyColor(color);
        this.setCircleFieldList(FieldGenerator.generateFields(true, false, ch, -2*ch, -ch, -ch, ch, radius, wGap, hGap, color));
    }
}
