package com.l12gr05.projeto.controller.game;

import com.l12gr05.projeto.Game;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena;
import com.l12gr05.projeto.model.game.elements.Bullet;
import com.l12gr05.projeto.model.game.elements.Enemy.Boss;
import com.l12gr05.projeto.model.game.elements.Enemy.King;
import com.l12gr05.projeto.model.game.elements.Enemy.Monster;
import com.l12gr05.projeto.model.game.elements.Hero;
import com.l12gr05.projeto.model.sounds.Sound;
import com.l12gr05.projeto.model.sounds.SoundControl;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class BulletController extends GameController {
    private long lastMovementBullet;

    public BulletController(Arena arena) {
        super(arena);
        this.lastMovementBullet = 0;
    }

    public void setlastMovementBullet(long time) {
        lastMovementBullet = time;
    }

    public boolean hasWalls(Position position) {
        int x = position.getX();
        int y = position.getY();
        return getModel().hasWalls(x,y);
    }

    public boolean hasMonster(Position position, Game game, SoundControl instance) {
        for (int i = 0; i < getModel().getMonsters().size() ; i++) {
            Monster monster = getModel().getMonsters().get(i);
            boolean bulletHitsMonster = monster.position.equals(position);

            if (bulletHitsMonster) {
                monster.decreaseEnergy(1);
                if (monster.getEnergy() <= 0) {
                    instance.start(Sound.ENEMYDEATH);
                    getModel().eraseMonster(i);
                    game.changeScoreBy(5);
                    int score = game.getScore();
                    getModel().setScore(score);
                }
                return true;
            }
        }
        return false;
    }

    public boolean hasKings(Position position, Game game, SoundControl instance) {
        for (int i = 0; i < getModel().getKings().size() ; i++) {
            King king = getModel().getKings().get(i);
            boolean bulletHitsKing = king.position.equals(position);

            if (bulletHitsKing) {
                king.decreaseEnergy(1);
                if (king.getEnergy() <= 0) {
                    instance.start(Sound.ENEMYDEATH);
                    getModel().eraseKing(i);
                    game.changeScoreBy(10);
                    int score = game.getScore();
                    getModel().setScore(score);
                }
                return true;
            }
        }
        return false;
    }

    public void stepMovimentBullet(Game game, SoundControl instance) {
        for (int i = 0; i < getModel().getBullets().size(); i++) {
            Bullet bullet = getModel().getBullets().get(i);

            Position position = bullet.move();
            bullet.setPosition(position);

            boolean bulletHitsBoss = (getModel().getLevel() == 6) && bullet.position.equals(getModel().getBoss().position) ;
            bulletHitsBossAction(i, bulletHitsBoss);

            boolean bulletHitsWall = hasWalls(bullet.position);
            bulletHitsElementAction(i, bulletHitsWall);

            boolean BulletHitsMonster = hasMonster(bullet.position, game, instance);
            bulletHitsElementAction(i, BulletHitsMonster);

            boolean BulletHitsKing = hasKings(bullet.position, game, instance);
            bulletHitsElementAction(i, BulletHitsKing);

            boolean BulletHitsHero = bullet.position.equals(getModel().getHero().position);
            bulletHitsHero(instance, i, BulletHitsHero);
        }
    }

    private void bulletHitsHero(SoundControl instance, int i, boolean bulletHitsHero) {
        if (bulletHitsHero) {
            instance.stop(Sound.HERODEATH);
            instance.start(Sound.HERODEATH);
            getModel().eraseBullet(i);
            Hero hero = getModel().getHero();
            hero.decreaseEnergy(1);
        }
    }

    private void bulletHitsElementAction(int i, boolean bulletHitsWall) {
        if (bulletHitsWall) {
            getModel().eraseBullet(i);
        }
    }

    private void bulletHitsBossAction(int i, boolean bulletHitsBoss) {
        if (bulletHitsBoss) {
            getModel().eraseBullet(i);
            Boss boss = getModel().getBoss();
            boss.decreaseEnergy(1);
        }
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        SoundControl instance = SoundControl.getInstance();
        if (time - lastMovementBullet > 30) {
            stepMovimentBullet(game, instance);
            this.lastMovementBullet = time;
        }
    }
}
