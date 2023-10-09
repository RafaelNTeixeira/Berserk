package com.l12gr05.projeto.controller.game;

import com.l12gr05.projeto.Game;
import com.l12gr05.projeto.model.game.elements.Hero;
import com.l12gr05.projeto.state.*;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena;
import com.l12gr05.projeto.model.menu.Lose;
import com.l12gr05.projeto.model.menu.Menu;
import com.l12gr05.projeto.model.menu.Pause;
import com.l12gr05.projeto.model.menu.Win;
import com.l12gr05.projeto.model.sounds.Sound;
import com.l12gr05.projeto.model.sounds.SoundControl;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class ArenaController extends GameController {
    private HeroController heroController;
    private EnemyController enemyController;
    private BulletController bulletController;
    private long lastBullet;

    public ArenaController(Arena arena) {
        super(arena);
        this.heroController = new HeroController(arena);
        this.enemyController = new EnemyController(arena);
        this.bulletController = new BulletController(arena);
    }

    public void setLastBullet(long time){
        lastBullet = time;
    }

    public boolean checkNextLvl(Position position){
        int x = position.getX();
        int y = position.getY();
        return x > 33 || y > 23;
    }

    public boolean checkPrevLvl(Position position){
        int x = position.getX();
        int y = position.getY();
        return x <= 0 || y <= 0;
    }

    public void ShootSound(SoundControl instance){
        instance.stop(Sound.SHOOTING);
        instance.start(Sound.SHOOTING);
    }

    public void steplastBullet(KeyStroke key, SoundControl instance){
        Position position = getModel().getHero().getPosition();
        switch (key.getKeyType()){
            case ArrowUp: getModel().shoot('u', position, true);ShootSound(instance); break;
            case ArrowDown: getModel().shoot('d', position, true);ShootSound(instance); break;
            case ArrowLeft: getModel().shoot('l', position, true);ShootSound(instance); break;
            case ArrowRight: getModel().shoot('r', position, true);ShootSound(instance); break;
            default:break;
        }
    }

    public void stepVoidKey(Game game, long time) throws IOException {
        int score = game.getScore();
        heroController.step(game, null, time);

        if(getModel().getLevel() == 6 && getModel().getBoss().getEnergy() <= 0){
            game.setState(new WinState(new Win(score)));
            return;
        }
        canGoToNextLevel(game);
        canGoToPrevLevel(game);
        bulletController.step(game, null, time);
        enemyController.step(game, null, time);
        hasNoEnergy(game, score);
    }

    private void hasNoEnergy(Game game, int score) {
        if (getModel().getHero().getEnergy() <= 0) {
            game.setState(new LoseState(new Lose(score)));
        }
    }

    private void canGoToPrevLevel(Game game) {
        boolean canGoToPrevLevel = checkPrevLvl(getModel().getHero().getPosition());
        if (canGoToPrevLevel) {
            game.setState(new GameState(new Arena(34, 25, getModel().getLevel() - 1)));
        }
    }

    private void canGoToNextLevel(Game game) {
        boolean canGoToNextLevel = checkNextLvl(getModel().getHero().getPosition());
        if (canGoToNextLevel){
            int N_lvl = getModel().getLevel() + 1;
            game.setState(new GameState(new Arena(34, 25, N_lvl)));
        }
    }

    public void stepNonVoid(Game game, KeyStroke key, long time, SoundControl instance) throws IOException {
        int score = game.getScore();
        Hero hero = this.getModel().getHero();
        boolean quitKey = key.getKeyType() == KeyType.Character && key.getCharacter() == 'q';
        boolean exitKey = key.getKeyType() == KeyType.Character && key.getCharacter() == 'e';

        if (quitKey) {
            instance.stop(Sound.SOUNDTRACK);
            instance.start(Sound.MENUMUSIC);
            game.setState(new MenuState(new Menu()));
            return;
        }
        if (hero.getEnergy() <= 0) {
            instance.start(Sound.HERODEATH);
            instance.stop(Sound.SOUNDTRACK);
            instance.start(Sound.MENUMUSIC);
            game.setState(new LoseState(new Lose(score)));
            return;
        }
        if (exitKey) {
            game.setState(null);
            return;
        }
        bulletStep(key, time, instance);
        pressedEscape(game, key, time, instance);
    }

    private void bulletStep(KeyStroke key, long time, SoundControl instance) {
        if (time - lastBullet > 250 ) {
            steplastBullet(key, instance);
            this.lastBullet = time;
        }
    }

    private void pressedEscape(Game game, KeyStroke key, long time, SoundControl instance) throws IOException {
        if (key.getKeyType() == KeyType.Escape) {
            instance.stopAll();
            instance.start(Sound.MENUMUSIC);
            State state = game.getState();
            game.setOldState(state);
            game.setState(new PauseState(new Pause()));
        }
        else {
            heroController.step(game, key, time);
            enemyController.step(game, key, time);
        }
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        SoundControl instance = SoundControl.getInstance();

        if (key == null) {
            stepVoidKey(game, time);
        }
        else {
            stepNonVoid(game, key, time, instance);
        }
    }

    public void setEnemyController(EnemyController e){
        enemyController = e;
    }
    public void setHeroController(HeroController h){
        heroController = h;
    }
    public void setBulletController(BulletController h){
        bulletController = h;
    }
}
