package com.l12gr05.projeto.model.game.elements.Enemy;

import com.l12gr05.projeto.model.game.elements.Element;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.MoveStrategy;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Wall;

import java.util.List;

public abstract class Enemy extends Element {

    private MoveStrategy move;
    private int energy;

    public Enemy(int x, int y) {
        super(x,y);
        MoveStrategy move_ = generateMoveStrategy();
        int energy_ = generateEnergy();
        this.move = move_;
        this.energy = energy_;
    }

    public void decreaseEnergy(int x) {
        this.energy -= x;
    }
    public int getEnergy(){return energy; }
    public MoveStrategy getMoveStrategy() {return move;}

    public void setMoveStrategy(MoveStrategy strategy) {
        move = strategy;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    protected abstract MoveStrategy generateMoveStrategy();
    protected abstract int generateEnergy();

    public Position move(Position position_hero, boolean[][] matrixOfWalls) {
        return this.move.move(position, position_hero, matrixOfWalls);
    }
}
