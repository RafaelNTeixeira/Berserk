package com.l12gr05.projeto.model.menu

import com.l12gr05.projeto.Player
import spock.lang.Specification

class LeaderboardTest extends Specification{

    def 'Getting, selecting and changing entries'(){
        given:
        Leaderboard leader = new Leaderboard()
        String entry = new String("press enter to back menu")

        when:
        String x = leader.getEntry(0)
        boolean f1 = leader.isSelectedEnter()

        then:
        entry == x
        f1
    }

    def 'get n of players'(){
        given:
        Leaderboard leader = new Leaderboard()

        when:
        int x = leader.players.size()

        then:
        x == leader.getNumberOfplayers()

    }

    def 'contains'(){
        given:
        Leaderboard leader = new Leaderboard()
        List<Player> playerList = new ArrayList<>()
        Player player = new Player('Ian', '100')
        Player player1 = new Player('Mansur', '0')
        playerList.add(player)

        when:
        boolean f1 = leader.contains(playerList, player)
        boolean f2 = leader.contains(playerList, player1)

        then:
        f1
        !f2
    }



    def 'Index'(){
        given:
        Leaderboard leader = new Leaderboard()
        List<Player> playerList = new ArrayList<>()
        Player player = new Player('Ian', '100')
        Player player1 = new Player('Mansur', '0')
        Player player2 = new Player('Rafael', '150')
        Player player4 = new Player('rgeg', '150')
        playerList.add(player)
        playerList.add(player1)
        playerList.add(player2)
        Collections.sort(playerList, new SortByScore());

        when:
        int index = leader.index(playerList, player)
        int index1 = leader.index(playerList, player1)
        int index2 = leader.index(playerList, player2)
        int index3 = leader.index(playerList, player4)

        then:
        index == 1
        index1 == 2
        index2 == 0
        index3 == -1
    }
}
