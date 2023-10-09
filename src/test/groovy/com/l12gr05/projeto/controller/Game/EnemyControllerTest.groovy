package com.l12gr05.projeto.controller.Game

import com.l12gr05.projeto.Game
import com.l12gr05.projeto.controller.game.EnemyController
import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena
import com.l12gr05.projeto.model.game.elements.Enemy.Monster
import com.l12gr05.projeto.model.game.elements.Wall
import com.l12gr05.projeto.model.sounds.SoundControl
import com.googlecode.lanterna.input.KeyStroke
import com.l12gr05.projeto.model.game.elements.Enemy.Move.NotMovingStrategy
import spock.lang.Specification

class EnemyControllerTest extends Specification{
    private def a1;
    private def a2;
    private def enemyController1
    private def enemyController2
    private def game
    private def key
    private def time
    private def instance

    def setup(){
        a1 = new Arena(34,24,1)
        a2 = new Arena(34,24,6)
        enemyController1 = new EnemyController(a1)
        enemyController2 = new EnemyController(a2)
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        instance = Mock(SoundControl.class)
    }

    def 'test of can move'(){
        given:
        Position p = new Position(112, 3)
        Position p2 = new Position(-12, 3)
        Position p3 = new Position(1, 300)
        Position p4 = new Position(1, -3)
        Position p5 = new Position(112, 312)
        Position p6 = new Position(-112, -3)
        Position w = new Position(0,7 )
        Position m = new Position(8,9 )
        Position k = new Position(3,4 )
        Position p7 = new Position(3, 5)
        Position p8 = new Position(7,0)
        Position p9 = new Position(33, 14)
        Position p10 = new Position(23, 23)
        Position p11 = new Position(0, 0)
        Position p12 = new Position(0, 1)

        expect:
         !enemyController1.canMonsterMove(p)
         !enemyController1.canMonsterMove(p2)
         !enemyController1.canMonsterMove(p3)
         !enemyController1.canMonsterMove(p4)
         !enemyController1.canMonsterMove(p5)
         !enemyController1.canMonsterMove(p6)
         !enemyController1.canMonsterMove(w)
         !enemyController1.canMonsterMove(m)
         !enemyController1.canMonsterMove(k)
          enemyController1.canMonsterMove(p7)
        enemyController1.canMonsterMove(p8)
        enemyController1.canMonsterMove(p9)
        enemyController1.canMonsterMove(p10)
        enemyController1.canMonsterMove(p11)
        !enemyController1.canMonsterMove(p12)
    }

    def 'test Shoot'(){
        expect:
        enemyController1.DirOfShoot(new Position(7,21)) == 'u'
        enemyController1.DirOfShoot(new Position(7, 19)) == 'd'
        enemyController1.DirOfShoot(new Position(6,20)) == 'r'
        enemyController1.DirOfShoot(new Position(8, 20)) == 'l'
        enemyController1.DirOfShoot(new Position(3,3)) == 'n'
        enemyController1.DirOfShoot(new Position(7,20)) == 'r'
        enemyController1.DirOfShoot(new Position(8,20)) == 'l'
    }


    def 'test lastSpawn 200 '(){
        given:
        def time2 = 200
        def i = enemyController2.getModel().getMonsters().size()
        when:
        enemyController2.step(game, key, time2)
        then:
        i == 0
    }

    def 'test lastSpawn 6000 '(){
        given:
        def time2 = 6000
        def i = enemyController2.getModel().getMonsters().size()
        when:
        enemyController2.step(game, key, time2)
        then:
        i == enemyController2.getModel().getMonsters().size()
    }

    def 'test lastSpawn 6001 '(){
        given:
        def time2 = 6001
        def i = enemyController2.getModel().getMonsters().size()
        when:
        enemyController2.step(game, key, time2)
        then:
        i + 2 == enemyController2.getModel().getMonsters().size()
    }

    def 'test lastSpawn + or - '(){
        given:
        def time2 = 5900
        def i = enemyController2.getModel().getMonsters().size()
        enemyController2.lastSpawn(200)
        when:
        enemyController2.step(game, key, time2)
        then:
        i == enemyController2.getModel().getMonsters().size()
    }

    def 'test MovementEnemy 200 '(){
        given:
        def time2 = 200
        def x = enemyController2.getModel().getBoss().getPosition().getX()
        def y = enemyController2.getModel().getBoss().getPosition().getY()
        when:
        enemyController2.step(game, key, time2)
        then:
        x == enemyController2.getModel().getBoss().getPosition().getX()
        y == enemyController2.getModel().getBoss().getPosition().getY()
    }

    def 'test lastSpawn 6000 '(){
        given:
        def time2 = 800
        def x = enemyController2.getModel().getBoss().getPosition().getX()
        def y = enemyController2.getModel().getBoss().getPosition().getY()
        when:
        enemyController2.step(game, key, time2)
        then:
        x == enemyController2.getModel().getBoss().getPosition().getX()
        y == enemyController2.getModel().getBoss().getPosition().getY()
    }

    def 'test lastSpawn 6001 '(){
        given:
        def time2 = 801
        def x = enemyController2.getModel().getBoss().getPosition().getX()
        def y = enemyController2.getModel().getBoss().getPosition().getY()
        when:
        enemyController2.step(game, key, time2)
        then:
        x != enemyController2.getModel().getBoss().getPosition().getX() || y != enemyController2.getModel().getBoss().getPosition().getY()
    }

    def 'test lastSpawn + or - '(){
        given:
        def time2 = 790
        enemyController2.lastMovementBoss(200)
        def p = new Position(enemyController2.getModel().getBoss().getPosition().getX(),enemyController2.getModel().getBoss().getPosition().getY() )

        when:
        enemyController2.step(game, key, time2)
        then:
        p.x == enemyController2.getModel().getBoss().getPosition().getX()
        p.y == enemyController2.getModel().getBoss().getPosition().getY()
    }

    def 'test stepMovementBoss move'(){
        given:
        def x = enemyController2.getModel().getBoss().getPosition().getX()
        def y = enemyController2.getModel().getBoss().getPosition().getY()
        def i = enemyController2.getModel().getBullets().size()

        when:
        enemyController2.stepMovementBoss(200, instance)

        then:
        x != enemyController2.getModel().getBoss().getPosition().getX() || y != enemyController2.getModel().getBoss().getPosition().getY()
        i + 8 == enemyController2.getModel().getBullets().size()
    }

    def 'test stepMovementBoss - energy'(){
        given:
        def x = enemyController2.getModel().getBoss().getPosition().getX()
        def y = enemyController2.getModel().getBoss().getPosition().getY()
        def i = enemyController2.getModel().getBullets().size()
        enemyController2.getModel().getHero().setPosition(new Position(18,12))
        def energy = enemyController2.getModel().getHero().getEnergy()

        when:
        enemyController2.stepMovementBoss(200, instance)

        then:
        i + 8 == enemyController2.getModel().getBullets().size()
        energy - 7 == enemyController2.getModel().getHero().getEnergy()
        1 * instance.stop(_)
        1 * instance.start(_)
    }

    def 'test stepMovementBoss - enegry < or <='(){
        given:
        def x = enemyController2.getModel().getBoss().getPosition().getX()
        def y = enemyController2.getModel().getBoss().getPosition().getY()
        def i = enemyController2.getModel().getBullets().size()
        enemyController2.getModel().getHero().setPosition(new Position(15,12))
        def energy = enemyController2.getModel().getHero().getEnergy()

        when:
        enemyController2.stepMovementBoss(200, instance)

        then:
        i + 8 == enemyController2.getModel().getBullets().size()
        energy == enemyController2.getModel().getHero().getEnergy()
    }

    def 'test MovementEnemy 200 '(){
        given:
        def time2 = 200
        def x = enemyController1.getModel().getKings().get(0).getPosition().getX()
        def y = enemyController1.getModel().getKings().get(0).getPosition().getY()
        when:
        enemyController1.step(game, key, time2)
        then:
        x == enemyController1.getModel().getKings().get(0).getPosition().getX()
        y == enemyController1.getModel().getKings().get(0).getPosition().getY()
    }

    def 'test MovementEnemy 6000 '(){
        given:
        def time2 = 6000
        def x = enemyController1.getModel().getKings().get(0).getPosition().getX()
        def y = enemyController1.getModel().getKings().get(0).getPosition().getY()
        when:
        enemyController1.step(game, key, time2)
        then:
        x != enemyController1.getModel().getKings().get(0).getPosition().getX() || y != enemyController1.getModel().getKings().get(0).getPosition().getY()
    }

    def 'test MovementEnemy 500 '(){
        given:
        def time2 = 500
        def x = enemyController1.getModel().getKings().get(0).getPosition().getX()
        def y = enemyController1.getModel().getKings().get(0).getPosition().getY()
        when:
        enemyController1.step(game, key, time2)
        then:
        x == enemyController1.getModel().getKings().get(0).getPosition().getX()
        y == enemyController1.getModel().getKings().get(0).getPosition().getY()
    }

    def 'test MovementEnemy + or - '(){
        given:
        def time2 = 490
        def x = enemyController1.getModel().getKings().get(0).getPosition().getX()
        def y = enemyController1.getModel().getKings().get(0).getPosition().getY()
        enemyController1.lastMovementEnemy(200)
        when:
        enemyController1.step(game, key, time2)
        then:
        x == enemyController1.getModel().getKings().get(0).getPosition().getX()
        y == enemyController1.getModel().getKings().get(0).getPosition().getY()
    }

    def 'test stepMovementEnemy'(){
        given:
        game.getScore() >> 200

        when:
        enemyController1.stepMovementEnemy(game, instance)

        then:
        enemyController1.getModel().getScore() == 200
    }

    def 'test stepMovementEnemy for monster'(){
        given:
        game.getScore() >> 200
        def monster = Mock(Monster.class)
        def listOfMonsters = new ArrayList();
        listOfMonsters.add(monster)
        monster.move(_, _) >>> [ new Position(0,7), new Position(10,10)]
        monster.getPosition() >>> [new Position(7,7), new Position(10,10), new Position(10,10)]


        enemyController1.getModel().setMonsters(listOfMonsters)
        enemyController1.getModel().getHero().setPosition(new Position(10,10))
        def N_of_bullts = enemyController1.getModel().getBullets().size()

        when:
        enemyController1.stepMovementEnemy(game, instance)

        then:
        enemyController1.getModel().getScore() == 200
        enemyController1.getModel().getMonsters().get(0).getPosition().getX() == 10
        enemyController1.getModel().getHero().getEnergy() == 12
        N_of_bullts + 1 == enemyController1.getModel().getBullets().size()
        2 * instance.stop(_)
        2 * instance.start(_)
        1 * monster.setPosition(_ as Position)
    }

    def 'test stepMovementEnemy for kings'(){
        given:
        game.getScore() >> 200
        enemyController1.getModel().getHero().setPosition(new Position(3,3))

        when:
        enemyController1.stepMovementEnemy(game, instance)

        then:
        enemyController1.getModel().getHero().getEnergy() == 10
        enemyController1.getModel().getScore() == 200
        1 * instance.stop(_)
        1 * instance.start(_)
    }

    def 'test stepMovementEnemy for kings 2nd'(){
        given:
        game.getScore() >> 200
        enemyController1.getModel().getHero().setPosition(new Position(6,6))

        when:
        enemyController1.stepMovementEnemy(game, instance)

        then:
        enemyController1.getModel().getHero().getEnergy() == 15
        enemyController1.getModel().getScore() == 200
        enemyController1.getModel().getKings().get(1).getMoveStrategy() instanceof NotMovingStrategy
    }
}
