package com.l12gr05.projeto.model.menu;

import java.util.Arrays;
import java.util.List;

public class Lose extends MenuManager{
    private final int Score;
    public Lose(int Score) {
        super(Arrays.asList("menu", "leader board", "add score to leader board"));
        this.Score = Score;
    }
    public int getScore() {return Score;}

    public boolean isSelectedMenu() {
        return isSelected(0);
    }
    public boolean isSelectedLeaderBoard() {
        return isSelected(1);
    }
    public boolean isSelectedAddToLeaderBoard() {
        return isSelected(2);
    }
}
