package com.l12gr05.projeto.controller.menu;

import com.l12gr05.projeto.Game;
import com.l12gr05.projeto.model.menu.Leaderboard;
import com.l12gr05.projeto.state.MenuState;
import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.model.menu.Menu;

import com.l12gr05.projeto.model.sounds.Sound;
import com.l12gr05.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class LeaderboardController extends Controller<Leaderboard> {
    public LeaderboardController(Leaderboard leaderboard) {
        super(leaderboard);
    }

    public void changeTabSound(SoundControl instance) {
        instance.stop(Sound.CHANGETAB);
        instance.start(Sound.CHANGETAB);
    }

    public void stepNotNull(Game game, KeyStroke key, SoundControl instance) {
        switch (key.getKeyType()) {
            case Enter:
                changeTabSound(instance);
                boolean selectedEnter = getModel().isSelectedEnter();
                if (selectedEnter) {
                    game.setState(new MenuState(new Menu()));
                }
                game.setScore(0);
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
        SoundControl instanceLeader = SoundControl.getInstance();
        stepNotNull(game, key, instanceLeader);
    }
}
