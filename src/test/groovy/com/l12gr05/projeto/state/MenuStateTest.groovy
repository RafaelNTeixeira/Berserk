package com.l12gr05.projeto.state


import com.l12gr05.projeto.controller.menu.MenuController
import com.l12gr05.projeto.model.menu.Menu
import com.l12gr05.projeto.viewer.menuViewer.MenuViewer
import spock.lang.Specification

class MenuStateTest extends Specification{

    private def menu

    def setup(){
        menu = new Menu()
    }

    def 'Get Viewer'() {
        given:
        MenuState menuState = new MenuState(menu)
        MenuViewer viewer = new MenuViewer(menu)

        when:
        MenuViewer menuViewer = menuState.getViewer()
        int x = menuViewer.getModel().getNumberEntries()

        then:
        x == viewer.getModel().getNumberEntries()
    }

    def 'Get Controller'() {
        given:
        MenuState menuState = new MenuState(menu)
        MenuController controller = new MenuController(menu)

        when:
        MenuController menuController = menuState.getController()
        int x = menuController.getModel().getNumberEntries()

        then:
        x == controller.getModel().getNumberEntries()
    }
}
