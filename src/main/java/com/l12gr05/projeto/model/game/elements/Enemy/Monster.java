package com.l12gr05.projeto.model.game.elements.Enemy;

import com.l12gr05.projeto.model.game.elements.Enemy.Move.MonsterMoveStrategy;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.MoveStrategy;

public class Monster extends Enemy {
    public Monster(int x, int y) {
        super(x,y);
    }

    @Override
    protected int generateEnergy() {
        return 1;
    }
    @Override
    protected MoveStrategy generateMoveStrategy() {
        return new MonsterMoveStrategy();
    }
}
