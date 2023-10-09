package com.l12gr05.projeto.viewer.menuViewer


import com.l12gr05.projeto.graphics.GUILaterna
import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.menu.Menu
import spock.lang.Specification

class MenuViewerTest extends Specification {
    private def gui
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        position = Mock(Position.class)
    }

    def 'Menu Text Draw'() {
        given:
        def menu_viewer = new MenuViewer(new Menu())

        when:
        menu_viewer.drawElements(gui)

        then:
        1 * gui.drawText(new Position(12, 9), "menu", "#FFFFFF")
        1 * gui.drawText(new Position(12, 12),_, "#FFD700")
        1 * gui.drawText(new Position(12, 13),_, "#FFFFFF")
        1 * gui.drawText(new Position(12, 14),_, "#FFFFFF")
        1 * gui.drawText(new Position(12, 15),_, "#FFFFFF")
    }
}
