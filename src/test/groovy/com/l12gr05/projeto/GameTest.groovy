package com.l12gr05.projeto


import com.l12gr05.projeto.state.GameState
import com.l12gr05.projeto.state.LoseState
import com.l12gr05.projeto.state.MenuState
import com.l12gr05.projeto.state.State
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena
import com.l12gr05.projeto.model.menu.Lose
import spock.lang.Specification

class GameTest extends Specification{


    def 'Game creation'() {
        when:
        Game game = new Game()

        then:
        game.getState() instanceof MenuState
    }

    def 'Changing states'() {
        given:
        Game game = new Game()
        Lose lose = new Lose(10)
        Arena aa = Mock(Arena.class)
        GameState gameState = new GameState(aa)
        LoseState loseState = new LoseState(lose)

        when:
        game.setState(gameState)
        State s = game.getState()
        game.setOldState(loseState)
        State o = game.getOldState()

        then:
        s instanceof GameState
        o instanceof LoseState
        lose.getScore() == 10
    }

    def 'Set, get and increment score'() {
        given:
        Game game = new Game()
        int score;
        int incremented_score;


        when:
        game.setScore(10)
        score = game.getScore()
        game.changeScoreBy(1)
        incremented_score = game.getScore()

        then:
        score == 10
        incremented_score == 11
    }

}
