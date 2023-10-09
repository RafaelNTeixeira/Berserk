package com.l12gr05.projeto.model.menu;

import java.util.Arrays;
import java.util.List;

public class Win extends MenuManager{
    private final int Score;

    public Win(int Score) {
        super(Arrays.asList("menu", "leader board", "add Score to leaderboard"));
        this.Score = Score;
    }

    public int getScore(){return Score;}
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
