package com.l12gr05.projeto.controller.Menu

import com.l12gr05.projeto.Game
import com.l12gr05.projeto.model.sounds.SoundControl
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.l12gr05.projeto.controller.menu.MenuController
import com.l12gr05.projeto.model.menu.Menu
import spock.lang.Specification

class MenuControllerTest extends Specification{

    private def game
    private def key
    private def time
    private def menu
    private def menuController
    private def instance

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        menu = Mock(Menu.class)
        menuController = new MenuController(menu)
        instance = Mock(SoundControl.class)
    }

    def 'test key = null'(){
        given:
        key = null
        when:
        menuController.step(game,key,time)
        then:
        0 * game.setState(_)
    }

    def 'test key Enter exit'(){
        given:
        key.getKeyType() >>> KeyType.Enter;
        menu.isSelectedExit() >> true

        when:
        menuController.stepNotNull(game,key,instance)
        then:
        1 * game.setState(_)
    }

    def 'test key Enter start'(){
        given:
        key.getKeyType() >>> KeyType.Enter;
        menu.isSelectedStart() >> true

        when:
        menuController.stepNotNull(game,key,instance)
        then:
        2 * instance.start(_)
        1 * instance.stop(_)
        1 * game.setState(_)
        1 * game.setScore(0)
    }

    def 'test key Enter leader board'(){
        given:
        key.getKeyType() >>> KeyType.Enter;
        menu.isSelectedLeaderBoard() >> true

        when:
        menuController.stepNotNull(game,key,instance)
        then:
        1 * instance.stop(_)
        1 * instance.start(_)
        1 * game.setState(_)
    }

    def 'test key Enter Instructions'(){
        given:
        key.getKeyType() >>> KeyType.Enter;
        menu.isSelectedInstructions() >> true

        when:
        menuController.stepNotNull(game,key,instance)
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
        menuController.stepNotNull(game,key,instance)
        then:
        1 * instance.stopAll()
        1 * game.setState(_)
    }

    def 'test key char step'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        menuController.step(game,key,time)
        then:
        1 * game.setState(_)
    }

    def 'test key arrow UP'(){
        given:
        MenuController menuController1 = new MenuController(new Menu())
        int x = new Integer(menuController1.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowUp;

        when:
        menuController1.stepNotNull(game,key,instance)

        then:
        x != menuController1.getModel().getCurrentEntry()
        menuController1.getModel().getCurrentEntry() == menuController1.getModel().getNumberEntries() - 1
    }

    def 'test key arrow Down'(){
        given:
        MenuController menuController1 = new MenuController(new Menu())
        int x = new Integer(menuController1.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowDown;

        when:
        menuController1.stepNotNull(game,key,instance)
        then:
        x != menuController1.getModel().getCurrentEntry()
        menuController1.getModel().getCurrentEntry() == 1
    }
}
