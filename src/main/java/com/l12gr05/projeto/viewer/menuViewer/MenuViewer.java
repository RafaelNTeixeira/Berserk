package com.l12gr05.projeto.viewer.menuViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.menu.Menu;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(12, 9), "menu", "#FFFFFF");

        int numberEntries = getModel().getNumberEntries();
        for (int i = 0; i < numberEntries; i++) {
            String entry = getModel().getEntry(i);
            boolean selected = getModel().isSelected(i);
            gui.drawText(new Position(12, 12 + i), entry, selected ? "#FFD700" : "#FFFFFF");
        }
    }
}
