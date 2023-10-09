package com.l12gr05.projeto.viewer.gameViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        Position wallPosition = wall.getPosition();
        gui.drawWall(wallPosition);
    }
}

