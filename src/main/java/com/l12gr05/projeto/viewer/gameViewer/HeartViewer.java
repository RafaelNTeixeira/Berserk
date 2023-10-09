package com.l12gr05.projeto.viewer.gameViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Health;

public class HeartViewer implements ElementViewer<Health> {
    @Override
    public void draw(Health health, GUI gui) {
        Position heroPosition = health.getPosition();
        gui.drawHeart(heroPosition);
    }
}
