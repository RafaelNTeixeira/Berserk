package com.l12gr05.projeto.viewer.menuViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.menu.Instruction;

public class InstructionViewer extends Viewer<Instruction> {
    public InstructionViewer(Instruction instruction) {
        super(instruction);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(0, 1), "[]=============================[]", "#E9FFDB");
        gui.drawText(new Position(0, 2), "||   i n s t r u c t i o n s   || ", "#E9FFDB");
        gui.drawText(new Position(0, 3), "||=============================||", "#E9FFDB");
        gui.drawText(new Position(0, 4), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 5), "||      gameplay constrols:    ||", "#E9FFDB");
        gui.drawText(new Position(0, 6), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 7), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 8), "||      w --> move upwards     ||", "#E9FFDB");
        gui.drawText(new Position(0, 9), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 10), "||      s --> move downwards   ||", "#E9FFDB");
        gui.drawText(new Position(0, 11), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 12), "||      d --> move right       ||", "#E9FFDB");
        gui.drawText(new Position(0, 13), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 14), "||      a --> move left        ||", "#E9FFDB");
        gui.drawText(new Position(0, 15), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 16), "||    arrow keys --> shoot     ||", "#E9FFDB");
        gui.drawText(new Position(0, 17), "||                             ||", "#E9FFDB");
        gui.drawText(new Position(0, 18), "||=============================||", "#E9FFDB");

        gui.drawText(new Position(2, 21), "Press enter to go back to menu", "#FFFFFF");
    }
}
