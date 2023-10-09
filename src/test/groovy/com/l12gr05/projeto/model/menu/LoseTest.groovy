package com.l12gr05.projeto.model.menu

import spock.lang.Specification

class LoseTest extends Specification{

    def 'Entry boundaries prev'(){
        given:
        Lose lose = new Lose(10)

        when:
        lose.previousEntry()

        then:
        lose.isSelected(2)
    }

    def 'Entry boundaries prev'(){
        given:
        Lose lose = new Lose(10)

        when:
        lose.nextEntry()
        lose.previousEntry()

        then:
        lose.isSelected(0)
    }

    def 'Entry boundaries next'(){
        given:
        Lose lose = new Lose(10)

        when:
        boolean f1 = lose.isSelectedMenu()
        boolean f2 = lose.isSelectedLeaderBoard()
        lose.nextEntry()
        boolean f3 = lose.isSelectedMenu()
        boolean f4 = lose.isSelectedLeaderBoard()
        lose.nextEntry()
        boolean f5 = lose.isSelectedAddToLeaderBoard()
        lose.nextEntry()
        boolean f6 = lose.isSelectedAddToLeaderBoard()

        then:
        lose.isSelected(0)
        f1 && f4 && f5
        !f2
        !f3
        !f6
    }

    def 'Getting entries'() {
        given:
        String string = new String('menu')
        Lose lose = new Lose(10)

        when:
        String x = lose.getEntry(0)

        then:
        x == string
    }

    def 'Get score'(){
        given:
        Lose lose = new Lose(10)

        when:
        int x = lose.getScore()

        then:
        x == 10
    }

}
