package com.l12gr05.projeto.controller.Menu

import com.l12gr05.projeto.Game
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.l12gr05.projeto.controller.menu.WinController
import com.l12gr05.projeto.model.menu.Win
import com.l12gr05.projeto.model.sounds.SoundControl
import spock.lang.Specification

class WinControllerTest extends Specification{
    private def game
    private def key
    private def time
    private def win
    private def winController
    private def instance

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        win = Mock(Win.class)
        winController = new WinController(win)
        instance = Mock(SoundControl.class)
    }

    def 'test key = null'(){
        given:
        key = null
        when:
        winController.step(game,key,time)
        then:
        0 * game.setState(_)
    }


    def 'test key Enter menu'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        win.isSelectedMenu() >> true

        when:
        winController.stepNotNull(game,key,instance)
        then:
        1 * instance.stop(_)
        1 * instance.start(_)
        1 * game.setState(_)
    }

    def 'test key Enter leader board'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        win.isSelectedLeaderBoard() >> true

        when:
        winController.stepNotNull(game,key,instance)

        then:
        1 * instance.stop(_)
        1 * instance.start(_)
        1 * game.setState(_)
    }

    def 'test key Enter leader board'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        win.isSelectedAddToLeaderBoard() >> true

        when:
        winController.stepNotNull(game,key,instance)
        then:
        1 * instance.stop(_)
        1 * instance.start(_)
        1 * game.setState(_)
    }

    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        winController.step(game,key,time)
        then:
        1 * game.setState(_)
    }


    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        winController.stepNotNull(game,key,instance)
        then:
        1 * game.setState(_)
    }

    def 'test key arrow UP'(){
        given:
        WinController winController1 = new WinController(new Win(10))
        int x = new Integer(winController1.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowUp;

        when:
        winController1.step(game,key,time)
        then:
        x != winController1.getModel().getCurrentEntry()
        winController1.getModel().getCurrentEntry() == winController1.getModel().getNumberEntries() - 1
    }

    def 'test key arrow Down'(){
        given:
        WinController winController1 = new WinController(new Win(10))
        int x = new Integer(winController1.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowDown;

        when:
        winController1.step(game,key,time)
        then:
        x != winController1.getModel().getCurrentEntry()
        winController1.getModel().getCurrentEntry() == 1
    }
}
