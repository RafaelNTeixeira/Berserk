package com.l12gr05.projeto.model.menu;

import com.l12gr05.projeto.Player;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Leaderboard extends MenuManager{
    private final List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public Leaderboard() throws IOException {
        super(List.of("press enter to back menu"));
        File file = new File("src/main/resources/Leaders");
        Scanner sc = new Scanner(file, UTF_8);
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                List<String> words = List.of(line.split(";"));
                Player p = new Player (words.get(0), words.get(1));
                boolean contains = contains(players, p);
                if (contains) {
                    int index = index(players, p);
                    players.get(index).setScore(words.get(1));
                }
                else {
                    players.add(p);
                }
            }
        sc.close();
        players.sort(new SortByScore());
    }

    public int index(List<Player> lst, Player p) {
        for (int i = 0; i < lst.size(); i++) {
            String name = lst.get(i).getName();
            if (name.equals(p.getName())) {
                return i;
            }
        }
        return -1;
    }
    public boolean contains(List<Player> lst, Player p) {
        for (Player player : lst) {
            String name = player.getName();
            if (name.equals(p.getName())) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfplayers() {
        return players.size();
    }
    public boolean isSelectedEnter() {
        return true;
    }
}

class SortByScore implements Comparator<Player> {
    @Override public int compare(Player a, Player b) {
        return Integer.parseInt(b.getScore()) - Integer.parseInt(a.getScore());
    }
}
