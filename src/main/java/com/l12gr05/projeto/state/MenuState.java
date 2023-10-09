package com.l12gr05.projeto.state;


import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.controller.menu.MenuController;
import com.l12gr05.projeto.model.menu.Menu;
import com.l12gr05.projeto.viewer.menuViewer.MenuViewer;
import com.l12gr05.projeto.viewer.menuViewer.Viewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
