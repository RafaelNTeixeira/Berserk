package com.l12gr05.projeto.viewer.gameViewer


import com.l12gr05.projeto.graphics.GUILaterna
import com.l12gr05.projeto.model.game.elements.Enemy.Boss
import spock.lang.Specification

class BossViewerTest extends Specification{
    private def gui
    private def boss

    void setup() {
        boss = Mock(Boss.class)
        gui = Mock(GUILaterna.class)
    }

    def 'Boss Draw'() {
        given:
        BossViewer bossViewer = new BossViewer()

        when:
        bossViewer.draw(boss, gui)

        then:
        1 * gui.drawBoss(boss.getPosition())

    }
}
