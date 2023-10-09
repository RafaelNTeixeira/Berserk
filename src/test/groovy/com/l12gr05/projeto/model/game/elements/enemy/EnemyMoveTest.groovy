package com.l12gr05.projeto.model.game.elements.enemy

import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.game.elements.Enemy.Monster
import com.l12gr05.projeto.model.game.elements.Enemy.Move.MonsterMoveStrategy
import spock.lang.Specification

class EnemyMoveTest extends Specification{
    def 'test random'(){
        given:
        def random = Mock(Random.class);
        def monsterStrategy = new MonsterMoveStrategy();
        random.nextInt(_) >> 2;
        random.nextInt(_) >> 2
        when:
        def pos = monsterStrategy.getPositionFromRandom(random, new Position(10,10));
        then:
        pos.getX() == 11;
        pos.getY() == 11;
    }
}
