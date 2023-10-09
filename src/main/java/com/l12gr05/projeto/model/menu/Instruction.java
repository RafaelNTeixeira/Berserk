package com.l12gr05.projeto.model.menu;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Instruction extends MenuManager{

    public Instruction() {
        super(List.of("press enter to go back to the menu"));
    }
    public boolean isSelectedEnter() {
        return true;
    }
}