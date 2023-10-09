package com.l12gr05.projeto.controller.menu;

import com.l12gr05.projeto.Game;
import com.l12gr05.projeto.model.menu.AddToLeaderboard;
import com.l12gr05.projeto.model.menu.Leaderboard;
import com.l12gr05.projeto.model.menu.Lose;
import com.l12gr05.projeto.model.menu.Menu;
import com.l12gr05.projeto.state.AddToLeaderboardState;
import com.l12gr05.projeto.state.LeaderBoardState;
import com.l12gr05.projeto.state.MenuState;
import com.l12gr05.projeto.controller.Controller;

import com.l12gr05.projeto.model.sounds.Sound;
import com.l12gr05.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;


public class LoseController extends Controller<Lose> {
    public LoseController(Lose lose) {
        super(lose);
        SoundControl instance = SoundControl.getInstance();
        startMenuMusic(instance);
    }

    public void startMenuMusic(SoundControl instance) {
        instance.stop(Sound.SOUNDTRACK);
        instance.start(Sound.MENUMUSIC);
    }

    public void changeTabSound(SoundControl instance) {
        instance.stop(Sound.CHANGETAB);
        instance.start(Sound.CHANGETAB);
    }

    public void stepNotNullLose(Game game, KeyStroke key, SoundControl instance) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp:
                getModel().previousEntry();
                break;
            case ArrowDown:
                getModel().nextEntry();
                break;
            case Enter:
                changeTabSound(instance);
                boolean selectedMenu = getModel().isSelectedMenu();
                if (selectedMenu) {
                    game.setState(new MenuState(new Menu()));
                }

                boolean selectedLeaderBoard = getModel().isSelectedLeaderBoard();
                if (selectedLeaderBoard) {
                    game.setState(new LeaderBoardState( new Leaderboard()));
                }

                boolean selectedAddToLeaderBoard = getModel().isSelectedAddToLeaderBoard();
                if (selectedAddToLeaderBoard) {
                    int score = getModel().getScore();
                    game.setState(new AddToLeaderboardState(new AddToLeaderboard(score)));
                }
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
        SoundControl instanceLose = SoundControl.getInstance();
        stepNotNullLose(game, key, instanceLose);
    }
}
