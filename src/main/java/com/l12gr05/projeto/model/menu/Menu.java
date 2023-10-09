package com.l12gr05.projeto.model.menu;


import java.util.Arrays;
import java.util.List;

public class Menu extends MenuManager{
    public Menu() {
        super(Arrays.asList("start", "exit", "leader board", "instructions"));
    }
    public boolean isSelectedExit() {
        return isSelected(1);
    }
    public boolean isSelectedStart() {
        return isSelected(0);
    }
    public boolean isSelectedInstructions() {
        return isSelected(3);
    }
    public boolean isSelectedLeaderBoard() {
        return isSelected(2);
    }
}
