package com.l12gr05.projeto.viewer.menuViewer


import com.l12gr05.projeto.graphics.GUILaterna
import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.menu.Leaderboard
import spock.lang.Specification

class LeaderboardViewerTest extends Specification {
    private def gui
    private def position

    void setup() {
        gui = Mock(GUILaterna.class)
        position = Mock(Position.class)
    }

    def 'LeaderBoard Text Draw'() {
        given:
        def leader_viewer = new LeaderboardViewer(new Leaderboard())
        def gui = Mock(GUILaterna.class)
        int n_of_players = 2+(2*(leader_viewer.getModel().getNumberOfplayers()))
        if(n_of_players > 22) {
            n_of_players = 22
        }

        when:
        leader_viewer.drawElements(gui)

        then:
        1 * gui.drawText(new Position(5, 7), _, "#FFFFFF")
        1 * gui.drawText(new Position(5, 8), _, "#FFFFFF")
        (n_of_players - 2) * gui.drawText(_,_,_)

    }
}
