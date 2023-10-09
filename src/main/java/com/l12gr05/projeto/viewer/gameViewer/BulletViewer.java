package com.l12gr05.projeto.viewer.gameViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Bullet;

public class BulletViewer implements ElementViewer<Bullet> {
    @Override
    public void draw(Bullet bullet, GUI gui) {
        boolean heroBullet = bullet.isHeroBullet();
        Position bulletPosition = bullet.getPosition();
        if (heroBullet) {
            gui.drawHeroBullet(bulletPosition);
        }
        else {
            gui.drawEnemyBullet(bulletPosition);
        }
    }
}
