package com.l12gr05.projeto.viewer.gameViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Enemy.King;

public class KingViewer implements ElementViewer<King> {
    @Override
    public void draw(King king, GUI gui) {
        Position kingPosition = king.getPosition();
        gui.drawKing(kingPosition);
    }
}
