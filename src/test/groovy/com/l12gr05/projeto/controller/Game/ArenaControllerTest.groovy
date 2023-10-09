package com.l12gr05.projeto.controller.Game

import com.l12gr05.projeto.Game
import com.l12gr05.projeto.controller.game.ArenaController
import com.l12gr05.projeto.controller.game.BulletController
import com.l12gr05.projeto.controller.game.EnemyController
import com.l12gr05.projeto.controller.game.HeroController
import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena
import com.l12gr05.projeto.model.game.elements.Enemy.King
import com.l12gr05.projeto.model.game.elements.Enemy.Monster
import com.l12gr05.projeto.model.game.elements.Hero
import com.l12gr05.projeto.model.game.elements.Wall
import com.l12gr05.projeto.model.sounds.SoundControl
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.l12gr05.projeto.model.game.elements.Bullet
import spock.lang.Specification

class ArenaControllerTest extends Specification{
    private def arena
    private def Acontrol
    private def game
    private def key
    private def time
    private def arenaController
    private def e_c
    private def h_c
    private def b_c
    private def instance
    private def hero
    private def pos


    def setup(){
        arena = Mock(Arena.class)
        Acontrol = new ArenaController(arena)
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        arenaController = new ArenaController(new Arena(34,24,1))
        e_c = Mock(EnemyController.class)
        h_c  = Mock(HeroController.class)
        b_c = Mock(BulletController.class)
        instance = Mock(SoundControl.class)
        hero = Mock(Hero.class)
        pos = Mock(Position.class)
    }

    def 'test ShootSound'(){
        when:
        Acontrol.ShootSound(instance)
        then:
        1 * instance.stop(_)
        1 * instance.start(_)
    }

    def 'test steplastBullet r'(){
        given:

        key.getKeyType() >> KeyType.ArrowRight
        arena.getHero() >> hero
        hero.getPosition() >> pos

        when:
        Acontrol.steplastBullet(key, instance)

        then:
        1 * arena.shoot(_,_,_)
        1 * instance.start(_)
    }

    def 'test steplastBullet l'(){
        given:
        key.getKeyType() >> KeyType.ArrowLeft
        arena.getHero() >> hero
        hero.getPosition() >> pos

        when:
        Acontrol.steplastBullet(key, instance)

        then:
        1 * arena.shoot(_,_,_)
        1 * instance.start(_)
    }

    def 'test steplastBullet d'(){
        given:
        def hero = Mock(Hero.class)
        def pos = Mock(Position.class)
        key.getKeyType() >> KeyType.ArrowDown
        arena.getHero() >> hero
        hero.getPosition() >> pos

        when:
        Acontrol.steplastBullet(key, instance)

        then:
        1 * arena.shoot(_,_,_)
        1 * instance.start(_)
    }

    def 'test steplastBullet u'(){
        given:
        def hero = Mock(Hero.class)
        def pos = Mock(Position.class)
        key.getKeyType() >> KeyType.ArrowUp
        arena.getHero() >> hero
        hero.getPosition() >> pos

        when:
        Acontrol.steplastBullet(key, instance)

        then:
        1 * arena.shoot(_,_,_)
        1 * instance.start(_)
    }

    def 'test step QUIT'(){
        given:
        key.getKeyType() >> KeyType.Character ;
        key.getCharacter() >> 'q';

        when:
        Acontrol.stepNonVoid(game, key, time, instance)

        then:
        1 * instance.stop(_)
        1 * instance.start(_)
        1 * game.setState(_)
    }

    def 'test step EXIT'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e';
        Acontrol.getModel() >> arena
        arena.getHero() >> hero
        hero.getEnergy() >> 10

        when:
        Acontrol.stepNonVoid(game, key, time, instance)

        then:
        1 * game.setState(_)
    }

    def 'test step energy = 0'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'x';
        Acontrol.getModel() >> arena
        arena.getHero() >> hero

        hero.getEnergy() >> 0

        when:
        Acontrol.stepNonVoid(game, key, time, instance)

        then:
        1 * instance.stop(_)
        2 * instance.start(_)
        1 * game.setState(_)
    }

    def 'test step energy < 0'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'x';
        Acontrol.getModel() >> arena
        arena.getHero() >> hero
        hero.getEnergy() >> -5

        when:
        Acontrol.stepNonVoid(game, key, time, instance)

        then:
        1 * instance.stop(_)
        2 * instance.start(_)
        1 * game.setState(_)
    }

    def 'test step Escape'(){
        given:
        key.getKeyType() >> KeyType.Escape ;
        Acontrol.getModel() >> arena
        arena.getHero() >> hero
        hero.getEnergy() >> 6

        when:
        Acontrol.stepNonVoid(game, key, time, instance)

        then:
        1 * instance.stopAll()
        1 * instance.start(_)
        1 * game.setState(_)
        1 * game.setOldState(_)
    }

    def 'check Next LVL'(){
        expect: 'Should return flag to next lvl'
        Acontrol.checkNextLvl(new Position(34,10))
        Acontrol.checkNextLvl(new Position(10,25))
        Acontrol.checkNextLvl(new Position(34,25))
        !Acontrol.checkNextLvl(new Position(33,10))
        !Acontrol.checkNextLvl(new Position(23,23))
        !Acontrol.checkNextLvl(new Position(10,22))
        !Acontrol.checkNextLvl(new Position(10,10))
    }

    def 'check Prev LVL'(){
        expect: 'Should return flag to next lvl'
        Acontrol.checkPrevLvl(new Position(-10,10))
        Acontrol.checkPrevLvl(new Position(10,-25))
        Acontrol.checkPrevLvl(new Position(-34,-25))
        Acontrol.checkPrevLvl(new Position(0,25))
        Acontrol.checkPrevLvl(new Position(34,0))
        !Acontrol.checkPrevLvl(new Position(33,10))
        !Acontrol.checkPrevLvl(new Position(10,22))
        !Acontrol.checkPrevLvl(new Position(10,10))
    }

    def 'test key == xxx 250'(){
        given:
        time = 250
        key.getKeyType() >> KeyType.ArrowUp ;
        Acontrol.getModel() >> arena
        arena.getHero() >> hero
        hero.getEnergy() >> 6
        Acontrol.setEnemyController(e_c)
        Acontrol.setHeroController(h_c)

        when:
        Acontrol.stepNonVoid(game, key, time, instance)

        then:
        0 * arena.shoot(_,_,_)
        1 * h_c.step(game, key, time);
        1 * e_c.step(game, key, time);
    }

    def 'test key == xxx 250'(){
        given:
        def time = 260
        key.getKeyType() >> KeyType.ArrowUp ;
        Acontrol.getModel() >> arena
        arena.getHero() >> hero
        hero.getEnergy() >> 6
        Acontrol.setEnemyController(e_c)
        Acontrol.setHeroController(h_c)
        Acontrol.setLastBullet(0)

        when:
        Acontrol.stepNonVoid(game, key, 260, instance)

        then:
        1 * arena.shoot(_,_,_)
        1 * h_c.step(game, key, time);
        1 * e_c.step(game, key, time);
    }

    def 'test key == xxx 250'(){
        given:
        def time = 260
        key.getKeyType() >> KeyType.ArrowUp ;
        Acontrol.getModel() >> arena
        arena.getHero() >> hero
        hero.getEnergy() >> 6
        Acontrol.setEnemyController(e_c)
        Acontrol.setHeroController(h_c)
        Acontrol.setLastBullet(150)

        when:
        Acontrol.stepNonVoid(game, key, 260, instance)

        then:
        0 * arena.shoot(_,_,_)
        1 * h_c.step(game, key, time);
        1 * e_c.step(game, key, time);
    }

    def 'test key == xxx 250'(){
        given:
        def time = 260
        key.getKeyType() >> KeyType.ArrowUp ;
        Acontrol.getModel() >> arena
        arena.getHero() >> hero
        hero.getEnergy() >> 6
        Acontrol.setEnemyController(e_c)
        Acontrol.setHeroController(h_c)
        Acontrol.setLastBullet(150)

        when:
        Acontrol.step(game, key, 260)

        then:
        1 * h_c.step(game, key, time);
        1 * e_c.step(game, key, time);
    }

    def 'test key = null'(){
        given:
        key = null
        Acontrol.setEnemyController(e_c)
        Acontrol.setHeroController(h_c)
        Acontrol.setBulletController(b_c)
        Acontrol.getModel() >> arena
        arena.getLevel() >> 5
        arena.getHero() >> hero
        hero.getPosition() >> new Position(10,10)
        arena.getBullets() >> [new Bullet(2,2, 'd' as char,true)];
        arena.getWalls() >> [new Wall(3,2)]
        arena.getMonsters() >> [new Monster(5,5)]
        arena.getKings() >> [new King(7,7)]

        when:
        Acontrol.stepVoidKey(game, time)

        then:
        1 * h_c.step(game, null, time);
        1 * e_c.step(game, null, time);
        1 * b_c.step(game, null, time)
    }

    def 'test key = null + < energy < 0'(){
        given:
        key = null
        arenaController.setEnemyController(e_c)
        arenaController.setHeroController(h_c)
        arenaController.getModel().getHero().setEnergy(-20)

        when:
        arenaController.step(game, key, time)

        then:
        1 * h_c.step(game, key, time);
        1 * e_c.step(game, key, time);
        1 * game.setState(_)
    }

    def 'test key = null + < energy == 0'(){
        given:
        key = null
        arenaController.setEnemyController(e_c)
        arenaController.setHeroController(h_c)
        arenaController.getModel().getHero().setEnergy(0)

        when:
        arenaController.step(game, key, time)

        then:
        1 * h_c.step(game, key, time);
        1 * e_c.step(game, key, time);
        1 * game.setState(_)
    }

    def 'test key = null +lvl = 4 next lvl'(){
        given:
        key = null
        def arena = new Arena(34,24,4);
        def arenaController2 = new ArenaController(arena)
        arenaController2.setEnemyController(e_c)
        arenaController2.setHeroController(h_c)
        arenaController2.setBulletController(b_c)
        arena.getHero().setPosition(new Position(34,10))

        when:
        arenaController2.step(game, key, time)

        then:
        1 * h_c.step(game, key, time);
        1 * b_c.step(game, key, time)
        1 * game.setState(_)
    }

    def 'test key = null +lvl = 4 prev lvl'(){
        given:
        key = null
        def arena = new Arena(34,24,4);
        def arenaController2 = new ArenaController(arena)
        arenaController2.setEnemyController(e_c)
        arenaController2.setHeroController(h_c)
        arenaController2.setBulletController(b_c)
        arena.getHero().setPosition(new Position(-34,10))

        when:
        arenaController2.step(game, key, time)

        then:
        1 * h_c.step(game, key, time);
        1 * b_c.step(game, key, time)
        1 * game.setState(_)
    }

    def 'test key = null +lvl = 6'(){
        given:
        key = null
        def arena = new Arena(34,24,6);
        def arenaController2 = new ArenaController(arena)
        arenaController2.setEnemyController(e_c)
        arenaController2.setHeroController(h_c)
        arenaController2.setBulletController(b_c)
        arena.boss.decreaseEnergy(12)


        when:
        arenaController2.step(game, key, time)

        then:
        0 * b_c.step(game, key, time)
        1 * h_c.step(game, key, time);
        1 * game.setState(_)
    }

    def 'test key = null +lvl = 6 and Boss health < 0'(){
        given:
        key = null
        def arena = new Arena(34,24,6);
        def arenaController2 = new ArenaController(arena)
        arenaController2.setEnemyController(e_c)
        arenaController2.setHeroController(h_c)
        arenaController2.setBulletController(b_c)
        arena.boss.decreaseEnergy(15)

        when:
        arenaController2.step(game, key, time)

        then:
        0 * b_c.step(game, key, time)
        1 * h_c.step(game, key, time);
        1 * game.setState(_)
    }

    def 'test key = null +lvl = 6 and Boss health > 0'(){
        given:
        key = null
        def arena = new Arena(34,24,6);
        def arenaController2 = new ArenaController(arena)
        arenaController2.setEnemyController(e_c)
        arenaController2.setHeroController(h_c)
        arenaController2.setBulletController(b_c)
        arena.boss.decreaseEnergy(1)

        when:
        arenaController2.step(game, key, time)

        then:
        1 * h_c.step(game, key, time);
        1 * b_c.step(game, key, time);
        1 * e_c.step(game, key, time);
        0 * game.setState(_)
    }

    def 'test key = null +lvl == 5'(){
        given:
        key = null
        def arena = new Arena(34,24,5);
        def arenaController2 = new ArenaController(arena)
        arenaController2.setEnemyController(e_c)
        arenaController2.setHeroController(h_c)
        arenaController2.setBulletController(b_c)

        when:
        arenaController2.step(game, key, time)

        then:
        1 * h_c.step(game, key, time);
        1 * b_c.step(game, key, time);
        1 * e_c.step(game, key, time);
        0 * game.setState(_)
    }

}
