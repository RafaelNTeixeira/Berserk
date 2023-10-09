package com.l12gr05.projeto.model.menu

import spock.lang.Specification

class AddLeaderboardTest extends Specification{


    def'test open close print'(){
        given:
        def out = Mock(PrintWriter.class)
        def addLeader = new AddToLeaderboard(10)
        addLeader.setOut(out)
        when:
        addLeader.addScore()
        then:
        1 * out.println("Noname;10")
        1 * out.close()
    }

    def'test open close print with name'(){
        given:
        def out = Mock(PrintWriter.class)
        def addLeader = new AddToLeaderboard(10)
        addLeader.setName('mans')
        addLeader.setOut(out)
        when:
        addLeader.addScore()
        then:
        1 * out.println("mans;10")
        1 * out.close()
    }

    def 'Add Leader creation'() {
        given:
        AddToLeaderboard addLeader = new AddToLeaderboard(10)

        when:
        int x = addLeader.getNumberEntries()
        int y = addLeader.getScore()

        then:
        x == 2
        y == 10
    }

    def 'Getting, selecting and changing entries'(){
        given:
        AddToLeaderboard addLeader = new AddToLeaderboard(10)
        String menu = new String("menu")
        String leader = new String("leader board")

        when:
        boolean fmenu = addLeader.isSelectedMenu()
        boolean fleader2 = addLeader.isSelectedLeaderBoard()
        addLeader.nextEntry()
        boolean fleader = addLeader.isSelectedLeaderBoard()
        boolean fmenu2 = addLeader.isSelectedMenu()
        boolean f1 = addLeader.isSelected(1)
        String y = addLeader.getEntry(0)
        addLeader.previousEntry()
        String z = addLeader.getEntry(1)

        then:
        f1 && fmenu && fleader
        y == menu
        z == leader
        !fleader2
        !fmenu2
    }

    def 'Entry boundaries prev'(){
        given:
        AddToLeaderboard addLeader = new AddToLeaderboard(10)

        when:
        addLeader.nextEntry()
        addLeader.previousEntry()

        then:
        addLeader.isSelected(0)
    }

    def 'Entry boundaries prev'(){
        given:
        AddToLeaderboard addLeader = new AddToLeaderboard(10)

        when:
        addLeader.previousEntry()
        addLeader.nextEntry()


        then:
        addLeader.isSelected(0)
    }
    def 'Entry boundaries prev'(){
        given:
        AddToLeaderboard addLeader = new AddToLeaderboard(10)

        when:
        addLeader.previousEntry()
        addLeader.previousEntry()

        then:
        addLeader.isSelected(0)
    }

    def 'Entry boundaries prev'(){
        given:
        AddToLeaderboard addLeader = new AddToLeaderboard(10)

        when:
        addLeader.previousEntry()

        then:
        addLeader.isSelected(1)
    }

    def 'Entry boundaries next'(){
        given:
        AddToLeaderboard addLeader = new AddToLeaderboard(10)

        when:
        addLeader.nextEntry()
        addLeader.nextEntry()

        then:
        addLeader.isSelected(0)
    }

    def 'Deleting char'() {
        given:
        AddToLeaderboard addLeader = new AddToLeaderboard(10)
        addLeader.setName("Ian")
        String name = new String("Ia")

        when:
        addLeader.delChar()
        String name1 = addLeader.getName()

        then:
        name == name1
    }

}
