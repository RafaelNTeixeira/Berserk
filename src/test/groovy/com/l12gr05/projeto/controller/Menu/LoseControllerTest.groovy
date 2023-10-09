package com.l12gr05.projeto.controller.Menu

import com.l12gr05.projeto.Game
import com.l12gr05.projeto.model.menu.Lose
import com.l12gr05.projeto.model.sounds.SoundControl
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.l12gr05.projeto.controller.menu.LoseController
import spock.lang.Specification

class LoseControllerTest extends Specification{

    private def game
    private def key
    private def time
    private def lose
    private def loseController
    private def instance

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        lose = Mock(Lose.class)
        loseController = new LoseController(lose)
        instance = Mock(SoundControl.class)
    }

    def 'Constructor sound'(){
        given:
        LoseController loseController1 = new LoseController(new Lose(10))

        when:
        loseController1.startMenuMusic(instance)

        then:
        1*instance.stop(_)
        1*instance.start(_)
    }

    def 'test key = null'(){
        given:
        key = null
        when:
        loseController.step(game,key,time)
        then:
        0 * game.setState(_)
    }

    def 'test key Enter menu'(){
        given:
        key.getKeyType() >>> KeyType.Enter;
        lose.isSelectedMenu() >> true

        when:
        loseController.stepNotNullLose(game,key,instance)
        then:
        1 * game.setState(_)
        1 * instance.stop(_)
        1 * instance.start(_)
    }

    def 'test key Enter Leader Board'(){
        given:
        key.getKeyType() >>> KeyType.Enter;
        lose.isSelectedLeaderBoard() >> true

        when:
        loseController.stepNotNullLose(game,key,instance)
        then:
        1 * game.setState(_)
        1 * instance.stop(_)
        1 * instance.start(_)
    }

    def 'test key Enter Leader Board'(){
        given:
        key.getKeyType() >>> KeyType.Enter;
        lose.isSelectedAddToLeaderBoard() >> true

        when:
        loseController.stepNotNullLose(game,key,instance)
        then:
        1 * game.setState(_)
        1 * instance.stop(_)
        1 * instance.start(_)
    }

    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        loseController.step(game,key,time)
        then:
        1 * game.setState(_)
    }

    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        loseController.stepNotNullLose(game,key,instance)
        then:
        1 * game.setState(_)
    }

    def 'test key arrow UP'(){
        given:
        LoseController loseController1 = new LoseController(new Lose(10))
        int x = new Integer(loseController1.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowUp;

        when:
        loseController1.stepNotNullLose(game,key,instance)
        then:
        x != loseController1.getModel().getCurrentEntry()
        loseController1.getModel().getCurrentEntry() == loseController1.getModel().getNumberEntries() - 1
    }

    def 'test key arrow Down'(){
        given:
        LoseController loseController1 = new LoseController(new Lose(10))
        int x = new Integer(loseController1.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowDown;

        when:
        loseController1.stepNotNullLose(game,key,instance)
        then:
        x != loseController1.getModel().getCurrentEntry()
        loseController1.getModel().getCurrentEntry() == 1
    }
}
