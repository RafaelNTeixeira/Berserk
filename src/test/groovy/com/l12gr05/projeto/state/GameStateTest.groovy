package com.l12gr05.projeto.state


import com.l12gr05.projeto.controller.game.ArenaController
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena
import com.l12gr05.projeto.viewer.gameViewer.GameViewer
import spock.lang.Specification

class GameStateTest extends Specification{

    private def arena

    def setup() {
        arena = new Arena(50, 50, 1)
    }

    def 'Get Viewer'(){
        given:
        GameState gameState = new GameState(arena)
        GameViewer gameViewer = gameState.getViewer()

        when:
        int height = gameViewer.getModel().getHeight()
        int width = gameViewer.getModel().getWidth()

        then:
        height == 50
        width == 50

    }

    def 'Get controller'() {
        given:
        GameState gameState = new GameState(arena)
        ArenaController arenaController = gameState.getController()

        when:
        int height = arenaController.getModel().getHeight()
        int width = arenaController.getModel().getWidth()

        then:
        height == 50
        width == 50

    }
}
