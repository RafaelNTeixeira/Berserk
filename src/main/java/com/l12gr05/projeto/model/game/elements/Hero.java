package com.l12gr05.projeto.model.game.elements;

import com.l12gr05.projeto.model.game.Position;

public class Hero extends Element {
    private int energy;

    public Hero(int x, int y) {
        super(x,y);
        energy = 15;
    }

    public Hero() {
        this(10, 10);
    }

    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public void decreaseEnergy(int x) {
        this.energy -= x;
    }

    public void setEnergy(int x) {
        energy = x;
    }

    public int getEnergy() {
        return energy;
    }


    public Position moveUp() {
        int x = position.getX();
        int oneUp = position.getY()-1;
        return new Position(x, oneUp);
    }

    public Position moveDown() {
        int x = position.getX();
        int oneDown = position.getY()+1;
        return new Position(x, oneDown);
    }

    public Position moveLeft() {
        int oneLeft = position.getX()-1;
        int y = position.getY();
        return new Position(oneLeft, y);
    }

    public Position moveRight() {
        int oneRight = position.getX()+1;
        int y = position.getY();
        return new Position(oneRight, y);
    }

    public void setPosition(Position position_new) {
        int y = position_new.getY();
        this.position.setY(y);
        int x = position_new.getX();
        this.position.setX(x);
    }

}
