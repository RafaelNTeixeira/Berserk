package com.l12gr05.projeto.state

import com.l12gr05.projeto.Game
import com.l12gr05.projeto.graphics.GUILaterna
import com.l12gr05.projeto.viewer.menuViewer.AddToLeaderboardViewer
import com.l12gr05.projeto.controller.menu.AddToLeaderboardController
import com.l12gr05.projeto.model.menu.AddToLeaderboard
import spock.lang.Specification

class AddLeaderboardStateTest extends Specification{
    private def addLeader

    def setup() {
        addLeader = new AddToLeaderboard(10)
    }

    def 'Get Viewer'(){
        given:
        AddToLeaderboardState leaderState = new AddToLeaderboardState(addLeader)
        AddToLeaderboardViewer viewer = new AddToLeaderboardViewer(addLeader)

        when:
        AddToLeaderboardViewer leaderViewer = leaderState.getViewer()
        int x = leaderViewer.getModel().getNumberEntries()

        then:
        x == viewer.getModel().getNumberEntries()
    }

    def 'Get controller'() {
        given:
        AddToLeaderboardState leaderState = new AddToLeaderboardState(addLeader)
        AddToLeaderboardController leaderController = leaderState.getController()

        when:
        int x = leaderController.getModel().getNumberEntries()

        then:
        x == 2

    }

    def 'Get controller 2'() {
        given:
        def addLeader = Mock(AddToLeaderboard.class)
        def Lstate = new AddToLeaderboardState(addLeader)

        when:
        def x = Lstate.getController()

        then:
        x instanceof AddToLeaderboardController

    }

    def 'Sate test'() {
        given:
        def addLeader = Mock(AddToLeaderboard.class)
        def v = Mock(AddToLeaderboardViewer.class)
        def c = Mock(AddToLeaderboardController.class)
        def game = Mock(Game.class)
        def gui = Mock(GUILaterna.class)
        def time = 5000
        def Lstate = new AddToLeaderboardState(addLeader)
        Lstate.setViewer(v)
        Lstate.setController(c)

        when:
        Lstate.step(game, gui, time)

        then:
        1 * gui.getNextAction();
        1 * c.step(game, _, time)
        1 * v.draw(gui)
    }
}
