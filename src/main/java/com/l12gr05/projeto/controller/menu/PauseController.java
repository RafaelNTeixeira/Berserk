package com.l12gr05.projeto.controller.menu;

import com.l12gr05.projeto.Game;
import com.l12gr05.projeto.state.GameState;
import com.l12gr05.projeto.state.MenuState;
import com.l12gr05.projeto.state.State;
import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena;
import com.l12gr05.projeto.model.menu.Menu;
import com.l12gr05.projeto.model.menu.Pause;

import com.l12gr05.projeto.model.sounds.Sound;
import com.l12gr05.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class PauseController extends Controller<Pause> {
    public PauseController(Pause pause) {
        super(pause);
    }

    public void continueSound(SoundControl instance) {
        instance.start(Sound.CHANGETAB);
        instance.stop(Sound.MENUMUSIC);
        instance.start(Sound.SOUNDTRACK);
    }

    public void newGameSound(SoundControl instance) {
        instance.start(Sound.CHANGETAB);
        instance.start(Sound.SOUNDTRACK);
    }

    public void changeTabSound(SoundControl instance) {
        instance.stop(Sound.CHANGETAB);
        instance.start(Sound.CHANGETAB);
    }


    public void notNullStep(Game game, KeyStroke key, SoundControl instance) {
        switch (key.getKeyType()) {
            case ArrowUp:
                getModel().previousEntry();
                break;
            case ArrowDown:
                getModel().nextEntry();
                break;
            case Enter:
                boolean selectedExit = getModel().isSelectedExit();
                if (selectedExit){
                    game.setState(null);
                    return;
                }
                boolean selectedContinue = getModel().isSelectedContinue();
                if (selectedContinue) {
                    continueSound(instance);
                    State oldState = game.getOldState();
                    game.setState(oldState);
                    return;
                }
                boolean selectedNewGame = getModel().isSelectedNewGame();
                if (selectedNewGame) {
                    newGameSound(instance);
                    game.setState(new GameState(new Arena(34, 24, 1)));
                    game.setScore(0);
                    return;
                }
                boolean selectedGoToMenu = getModel().isSelectedGoToMenu();
                if (selectedGoToMenu) {
                    changeTabSound(instance);
                    game.setState(new MenuState(new Menu()));
                    return;
                }
                break;
            case Character:
                if (key.getCharacter() == 'e') {
                    game.setState(null);
                }
                if (key.getCharacter() == 'q') {
                    game.setState(new MenuState(new Menu()));
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (key == null) return;
        SoundControl instancePause = SoundControl.getInstance();
        notNullStep(game, key, instancePause);
    }
}

