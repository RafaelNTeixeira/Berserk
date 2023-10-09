package com.l12gr05.projeto.viewer.gameViewer


import com.l12gr05.projeto.graphics.GUILaterna
import com.l12gr05.projeto.model.game.elements.Bullet
import spock.lang.Specification

class BulletViewerTest extends Specification{

    private def gui

    def 'Draw hero bullet'() {
        given:
        boolean t = true

        Bullet hero_bullet = new Bullet(10, 10, 'r' as char, t)

        gui = Mock(GUILaterna.class)
        BulletViewer bulletViewer = new BulletViewer()

        when:
        bulletViewer.draw(hero_bullet, gui)


        then:
        1*gui.drawHeroBullet(_)


    }

    def 'Draw enemy bullet'() {
        given:

        boolean f = false

        Bullet enemy_bullet = new Bullet(10, 10, 'l' as char, f)
        gui = Mock(GUILaterna.class)
        BulletViewer bulletViewer = new BulletViewer()

        when:

        bulletViewer.draw(enemy_bullet, gui)

        then:

        1*gui.drawEnemyBullet(_)

    }
}
