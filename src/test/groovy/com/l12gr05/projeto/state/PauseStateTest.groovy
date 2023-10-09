package com.l12gr05.projeto.state


import com.l12gr05.projeto.model.menu.Pause
import com.l12gr05.projeto.viewer.menuViewer.PauseViewer
import com.l12gr05.projeto.controller.menu.PauseController
import spock.lang.Specification

class PauseStateTest extends Specification{

    private def pause

    def setup(){
        pause = new Pause()
    }

    def 'Get viewer'() {
        given:
        PauseState pauseState = new PauseState(pause)
        PauseViewer viewer = new PauseViewer(pause)

        when:
        PauseViewer pauseViewer = pauseState.getViewer()
        int x = pauseViewer.getModel().getNumberEntries()

        then:
        x == viewer.getModel().getNumberEntries()
    }

    def 'Get controller'() {
        given:
        PauseState pauseState = new PauseState(pause)
        PauseController controller = new PauseController(pause)

        when:
        PauseController pauseController = pauseState.getController()
        int x = pauseController.getModel().getNumberEntries()

        then:
        x == controller.getModel().getNumberEntries()
    }
}
