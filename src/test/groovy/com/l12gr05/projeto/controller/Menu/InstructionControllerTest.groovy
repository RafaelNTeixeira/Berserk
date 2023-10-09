package com.l12gr05.projeto.controller.Menu


import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.l12gr05.projeto.Game
import com.l12gr05.projeto.controller.menu.InstructionController
import com.l12gr05.projeto.model.menu.Instruction
import com.l12gr05.projeto.model.sounds.SoundControl
import spock.lang.Specification

class InstructionControllerTest extends Specification{

    private def game
    private def key
    private def time
    private def instructionController
    private def instance
    private def instruction

    def setup(){
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        instruction = Mock(Instruction.class)
        instructionController = new InstructionController(instruction)
        instance = Mock(SoundControl.class)
    }

    def 'test key = null'(){
        given:
        key = null
        when:
        instructionController.step(game,key,time)
        then:
        0 * game.setState(_)
    }

    def 'test key Enter'(){
        given:
        key.getKeyType() >> KeyType.Enter;
        instructionController.getModel() >> instruction
        instruction.isSelectedEnter() >> true
        when:
        instructionController.stepNotNull(game,key,instance)
        then:
        1*instance.start(_)
        1 * game.setState(_)
    }

    def 'test key char'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        instructionController.stepNotNull(game,key,instance)
        then:
        1 * game.setState(_)
    }

    def 'test key char wit step'(){
        given:
        key.getKeyType() >> KeyType.Character;
        key.getCharacter() >> 'e'
        when:
        instructionController.step(game,key,time)
        then:
        1 * game.setState(_)
    }
}