package com.l12gr05.projeto.state


import com.l12gr05.projeto.controller.menu.InstructionController
import com.l12gr05.projeto.model.menu.Instruction
import com.l12gr05.projeto.viewer.menuViewer.InstructionViewer
import spock.lang.Specification

class InstructionsStateTest extends Specification{
    private def instructionsModel

    def setup() {
        instructionsModel = new Instruction()
    }

    def 'Get Viewer'() {
        given:
        InstructionsState instructionsState = new InstructionsState(instructionsModel)
        InstructionViewer viewer = new InstructionViewer(instructionsModel)


        when:
        InstructionViewer instructionViewer = instructionsState.getViewer()
        int x = instructionViewer.getModel().getNumberEntries()

        then:
        x == viewer.getModel().getNumberEntries()
    }

    def 'Get Controller'() {
        given:
        InstructionsState instructionsState = new InstructionsState(instructionsModel)
        InstructionController controller = new InstructionController(instructionsModel)

        when:
        InstructionController instructionController = instructionsState.getController()
        int x = instructionController.getModel().getNumberEntries()

        then:
        x == controller.getModel().getNumberEntries()
    }
}
