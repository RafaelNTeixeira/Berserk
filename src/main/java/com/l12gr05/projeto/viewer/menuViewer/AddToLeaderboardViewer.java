package com.l12gr05.projeto.viewer.menuViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.menu.AddToLeaderboard;

public class AddToLeaderboardViewer extends Viewer<AddToLeaderboard> {
    public AddToLeaderboardViewer(AddToLeaderboard lose) {
        super(lose);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5,12 ), "enter your name:", "#FFFFFF");
        gui.drawText(new Position(5, 10), "your Score: " + getModel().getScore(), "#FFFFFF");
        String name = getModel().getName();
        gui.drawText(new Position(22, 12), name, "#FFFFFF");
    }
}
