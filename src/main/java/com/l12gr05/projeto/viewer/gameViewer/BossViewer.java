package com.l12gr05.projeto.viewer.gameViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Enemy.Boss;

public class BossViewer implements ElementViewer<Boss> {
    @Override
    public void draw(Boss boss, GUI gui) {
        Position bossPosition = boss.getPosition();
        gui.drawBoss(bossPosition);
    }
}