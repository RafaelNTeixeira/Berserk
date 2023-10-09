package com.l12gr05.projeto.viewer.menuViewer


import com.l12gr05.projeto.graphics.GUILaterna
import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.menu.Lose
import spock.lang.Specification

class LoseViewerTest extends Specification {
    private def gui
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        position = Mock(Position.class)
    }

    def 'You Lose Text Draw'() {
        given:
        def lose_viewer = new LoseViewer(new Lose(10))
        def gui = Mock(GUILaterna.class)

        when:
        lose_viewer.drawElements(gui)

        then:
        1 * gui.drawText(new Position(14,14),_,"#FFD700")
        1 * gui.drawText(new Position(11,10),_,"#FFFFFF")
        1 * gui.drawText(new Position(10,15),_,"#FFFFFF")
        1 * gui.drawText(new Position(6,16),_,"#FFFFFF")
        1 * gui.drawText(new Position(12,9),_,"#ff0000")
    }
}
