package com.l12gr05.projeto.model.game.elements

import com.l12gr05.projeto.model.game.Position
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class HeroTest extends Specification{

    private def textGraphics

    def setup () {
        textGraphics = Mock(TextGraphics.class)
    }

    def 'Position and energy getters'() {
        given:
        Hero hero = new Hero(50, 30)
        Position position = new Position(50, 30)

        when:
        int x = hero.getX()
        int y = hero.getY()
        Position p = hero.getPosition()
        int e = hero.getEnergy()

        then:
        p == position
        x == 50
        y == 30
        e == 15
    }

    def 'Hero with empty constructor' () {
        given:
        Hero hero = new Hero()

        when:
        int x = hero.getX()
        int y = hero.getY()

        then:
        x == 10
        y == 10
    }

    def 'Position setters' () {
        given:
        Hero hero = new Hero(50, 30)
        Hero hero1 = new Hero(50, 30)
        Position position = new Position(10, 10)

        when:
        hero.setX(30)
        hero.setY(50)
        hero1.setPosition(position)

        then:
        hero.getX() == 30
        hero.getY() == 50
        hero1.getX() == 10
        hero1.getY() == 10
    }

    def 'Decrease and set energy' () {
        given:
        Hero hero = new Hero()
        Hero hero1 = new Hero()

        when:
        hero.decreaseEnergy(1)
        hero1.setEnergy(5)

        then:
        hero.getEnergy() == 14
        hero1.getEnergy() == 5
    }


    def 'MovesUP'(){
        given:
        Hero hero = new Hero()

        when:
        def Pos = hero.moveUp()

        then:
        Pos.y == 9
        Pos.x == 10
    }
    def 'MovesDown'(){
        given:
        Hero hero = new Hero()

        when:
        def Pos = hero.moveDown()

        then:
        Pos.y == 11
        Pos.x == 10
    }
    def 'MovesRight'(){
        given:
        Hero hero = new Hero()

        when:
        def Pos = hero.moveRight()

        then:
        Pos.y == 10
        Pos.x == 11
    }
    def 'MovesLeft'(){
        given:
        Hero hero = new Hero()

        when:
        def Pos = hero.moveLeft()

        then:
        Pos.y == 10
        Pos.x == 9
    }

}


