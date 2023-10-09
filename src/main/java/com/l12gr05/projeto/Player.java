package com.l12gr05.projeto;

public class Player {
    private String name;
    private String score;

    public Player(String n, String s) {
        name = n;
        score = s;
    }

    public String getName() {
        return name;
    }
    public String getScore() {
        return score;
    }
    public void setScore(String s) {
        score = s;
    }
}
