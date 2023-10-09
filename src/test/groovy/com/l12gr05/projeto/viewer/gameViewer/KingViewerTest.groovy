package com.l12gr05.projeto.viewer.gameViewer


import com.l12gr05.projeto.graphics.GUILaterna
import com.l12gr05.projeto.model.game.elements.Enemy.King
import spock.lang.Specification

class KingViewerTest extends Specification {
    private def gui
    private def king

    void setup() {
        king = Mock(King.class)
        gui = Mock(GUILaterna.class)
    }

    def 'King Draw'() {
        given:
        KingViewer king_viewer = new KingViewer()

        when:
        king_viewer.draw(king, gui)

        then:
        1 * gui.drawKing(king.getPosition())

    }
}
