package com.l12gr05.projeto.viewer.menuViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.menu.Leaderboard;

public class LeaderboardViewer extends Viewer<Leaderboard> {
    public LeaderboardViewer(Leaderboard lose) {
        super(lose);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(10, 4), "leader board", "#FFFFFF");

        int numberPlayers = getModel().getNumberOfplayers();
        for (int i = 0; i < 10 && i < numberPlayers ; i++) {
            String name = getModel().getPlayers().get(i).getName();
            String score = getModel().getPlayers().get(i).getScore();

            int y = 7+i;
            gui.drawText(new Position(5, y), name, "#FFFFFF");
            gui.drawText(new Position(25 , y ), score, "#FFFFFF");
        }
        gui.drawText(new Position(6, 22), "press enter to get menu", "#FFD700");

    }
}


