package com.l12gr05.projeto.viewer.gameViewer


import com.l12gr05.projeto.graphics.GUILaterna
import com.l12gr05.projeto.model.game.elements.Wall
import spock.lang.Specification

class WallViewerTest extends Specification {
    private def gui
    private def wall


    void setup() {
        wall = Mock(Wall.class)
        gui = Mock(GUILaterna.class)
    }

    def 'Wall Draw' () {
        given:
        def wall_viewer = new WallViewer()

        when:
        wall_viewer.draw(wall, gui)

        then:
        1 * gui.drawWall(wall.getPosition())
    }
}
