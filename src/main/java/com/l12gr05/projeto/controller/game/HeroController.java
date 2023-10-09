package com.l12gr05.projeto.controller.game;

import com.l12gr05.projeto.Game;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena;
import com.l12gr05.projeto.model.game.elements.Health;
import com.l12gr05.projeto.model.game.elements.Hero;
import com.l12gr05.projeto.model.game.elements.Wall;

import com.l12gr05.projeto.model.sounds.Sound;
import com.l12gr05.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.List;

public class HeroController extends GameController {

    public HeroController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        Position moveLeft = getModel().getHero().moveLeft();
        moveHero(moveLeft);
    }

    public void moveHeroRight() {
        Position moveRight = getModel().getHero().moveRight();
        moveHero(moveRight);
    }

    public void moveHeroUp() {
        Position moveUp = getModel().getHero().moveUp();
        moveHero(moveUp);
    }

    public void moveHeroDown() {
        Position moveDown = getModel().getHero().moveDown();
        moveHero(moveDown);
    }

    private boolean canHeroMove(Position position) {
        List<Wall> walls = getModel().getWalls();
        for (Wall wall : walls) {
            boolean equals = wall.getPosition().equals(position);
            if (equals) return false;
        }

        return true;
    }

    public SoundControl getInstance() {
        return SoundControl.getInstance();
    }

    public void verifyMonsterCollisions(Position position, SoundControl instance) {
        Hero hero = getModel().getHero();
        monsterHitsHero(position, instance, hero);
        kingHitsHero(position, instance, hero);
    }

    private void monsterHitsHero(Position position, SoundControl instance, Hero hero) {
        for (int i = 0; i < getModel().getMonsters().size(); i++) {
            boolean monsterHitsHero = getModel().getMonsters().get(i).position.equals(position);
            monsterHitsHeroAction(instance, hero, monsterHitsHero);
        }
    }

    private void monsterHitsHeroAction(SoundControl instance, Hero hero, boolean monsterHitsHero) {
        if (monsterHitsHero) {
            instance.stop(Sound.HERODEATH);
            instance.start(Sound.HERODEATH);
            hero.decreaseEnergy(3);
        }
    }
    private void kingHitsHero(Position position, SoundControl instance, Hero hero) {
        for (int i = 0; i < getModel().getKings().size(); i++) {
            boolean kingHitsHero = getModel().getKings().get(i).position.equals(position);
            kingHitsHeroAction(instance, hero, kingHitsHero);
        }
    }
    private void kingHitsHeroAction(SoundControl instance, Hero hero, boolean kingHitsHero) {
        if (kingHitsHero) {
            instance.stop(Sound.HERODEATH);
            instance.start(Sound.HERODEATH);
            hero.decreaseEnergy(5);
        }
    }
    private void moveHero(Position position) {
        SoundControl instance = SoundControl.getInstance();
        boolean canMove = canHeroMove(position);
        if (canMove) {
            verifyMonsterCollisions(position, instance);
            Hero hero = getModel().getHero();
            hero.setPosition(position);
        }
    }

    public boolean checkHealth(){
        List<Health> healthList = getModel().getHealth();
        for (int i = 0 ; i < healthList.size(); i++) {
            boolean equals = healthList.get(i).getPosition().equals(getModel().getHero().getPosition());
            if (equals) {
                getModel().eraseHealth(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void step(Game game, KeyStroke key, long time) {
        boolean health = checkHealth();
        if (health) {
            Hero hero = getModel().getHero();
            hero.decreaseEnergy(-1);
        }
        if (key == null) {return;}
        keyStep(key);
    }

    private void keyStep(KeyStroke key) {
        if(key.getKeyType() == KeyType.Character){
            switch (key.getCharacter()){
                case'w':
                    moveHeroUp();
                    break;
                case'd':
                    moveHeroRight();
                    break;
                case's':
                    moveHeroDown();
                    break;
                case'a':
                    moveHeroLeft();
                    break;
            }
        }
    }
}
