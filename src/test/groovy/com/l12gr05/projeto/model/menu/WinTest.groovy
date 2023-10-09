package com.l12gr05.projeto.model.menu

import spock.lang.Specification

class WinTest extends Specification{
    def 'Entry boundaries prev'(){
        given:
        Win win = new Win(10)

        when:
        win.previousEntry()

        then:
        win.isSelected(2)
    }

    def 'Entry boundaries prev'(){
        given:
        Win win = new Win(10)

        when:
        win.nextEntry()
        win.previousEntry()

        then:
        win.isSelected(0)
    }

    def 'Entry boundaries next'(){
        given:
        Win win = new Win(10)

        when:
        boolean f1 = win.isSelectedMenu()
        boolean f2 = win.isSelectedLeaderBoard()
        win.nextEntry()
        boolean f3 = win.isSelectedMenu()
        boolean f4 = win.isSelectedLeaderBoard()
        win.nextEntry()
        boolean f5 = win.isSelectedAddToLeaderBoard()
        win.nextEntry()
        boolean f6 = win.isSelectedAddToLeaderBoard()

        then:
        win.isSelected(0)
        f1 && f4 && f5
        !f2
        !f3
        !f6
    }

    def 'Getting entries'() {
        given:
        String string = new String('menu')
        Win win = new Win(10)

        when:
        String x = win.getEntry(0)

        then:
        x == string
    }

    def 'Get score'(){
        given:
        Win win = new Win(10)

        when:
        int x = win.getScore()

        then:
        x == 10
    }
}
