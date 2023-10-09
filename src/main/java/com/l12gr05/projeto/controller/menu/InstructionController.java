package com.l12gr05.projeto.controller.menu;

import com.l12gr05.projeto.Game;
import com.l12gr05.projeto.state.MenuState;
import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.model.menu.Instruction;
import com.l12gr05.projeto.model.menu.Menu;

import com.l12gr05.projeto.model.sounds.Sound;
import com.l12gr05.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class InstructionController extends Controller<Instruction> {
    public InstructionController(Instruction instruction) {
        super(instruction);
    }

    public void stepNotNull(Game game, KeyStroke key, SoundControl instance) {
        switch (key.getKeyType()) {
            case Enter:
                instance.start(Sound.CHANGETAB);
                boolean selectedEnter = getModel().isSelectedEnter();
                if (selectedEnter) game.setState(new MenuState(new Menu()));
                break;
            case Character:
                if (key.getCharacter() == 'e') {
                    game.setState(null);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (key == null) return;
        SoundControl instanceInstruction = SoundControl.getInstance();
        stepNotNull(game, key, instanceInstruction);
    }
}