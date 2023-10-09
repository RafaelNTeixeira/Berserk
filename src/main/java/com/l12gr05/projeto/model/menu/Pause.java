package com.l12gr05.projeto.model.menu;

import java.util.Arrays;
import java.util.List;

public class Pause extends MenuManager{

    public Pause() {
        super(Arrays.asList("continue","new game", "exit", "exit to menu"));
    }
    public boolean isSelectedExit() {
        return isSelected(2);
    }
    public boolean isSelectedContinue() {
        return isSelected(0);
    }
    public boolean isSelectedNewGame() {
        return isSelected(1);
    }
    public boolean isSelectedGoToMenu() {
        return isSelected(3);
    }
}
