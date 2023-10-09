package com.l12gr05.projeto.model.game.elements;

import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.*;


public class Bullet extends Element {
    private final boolean heroBullet;
    private final char dir;

    public Bullet(int x, int y, char dir, boolean heroBullet) {
        super(x,y);
        this.heroBullet = heroBullet;
        this.dir = dir;
    }

    public Position move() {
        int x = position.getX();
        int y = position.getY();
        switch (dir){
            case 'r':
                return new Position(x + 1, y);
            case 'l':
                return new Position(x - 1, y);
            case 'u':
                return new Position(x, y - 1);
            case 'd':
                return new Position(x , y + 1);
            case 't':
                return new Position(x +1 , y - 1);
            case 'q':
                return new Position(x - 1 , y - 1);
            case 'a':
                return new Position(x - 1 , y + 1);
            case 'z':
                return new Position(x + 1, y + 1);
        }
        return new Position(x , y);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isHeroBullet() {
        return heroBullet;
    }

}