package com.l12gr05.projeto.controller.Game

import com.l12gr05.projeto.Game
import com.l12gr05.projeto.controller.game.HeroController
import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena
import com.l12gr05.projeto.model.sounds.SoundControl
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import spock.lang.Specification

class HeroControllerTest extends Specification{

    private def arena
    private def game
    private def key
    private def time
    private def heroController
    private def instance

    def setup(){
        arena = new Arena(34,24,1)
        heroController = new HeroController(arena)
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        instance = Mock(SoundControl.class)
    }

    def 'test Cons' (){
        expect:
        heroController.getModel().getWidth() == 34
        heroController.getModel().getHeight() == 24
    }

    def 'test Sound'(){
        given:
        def instance = heroController.getInstance();
        expect:
        instance instanceof SoundControl
    }

    def 'test MoveHeroLeft'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHeroLeft()

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX() - 1
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }

    def 'test MoveHeroRight'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHeroRight()

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX() + 1
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }

    def 'test MoveHeroUP'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHeroUp()

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY() - 1
    }

    def 'test MoveHeroDown'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHeroDown()

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY() + 1
    }

    def 'test Can Hero Move'(){
        given:
        Position p = new Position(112, 3)
        Position p2 = new Position(12, 3)
        Position w = new Position(0,7 )
        when:
        def r = heroController.canHeroMove(p)
        def r2 = heroController.canHeroMove(p2)
        def r3 = heroController.canHeroMove(w)

        then:
        r
        r2
        !r3
    }

    def 'test Monster Collision'(){
        given:
        def energy = new Integer(heroController.getModel().getHero().getEnergy())

        when:
        heroController.verifyMonsterCollisions(new Position(2,2), instance)

        then:
        energy == heroController.getModel().getHero().getEnergy()
    }

    def 'test Monster Collision -5'(){

        when:
        heroController.verifyMonsterCollisions(new Position(3,4), instance)

        then:
        10 == heroController.getModel().getHero().getEnergy()
        1 * instance.stop(_)
        1 * instance.start(_)
    }

    def 'test Monster Collision -3'(){

        when:
        heroController.verifyMonsterCollisions(new Position(8, 9), instance)

        then:
        12 == heroController.getModel().getHero().getEnergy()
        1 * instance.stop(_)
        1 * instance.start(_)
    }

    def 'test move Hero'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHero(new Position(1,1))

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }

    def 'test move Hero2'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())

        when:
        heroController.moveHero(new Position(8, 9))

        then:
        heroController.getModel().getHero().getPosition().getX() == 8
        heroController.getModel().getHero().getPosition().getY() == 9
        12 == heroController.getModel().getHero().getEnergy()
    }

    def 'test step UP'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())
        key.getKeyType() >> KeyType.Character ;
        key.getCharacter() >> 'w';

        when:
        heroController.step(game,  key,  time)

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY() - 1
    }

    def 'test step Down'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())
        key.getKeyType() >> KeyType.Character ;
        key.getCharacter() >> 's';

        when:
        heroController.step(game,  key,  time)

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY() + 1
    }

    def 'test step Left'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())
        key.getKeyType() >> KeyType.Character ;
        key.getCharacter() >> 'a';

        when:
        heroController.step(game,  key,  time)

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX() - 1
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }

    def 'test step Right'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())
        key.getKeyType() >> KeyType.Character ;
        key.getCharacter() >> 'd';

        when:
        heroController.step(game,  key,  time)

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX() + 1
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }

    def 'test step null'(){
        given:
        Position p = new Position(heroController.getModel().getHero().getPosition().getX(), heroController.getModel().getHero().getPosition().getY())
        key = null

        when:
        heroController.step(game,  key,  time)

        then:
        heroController.getModel().getHero().getPosition().getX() == p.getX()
        heroController.getModel().getHero().getPosition().getY() == p.getY()
    }

    def 'test checkHealth false'(){
        given:
        def arena2 = new Arena(34,24,6)
        def heroController2 = new HeroController(arena2)

        when:
        def r1 = heroController2.checkHealth()

        then:
        !r1
    }

    def 'test checkHealth true'(){
        given:
        def arena2 = new Arena(34,24,6)
        def heroController2 = new HeroController(arena2)
        heroController2.model.hero.setPosition(new Position(27,3))
        def i = heroController2.model.getHealth().size()

        when:
        def r1 = heroController2.checkHealth()


        then:
        r1
        i - 1 == heroController2.model.getHealth().size()
    }

    def 'test step null + energy'(){
        given:
        def arena2 = new Arena(34,24,6)
        def heroController2 = new HeroController(arena2)
        heroController2.model.hero.setPosition(new Position(27,3))
        key = null
        def i = heroController2.model.hero.energy

        when:
        heroController2.step(game,  key,  time)

        then:
        i + 1 == heroController2.model.hero.energy
    }
}
