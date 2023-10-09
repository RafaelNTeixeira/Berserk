package com.l12gr05.projeto.controller.menu;

import com.l12gr05.projeto.Game;
import com.l12gr05.projeto.state.AddToLeaderboardState;
import com.l12gr05.projeto.state.LeaderBoardState;
import com.l12gr05.projeto.state.MenuState;
import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.model.menu.AddToLeaderboard;
import com.l12gr05.projeto.model.menu.Leaderboard;
import com.l12gr05.projeto.model.menu.Menu;
import com.l12gr05.projeto.model.menu.Win;
import com.l12gr05.projeto.model.sounds.Sound;
import com.l12gr05.projeto.model.sounds.SoundControl;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class WinController extends Controller<Win> {
    public WinController(Win win) {super(win);}

    public void changeTabSound(SoundControl instance) {
        instance.stop(Sound.CHANGETAB);
        instance.start(Sound.CHANGETAB);
    }

    public void stepNotNull(Game game, KeyStroke key, SoundControl instance) throws IOException  {
        switch (key.getKeyType()) {
            case ArrowUp:
                getModel().previousEntry();
                break;
            case ArrowDown:
                getModel().nextEntry();
                break;
            case Enter:
                boolean selectedMenu = getModel().isSelectedMenu();
                if (selectedMenu) {
                    changeTabSound(instance);
                    game.setState(new MenuState(new Menu()));
                }
                boolean selectedLeaderBoard = getModel().isSelectedLeaderBoard();
                if (selectedLeaderBoard) {
                    changeTabSound(instance);
                    game.setState(new LeaderBoardState(new Leaderboard()));
                }
                boolean selectedAddToLeaderBoard = getModel().isSelectedAddToLeaderBoard();
                if (selectedAddToLeaderBoard) {
                    changeTabSound(instance);
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
        SoundControl instanceWin = SoundControl.getInstance();
        stepNotNull(game,key,instanceWin);
    }
}
