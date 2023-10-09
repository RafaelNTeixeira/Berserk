package com.l12gr05.projeto.graphics

import com.googlecode.lanterna.input.KeyStroke
import com.l12gr05.projeto.model.game.Position
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.input.KeyType
import com.googlecode.lanterna.screen.Screen
import spock.lang.Specification

class GuiLanternaTest extends Specification{

    private def screen
    private def position
    private def gui
    private def tg
    private def string

    def setup() {
        screen = Mock(Screen.class)
        position = new Position(10, 10)
        tg = Mock(TextGraphics.class);
        string = new String("#FFFFFF")
        gui = new GUILaterna(screen)
        screen.newTextGraphics() >> tg
    }

    def 'Creation with screen'() {
        when:
        Screen s = gui.screen

        then:
        s == screen
    }

    def 'Draw Hero'() {
        when:
        gui.drawHero(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw Wall'() {
        when:
        gui.drawWall(position)

        then:
        1*tg.setBackgroundColor(_)
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw Monster'() {
        when:
        gui.drawMonster(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw Heart'() {
        when:
        gui.drawHeart(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw Heart Boss'() {
        when:
        gui.drawHeartBoss(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw King'() {
        when:
        gui.drawKing(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw Boss'() {
        given:
        def x = position.getX()
        def y = position.getY()
        when:
        gui.drawBoss(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(x,y, "F")
        1*tg.putString(x - 1,y - 1,"A");
        1*tg.putString(x,y - 1,"C");
        1*tg.putString(x + 1,y - 1,"D");
        1*tg.putString(x - 1,y,"E");
        1*tg.putString(x + 1,y,"G");
        1*tg.putString(x - 1 ,y+1,"H");
        1*tg.putString(x,y+1,"I");
        1*tg.putString(x+1,y+1,"L");
    }

    def 'Draw Hero bullet'(){
        when:
        gui.drawHeroBullet(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw Enemy bullet'(){
        when:
        gui.drawEnemyBullet(position)

        then:
        1*tg.setForegroundColor(_)
        1*tg.enableModifiers(_)
        1*tg.putString(_,_)
    }

    def 'Draw Text'() {
        when:
        gui.drawText(position, string, string)

        then:
        1*tg.setForegroundColor(_)
        1*tg.putString(_,_,_)
    }

    def 'Clear'() {
        when:
        gui.clear()

        then:
        1*screen.clear()
    }

    def 'Refresh'() {
        when:
        gui.refresh()

        then:
        1*screen.refresh()
    }

    def 'Close'() {
        when:
        gui.close()

        then:
        1*screen.close()
    }


    def 'test getNextAction'(){
        given:
        screen.pollInput() >> new KeyStroke(KeyType.ArrowDown)
        when:
        def r = gui.getNextAction()
        then:
        r instanceof KeyStroke
    }

    def 'test getNextAction 1'(){
        given:
        screen.pollInput() >> null
        def s = new HashSet<>() ;
        s.add(1)
        s.add(3)
        s.add(5)
        s.add(4)
        gui.setPressedKeys(s)

        when:
        def r = gui.getNextAction()
        def r2 = gui.getNextAction()
        def r3 = gui.getNextAction()
        def r4 = gui.getNextAction()
        def r5 = gui.getNextAction()

        then:
        s.isEmpty()
        r instanceof KeyStroke
        r2 instanceof KeyStroke
        r3 instanceof KeyStroke
        r4 instanceof KeyStroke
        r5 == null
    }



}
