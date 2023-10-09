package com.l12gr05.projeto.state;

import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.controller.menu.LoseController;
import com.l12gr05.projeto.model.menu.Lose;
import com.l12gr05.projeto.viewer.menuViewer.LoseViewer;
import com.l12gr05.projeto.viewer.menuViewer.Viewer;

public class LoseState extends State<Lose> {
    public LoseState(Lose model) {
        super(model);
    }

    @Override
    protected Viewer<Lose> getViewer() {
        return new LoseViewer(getModel());
    }

    @Override
    protected Controller<Lose> getController() {
        return new LoseController(getModel());
    }
}
