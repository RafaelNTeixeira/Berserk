package com.l12gr05.projeto.state


import com.l12gr05.projeto.viewer.menuViewer.LeaderboardViewer
import com.l12gr05.projeto.controller.menu.LeaderboardController
import com.l12gr05.projeto.model.menu.Leaderboard
import spock.lang.Specification

class LeaderboardBoardStateTest extends Specification{

    private def leaderBoard

    def setup() {
        leaderBoard = new Leaderboard()
    }

    def 'Get Viewer'() {
        given:
        LeaderBoardState leaderBoardState = new LeaderBoardState(leaderBoard)
        LeaderboardViewer viewer = new LeaderboardViewer(leaderBoard)

        when:
        LeaderboardViewer leaderViewer = leaderBoardState.getViewer()
        int x = leaderViewer.getModel().getNumberOfplayers()

        then:
        x == viewer.getModel().getNumberOfplayers()
    }

    def 'Get Controller'() {
        given:
        LeaderBoardState leaderBoardState = new LeaderBoardState(leaderBoard)
        LeaderboardController controller = new LeaderboardController(leaderBoard)

        when:
        LeaderboardController leaderController = leaderBoardState.getController()

        then:
        leaderController instanceof LeaderboardController
    }
}
