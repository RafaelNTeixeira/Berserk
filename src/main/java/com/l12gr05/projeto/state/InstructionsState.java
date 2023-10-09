package com.l12gr05.projeto.state;

import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.controller.menu.InstructionController;
import com.l12gr05.projeto.model.menu.Instruction;
import com.l12gr05.projeto.viewer.menuViewer.InstructionViewer;
import com.l12gr05.projeto.viewer.menuViewer.Viewer;


public class InstructionsState extends State<Instruction> {
    public InstructionsState(Instruction model) {
        super(model);
    }

    @Override
    protected Viewer<Instruction> getViewer() {
        return new InstructionViewer(getModel());
    }

    @Override
    protected Controller<Instruction> getController() {
        return new InstructionController(getModel());
    }
}