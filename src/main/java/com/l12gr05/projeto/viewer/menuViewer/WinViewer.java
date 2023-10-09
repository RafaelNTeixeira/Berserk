package com.l12gr05.projeto.viewer.menuViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.menu.Win;

public class WinViewer extends Viewer<Win> {
    public WinViewer(Win win) {
        super(win);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(12, 8), "you win!", "#FFD700");
        gui.drawText(new Position(4, 9), "i think you can do better", "#FFFFFF");
        gui.drawText(new Position(9, 10), "let's try again!", "#FFFFFF");
        gui.drawText(new Position(10, 11), "your score:" + getModel().getScore(), "#FFFFFF");

        drawText(gui);
    }

    private void drawText(GUI gui) {
        int numberEntries = getModel().getNumberEntries();
        for (int i = 0; i < numberEntries; i++) {
            String entry = getModel().getEntry(i);
            boolean selected = getModel().isSelected(i);
            int x = 13 - i*4;
            int y = 14 + i;
            gui.drawText(new Position(x, y), entry, selected ? "#FFD700" : "#FFFFFF");
        }
    }
}
