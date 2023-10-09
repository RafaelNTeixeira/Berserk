package com.l12gr05.projeto.controller.Menu

import com.l12gr05.projeto.Game
import com.l12gr05.projeto.model.menu.Pause
import com.l12gr05.projeto.model.sounds.SoundControl
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.l12gr05.projeto.controller.menu.PauseController
import spock.lang.Specification

class PauseControllerTest extends Specification{

    private def game
    private def key
    private def time
    private def pauseController
    private def pause
    private def instance

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        pause = Mock(Pause.class)
        pauseController = new PauseController(pause)
        instance = Mock(SoundControl.class)
    }

    def 'test key = null'(){
        given:
        key = null
        when:
        pauseController.step(game,key,time)
        then:
        0 * game.setState(_)
    }

    def 'test key Enter exit'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        pause.isSelectedExit() >> true
        when:
        pauseController.notNullStep(game, key, instance)
        then:
        1 * game.setState(null)
    }

    def 'test key Enter continue'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        pause.isSelectedContinue() >> true
        when:
        pauseController.notNullStep(game, key, instance)
        then:
        2 * instance.start(_)
        1 * instance.stop(_)
        1 * game.setState(_)
    }

    def 'test key Enter go to menu'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        pause.isSelectedGoToMenu() >> true
        when:
        pauseController.notNullStep(game, key, instance)
        then:
        1 * instance.start(_)
        1 * instance.stop(_)
        1 * game.setState(_)
    }

    def 'test key Enter continue'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        pause.isSelectedNewGame() >> true
        when:
        pauseController.notNullStep(game, key, instance)
        then:
        2 * instance.start(_)
        1 * game.setState(_)
        1 * game.setScore(0)
    }

    def 'test key char e'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        pauseController.notNullStep(game, key, instance)
        then:
        1 * game.setState(_)
    }

    def 'test key char q'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'q'

        when:
        pauseController.notNullStep(game, key, instance)

        then:
        1 * game.setState(_)
    }

    def 'test step key char q'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'q'

        when:
        pauseController.step(game, key, time)

        then:
        1 * game.setState(_)
    }

    def 'test key arrow UP'(){
        given:
        int x = new Integer(pauseController.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowUp;

        when:
        pauseController.notNullStep(game, key, instance)

        then:
        1*pause.previousEntry()
    }

    def 'test key arrow Down'(){
        given:
        int x = new Integer(pauseController.getModel().getCurrentEntry())
        key.getKeyType() >> KeyType.ArrowDown;

        when:
        pauseController.notNullStep(game, key, instance)
        then:
        1*pause.nextEntry()
    }
}
