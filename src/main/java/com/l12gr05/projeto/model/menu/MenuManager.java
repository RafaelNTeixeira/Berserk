package com.l12gr05.projeto.model.menu;

import java.util.List;

public abstract class MenuManager {

    private final List<String> entries;
    private int currentEntry = 0;

    public MenuManager(List<String> entries){
        this.entries = entries;
    }
    public void nextEntry(){
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }
    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }
    public String getEntry(int i) {
        return entries.get(i);
    }
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public int getCurrentEntry() {
        return currentEntry;
    }
    public int getNumberEntries() {
        return this.entries.size();
    }
}
