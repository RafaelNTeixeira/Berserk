package com.l12gr05.projeto.model.menu

import spock.lang.Specification

class PauseTest extends Specification{

    def 'Getting entries'() {
        given:
        String string = new String('continue')
        Pause pause = new Pause()

        when:
        String x = pause.getEntry(0)

        then:
        x == string
    }

    def 'Entry boundaries prev'(){
        given:
        Pause pause = new Pause()

        when:
        pause.previousEntry()
        def x = pause.getCurrentEntry()

        then:
        pause.isSelected(3)
        x == 3
    }


    def 'Entry boundaries prev'(){
        given:
        Pause pause = new Pause()

        when:
        pause.nextEntry()
        pause.previousEntry()


        then:
        pause.isSelected(0)
    }

    def 'Entry boundaries next'(){
        given:
        Pause pause = new Pause()

        when:
        boolean f1 = pause.isSelectedContinue()
        boolean f2 = pause.isSelectedNewGame()
        pause.nextEntry()
        boolean f3 = pause.isSelectedContinue()
        boolean f4 = pause.isSelectedNewGame()
        pause.nextEntry()
        boolean f5 = pause.isSelectedExit()
        boolean f6 = pause.isSelectedGoToMenu()
        pause.nextEntry()
        boolean f7 = pause.isSelectedExit()
        boolean f8 = pause.isSelectedGoToMenu()
        pause.nextEntry()

        then:
        pause.isSelected(0)
        f1 && f4 && f5 && f8
        !f2
        !f3
        !f6
        !f7
    }


}
