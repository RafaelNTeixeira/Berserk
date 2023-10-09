package com.l12gr05.projeto.model.menu

import spock.lang.Specification

class InstructionTest extends Specification{

    def 'Getting entries'(){
        given:
        Instruction instruction = new Instruction()
        String entry = new String("press enter to go back to the menu")


        when:
        int x = instruction.getNumberEntries()
        boolean f1 = instruction.isSelected(0)
        boolean f3 = instruction.isSelected(1)
        boolean f2 = instruction.isSelectedEnter()
        String entryCheck = instruction.getEntry(0)

        then:
        x == 1
        f1 & f2
        !f3
        entryCheck == entry
    }
}
