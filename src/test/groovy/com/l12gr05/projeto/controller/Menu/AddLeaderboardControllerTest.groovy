package com.l12gr05.projeto.controller.Menu

import com.l12gr05.projeto.Game
import com.l12gr05.projeto.model.sounds.SoundControl
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.l12gr05.projeto.controller.menu.AddToLeaderboardController
import com.l12gr05.projeto.model.menu.AddToLeaderboard
import spock.lang.Specification

class AddLeaderboardControllerTest extends Specification{
    private def game
    private def key
    private def time
    private def leaderController
    private def addLeader
    private def instance


    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        addLeader = Mock(AddToLeaderboard.class)
        leaderController = new AddToLeaderboardController(addLeader)
        instance = Mock(SoundControl.class)
    }

    def 'test key = null'(){
        given:
        key = null
        when:
        leaderController.step(game,key,time)
        then:
        0 * game.setState(_)
    }
    def 'test key Enter'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        when:
        leaderController.stepNotNull(game,key,instance)
        then:
        1 * game.setState(_)
        1 * addLeader.addScore()
        1 * instance.start(_)
    }

    def 'test key Enter'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        when:
        leaderController.step(game,key,time)
        then:
        1 * game.setState(_)
        1 * addLeader.addScore()
    }

    def 'test key Char'(){
        given:
        AddToLeaderboardController addLeaderController = new AddToLeaderboardController(new AddToLeaderboard(10))
        def s = new String(addLeaderController.getModel().getName())
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'd'
        when:
        addLeaderController.stepNotNull(game,key,instance)
        then:
        !s.equals(addLeaderController.getModel().getName())
        addLeaderController.getModel().getName().charAt(addLeaderController.getModel().getName().length() - 1) == 'd';
    }

    def 'Test key backspace name len 0'(){
        given:
        AddToLeaderboard addLeader1 = new AddToLeaderboard(10)
        addLeader1.setName('')
        AddToLeaderboardController addLeaderController = new AddToLeaderboardController(addLeader1)
        key.getKeyType() >> KeyType.Backspace

        when:
        addLeaderController.stepNotNull(game, key,instance)

        then:
        addLeader1.getName() == ''
    }

    def 'Test key backspace name len != 0'(){
        given:
        AddToLeaderboard addLeader1 = new AddToLeaderboard(10)
        addLeader1.setName('Ian')
        AddToLeaderboardController addLeaderController = new AddToLeaderboardController(addLeader1)
        key.getKeyType() >> KeyType.Backspace

        when:
        addLeaderController.stepNotNull(game, key, instance)

        then:
        addLeader1.getName() == 'Ia'
    }
}
