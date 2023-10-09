package com.l12gr05.projeto.controller.menu;

import com.l12gr05.projeto.Game;
import com.l12gr05.projeto.state.GameState;
import com.l12gr05.projeto.state.InstructionsState;
import com.l12gr05.projeto.state.LeaderBoardState;
import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena;
import com.l12gr05.projeto.model.menu.Instruction;
import com.l12gr05.projeto.model.menu.Leaderboard;
import com.l12gr05.projeto.model.menu.Menu;

import com.l12gr05.projeto.model.sounds.Sound;
import com.l12gr05.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
        SoundControl.getInstance().start(Sound.MENUMUSIC);
    }

    public void newGameMusic(SoundControl instance) {
        instance.start(Sound.CHANGETAB);
        instance.stop(Sound.MENUMUSIC);
        instance.start(Sound.SOUNDTRACK);
    }

    public void changeTabSound(SoundControl instance) {
        instance.stop(Sound.CHANGETAB);
        instance.start(Sound.CHANGETAB);
    }

    public void stepNotNull(Game game, KeyStroke key, SoundControl instance) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp:
                getModel().previousEntry();
                break;
            case ArrowDown:
                getModel().nextEntry();
                break;
            case Enter:
                boolean selectedExit = getModel().isSelectedExit();
                if (selectedExit) {
                    game.setState(null);
                }
                boolean selectedStart = getModel().isSelectedStart();
                if (selectedStart) {
                    newGameMusic(instance);
                    game.setState(new GameState(new Arena(34, 24, 1)));
                    game.setScore(0);
                }
                boolean selectedLeaderBoard = getModel().isSelectedLeaderBoard();
                if (selectedLeaderBoard) {
                    changeTabSound(instance);
                    game.setState(new LeaderBoardState(new Leaderboard()));
                }
                boolean selectedInstructions = getModel().isSelectedInstructions();
                if (selectedInstructions) {
                    changeTabSound(instance);
                    game.setState(new InstructionsState(new Instruction()));
                }
                break;
            case Character:
                if (key.getCharacter() == 'e') {
                    instance.stopAll();
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
        SoundControl instanceMenu = SoundControl.getInstance();
        stepNotNull(game, key, instanceMenu);
    }
}
