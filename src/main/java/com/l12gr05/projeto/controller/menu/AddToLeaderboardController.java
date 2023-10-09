package com.l12gr05.projeto.controller.menu;

import com.l12gr05.projeto.Game;
import com.l12gr05.projeto.model.menu.Leaderboard;
import com.l12gr05.projeto.state.LeaderBoardState;
import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.model.menu.AddToLeaderboard;

import com.l12gr05.projeto.model.sounds.Sound;
import com.l12gr05.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

import static java.lang.Character.toLowerCase;

public class AddToLeaderboardController extends Controller<AddToLeaderboard> {
    public AddToLeaderboardController(AddToLeaderboard lose) {
        super(lose);
    }

    public void stepNotNull(Game game, KeyStroke key, SoundControl instance) throws IOException {
        pressedEnter(game, key, instance);
        writeName(key);

        if (key.getKeyType() == KeyType.Backspace) {
            if (getModel().getName().length() == 0) {
                return;
            }
            getModel().delChar();
        }
    }

    private void writeName(KeyStroke key) {
        if (key.getKeyType() == KeyType.Character) {
            char c = key.getCharacter();
            c = toLowerCase(c);
            getModel().addChar(c);
        }
    }

    private void pressedEnter(Game game, KeyStroke key, SoundControl instance) throws IOException {
        if (key.getKeyType() == KeyType.Enter) {
            instance.start(Sound.CHANGETAB);
            getModel().addScore();
            game.setState(new LeaderBoardState(new Leaderboard()));
        }
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (key == null) return;
        SoundControl instance = SoundControl.getInstance();
        stepNotNull(game, key, instance);
    }
}
