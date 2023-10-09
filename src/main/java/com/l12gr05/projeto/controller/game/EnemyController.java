package com.l12gr05.projeto.controller.game;

import com.l12gr05.projeto.Game;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena;
import com.l12gr05.projeto.model.game.elements.Enemy.Boss;
import com.l12gr05.projeto.model.game.elements.Enemy.Enemy;
import com.l12gr05.projeto.model.game.elements.Enemy.King;
import com.l12gr05.projeto.model.game.elements.Enemy.Monster;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.KingMoveStrategy;
import com.l12gr05.projeto.model.game.elements.Hero;

import com.l12gr05.projeto.model.sounds.Sound;
import com.l12gr05.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.List;

public class EnemyController extends GameController {
    private long lastMovementEnemy;
    private long lastMovementBoss;
    private long lastSpawn;

    public EnemyController(Arena arena) {
        super(arena);
        this.lastMovementEnemy = 0;
    }

    public void lastMovementEnemy(long time) {
        lastMovementEnemy = time;
    }

    public void lastMovementBoss(long time) {
        lastMovementBoss = time;
    }

    public void lastSpawn(long time) {
        lastSpawn = time;
    }

    public boolean canMonsterMove(Position position) {
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > 33 || position.getY() > 23)
            return false;

        int x = position.getX();
        int y = position.getY();
        if (getModel().hasWalls(x,y)) {
            return false;
        }

        List<Monster> monsters = getModel().getMonsters();
        for (Enemy enemy : monsters) {
            boolean equals1 = enemy.getPosition().equals(position);
            if (equals1) {
                return false;
            }
        }

        List<King> kings = getModel().getKings();
        for (Enemy enemy : kings) {
            boolean equals2 = enemy.getPosition().equals(position);
            if (equals2) return false;
        }
        return true;
    }

    public char DirOfShoot(Position positionMonster) {
        Position positionHero = getModel().getHero().getPosition();

        if (positionHero.getX() == positionMonster.getX()) {
            if (positionMonster.getY() > positionHero.getY()) {
                return 'u';
            }
            if (positionMonster.getY() < positionHero.getY()) {
                return 'd';
            }
        }

        if (positionHero.getY() == positionMonster.getY()) {
            if (positionMonster.getX() > positionHero.getX()) {
                return 'l';
            } else {
                return 'r';
            }
        }
        return 'n';
    }

    public void stepMovementKing(SoundControl instance ){
        List<King> kings = getModel().getKings();
        for (Enemy king : kings) {
            double kingHeroDistance = king.position.getDistance(getModel().getHero().position);
            if (kingHeroDistance < 20) {
                king.setMoveStrategy(new KingMoveStrategy());
            }
            Position position = king.move(getModel().getHero().position ,getModel().getMatrixOfWalls() );
            king.setPosition(position);
            boolean kingHitsHero = position.equals(getModel().getHero().position);
            if (kingHitsHero) {
                instance.stop(Sound.HERODEATH);
                instance.start(Sound.HERODEATH);
                Hero hero = getModel().getHero();
                hero.decreaseEnergy(5);
            }
        }
    }

    public void stepMovementMonster(SoundControl instance){
        List<Monster> monsters = getModel().getMonsters();
        for (Enemy monster : monsters) {
            Position position;
            while (true) {
                boolean monsterCanMove = canMonsterMove(position = monster.move(getModel().getHero().position, getModel().getMatrixOfWalls()));
                if (monsterCanMove) break;
            }
            monster.setPosition(position);
            boolean monsterHitsHero = position.equals(getModel().getHero().position);
            if (monsterHitsHero) {
                instance.stop(Sound.HERODEATH);
                instance.start(Sound.HERODEATH);
                Hero hero = getModel().getHero();
                hero.decreaseEnergy(3);
            }
            Position pos = monster.getPosition();
            char c = DirOfShoot(pos);
            if (c != 'n') {
                instance.stop(Sound.SHOOTING);
                instance.start(Sound.SHOOTING);
                getModel().shoot(c, pos, false);

            }
        }
    }

    public void stepMovementEnemy(Game game, SoundControl instance ) {
        int score = game.getScore();
        getModel().setScore(score);
        stepMovementMonster( instance);
        stepMovementKing( instance);
    }


    public void stepMovementBoss(long time, SoundControl instance) {
        Boss boss = getModel().getBoss();
        Position position = boss.move(getModel().getHero().position ,getModel().getMatrixOfWalls() );
        boss.setPosition(position);
        boolean BossHitsHero = position.getDistance(getModel().getHero().position) < 2;
        if (BossHitsHero) {
            instance.stop(Sound.HERODEATH);
            instance.start(Sound.HERODEATH);
            getModel().getHero().decreaseEnergy(7);
        }
        getModel().shoot('r', boss.position, false);
        getModel().shoot('l', boss.position, false);
        getModel().shoot('u', boss.position, false);
        getModel().shoot('d', boss.position, false);
        getModel().shoot('t', boss.position, false);
        getModel().shoot('q', boss.position, false);
        getModel().shoot('a', boss.position, false);
        getModel().shoot('z', boss.position, false);
        this.lastMovementBoss = time;
    }


    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        SoundControl instance = SoundControl.getInstance();

        if (time - lastMovementEnemy > 500) {
            stepMovementEnemy(game,instance);
            this.lastMovementEnemy = time;
        }

        if(getModel().getLevel() == 6){
            if (time - lastMovementBoss > 800) {
                stepMovementBoss(time, instance);
            }
            if (time - lastSpawn > 6000) {
                getModel().spawnMonster();
                lastSpawn = time;
            }
        }
    }
}
