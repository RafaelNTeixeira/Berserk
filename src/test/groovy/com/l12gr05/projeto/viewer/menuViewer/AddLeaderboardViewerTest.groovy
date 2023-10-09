package com.l12gr05.projeto.viewer.menuViewer


import com.l12gr05.projeto.graphics.GUILaterna
import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.menu.AddToLeaderboard
import spock.lang.Specification

class AddLeaderboardViewerTest extends Specification {
    private def gui
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        position = Mock(Position.class)
    }

    def 'Add to LeaderBoard Text Draw'() {
        given:
        def add_leader_viewer = new AddToLeaderboardViewer(new AddToLeaderboard(10))
        def gui = Mock(GUILaterna.class)

        when:
        add_leader_viewer.drawElements(gui)

        then:
        3 * gui.drawText(_,_,_)
    }

    def 'Add to LeaderBoard Text Draw'() {
        given:
        def add_leader_viewer = new AddToLeaderboardViewer(new AddToLeaderboard(10))
        def gui = Mock(GUILaterna.class)

        when:
        add_leader_viewer.draw(gui)

        then:
        3 * gui.drawText(_,_,_)
        1 * gui.clear();
        1 * gui.refresh();
    }
}
