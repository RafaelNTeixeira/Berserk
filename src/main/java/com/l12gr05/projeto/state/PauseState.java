package com.l12gr05.projeto.state;

import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.controller.menu.PauseController;
import com.l12gr05.projeto.model.menu.Pause;
import com.l12gr05.projeto.viewer.menuViewer.PauseViewer;
import com.l12gr05.projeto.viewer.menuViewer.Viewer;

public class PauseState extends State<Pause> {
    public PauseState(Pause model) {
        super(model);
    }

    @Override
    protected Viewer<Pause> getViewer() {
        return new PauseViewer(getModel());
    }

    @Override
    protected Controller<Pause> getController() {
        return new PauseController(getModel());
    }
}
