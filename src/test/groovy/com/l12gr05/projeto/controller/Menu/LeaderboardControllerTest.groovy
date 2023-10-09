package com.l12gr05.projeto.controller.Menu

import com.l12gr05.projeto.Game
import com.l12gr05.projeto.model.sounds.SoundControl
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.l12gr05.projeto.controller.menu.LeaderboardController
import com.l12gr05.projeto.model.menu.Leaderboard
import spock.lang.Specification

class LeaderboardControllerTest extends Specification{

    private def game
    private def key
    private def time
    private def leader
    private def leaderController
    private def instance

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        leader = Mock(Leaderboard.class)
        leaderController = new LeaderboardController(leader)
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

    def 'test key Enter selected'(){
        given:
        key.getKeyType() >>> KeyType.Enter;
        leader.isSelectedEnter() >> true

        when:
        leaderController.stepNotNull(game,key,instance)

        then:
        1 * game.setState(_)
        1 * instance.stop(_)
        1 * instance.start(_)

    }

    def 'test key Enter'(){
        given:
        key.getKeyType() >>> KeyType.Enter;

        when:
        leaderController.stepNotNull(game,key,instance)
        then:
        1 * game.setScore(_)
        1 * instance.stop(_)
        1 * instance.start(_)
    }

    def 'test key Enter'(){
        given:
        key.getKeyType() >>> KeyType.Enter;

        when:
        leaderController.stepNotNull(game,key,instance)
        then:
        1 * game.setScore(_)

    }

    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        leaderController.stepNotNull(game,key,instance)
        then:
        1 * game.setState(_)
    }

    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        leaderController.step(game,key,time)
        then:
        1 * game.setState(_)
    }
}
