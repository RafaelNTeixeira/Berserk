package com.l12gr05.projeto.model.sounds

import spock.lang.Specification

class SoundControlTest extends Specification{

    private def soundControl
    private def soundtrack
    private def menuMusic
    private def shooting
    private def heroDeath
    private def enemyDeath
    private def changeTab

    def setup(){
        soundControl = SoundControl.getInstance()
        soundtrack = Mock(SoundTrack.class)
        menuMusic = Mock(SoundTrack.class)
        shooting = Mock(SoundTrack.class)
        heroDeath = Mock(SoundTrack.class)
        enemyDeath = Mock(SoundTrack.class)
        changeTab = Mock(SoundTrack.class)
    }


    def 'get Instance'(){
        given:
        def s = new  SoundControl();
        when:
        def i = s.getInstance()
        s.stopAll();
        then:
        i instanceof SoundControl
    }

    def 'Play sound track'() {
        given:
        soundControl.setSoundTrack(soundtrack)

        when:
        soundControl.start(Sound.SOUNDTRACK)

        then:
        1*soundtrack.playLoop()
    }

    def 'Play Menu music'() {
        given:
        soundControl.setMenuMusic(menuMusic)

        when:
        soundControl.start(Sound.MENUMUSIC)

        then:
        1*menuMusic.playLoop()
    }

    def 'Play shooting'() {
        given:
        soundControl.setShooting(shooting)

        when:
        soundControl.start(Sound.SHOOTING)

        then:
        1*shooting.play()
    }

    def 'Play Hero death'() {
        given:
        soundControl.setHeroDeath(heroDeath)

        when:
        soundControl.start(Sound.HERODEATH)

        then:
        1*heroDeath.play()
    }

    def 'Play Enemy death'() {
        given:
        soundControl.setEnemyDeath(enemyDeath)

        when:
        soundControl.start(Sound.ENEMYDEATH)

        then:
        1*enemyDeath.play()
    }

    def 'Play Change tab'() {
        given:
        soundControl.setChangeTab(changeTab)

        when:
        soundControl.start(Sound.CHANGETAB)

        then:
        1*changeTab.play()
    }

    def 'Stop sound track'() {
        given:
        soundControl.setSoundTrack(soundtrack)

        when:
        soundControl.stop(Sound.SOUNDTRACK)

        then:
        1*soundtrack.stop()
    }

    def 'Stop Menu music'() {
        given:
        soundControl.setMenuMusic(menuMusic)

        when:
        soundControl.stop(Sound.MENUMUSIC)

        then:
        1*menuMusic.stop()
    }

    def 'Stop shooting'() {
        given:
        soundControl.setShooting(shooting)

        when:
        soundControl.stop(Sound.SHOOTING)

        then:
        1*shooting.stop()
    }

    def 'Stop Hero death'() {
        given:
        soundControl.setHeroDeath(heroDeath)

        when:
        soundControl.stop(Sound.HERODEATH)

        then:
        1*heroDeath.stop()
    }

    def 'Stop Enemy death'() {
        given:
        soundControl.setEnemyDeath(enemyDeath)

        when:
        soundControl.stop(Sound.ENEMYDEATH)

        then:
        1*enemyDeath.stop()
    }

    def 'Play Change tab'() {
        given:
        soundControl.setChangeTab(changeTab)

        when:
        soundControl.stop(Sound.CHANGETAB)

        then:
        1*changeTab.stop()
    }

    def 'Stop all'() {
        given:
        soundControl.setSoundTrack(soundtrack)
        soundControl.setMenuMusic(menuMusic)
        soundControl.setShooting(shooting)
        soundControl.setHeroDeath(heroDeath)
        soundControl.setEnemyDeath(enemyDeath)
        soundControl.setChangeTab(changeTab)

        when:
        soundControl.stopAll()

        then:
        1*soundtrack.stop()
        1*menuMusic.stop()
        1*shooting.stop()
        1*heroDeath.stop()
        1*enemyDeath.stop()
        1*changeTab.stop()
    }


}
