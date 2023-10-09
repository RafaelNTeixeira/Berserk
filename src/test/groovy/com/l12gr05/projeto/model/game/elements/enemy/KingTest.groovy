package com.l12gr05.projeto.model.game.elements.enemy

import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.game.elements.Enemy.King
import com.l12gr05.projeto.model.game.elements.Enemy.Move.MoveStrategy
import com.l12gr05.projeto.model.game.elements.Enemy.Move.NotMovingStrategy
import spock.lang.Specification

class KingTest extends Specification{

    def 'Constructor'() {
        given:
        King king = new King(10, 10)
        Position pos = new Position(10, 10)

        when:
        Position pos1 = king.getPosition()

        then:
        pos == pos1
    }

    def 'Move Strategy'() {
        given:
        King king = new King(10, 10)

        when:
        MoveStrategy moveStrategy = king.generateMoveStrategy()

        then:
        moveStrategy.getClass() == new NotMovingStrategy().getClass()
    }

    def 'Generate energy'(){
        given:
        King king = new King(10, 10)

        when:
        int x = king.generateEnergy()

        then:
        x == 2
    }
}
