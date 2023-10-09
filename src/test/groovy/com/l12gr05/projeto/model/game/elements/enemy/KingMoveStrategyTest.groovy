package com.l12gr05.projeto.model.game.elements.enemy

import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.game.PositionTest
import com.l12gr05.projeto.model.game.elements.Enemy.Move.KingMoveStrategy
import spock.lang.Specification

class KingMoveStrategyTest extends Specification{
    def 'test can Move'(){
        given:
        def k = new KingMoveStrategy();
        expect:
        k.canMove(new Position(0,1))
        k.canMove(new Position(1,0))
        k.canMove(new Position(33,1))
        k.canMove(new Position(1,23))
    }

    def 'test contains'(){
        given:
        def k = new KingMoveStrategy();
        boolean[][]  m = new boolean[2][2];
        m[0][0] = true;
        m[1][0] = true;
        m[0][1] = false;
        m[1][1] = false;
        expect:
        !k.contains(m,new Position(1,1))
        k.contains(m,new Position(0,0))
    }

    def 'test contains'(){
        given:
        def k = new KingMoveStrategy();
        boolean[][]  m = new boolean[35][27];
        m[2][1] = true;
        m[2][3] = true;
        m[1][2]= true;
        m[3][2]= true;
        m[1][3]= true;
        m[3][1]= true;
        m[3][3] = true;
        m[1][1] = true;
        when:
        Position pos = k.move(new Position(2,2,), new Position(10,1), m)
        then:
        pos.getX() == 2
        pos.getY() == 2
    }
}
