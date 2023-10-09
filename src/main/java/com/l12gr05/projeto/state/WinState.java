package com.l12gr05.projeto.state;

import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.controller.menu.WinController;
import com.l12gr05.projeto.model.menu.Win;
import com.l12gr05.projeto.viewer.menuViewer.Viewer;
import com.l12gr05.projeto.viewer.menuViewer.WinViewer;

public class WinState extends State<Win> {
    public WinState(Win model) {
        super(model);
    }

    @Override
    protected Viewer<Win> getViewer() {return new WinViewer(getModel());}

    @Override
    protected Controller<Win> getController() {return new WinController(getModel());}
}
