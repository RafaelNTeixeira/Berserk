package com.l12gr05.projeto.model.game.elements.Enemy;

import com.l12gr05.projeto.model.game.elements.Enemy.Move.KingMoveStrategy;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.MoveStrategy;

public class Boss extends Enemy {

    public Boss(int x, int y) {
        super(x,y);
    }
    @Override
    protected int generateEnergy() {
        return 12;
    }
    @Override
    protected MoveStrategy generateMoveStrategy() {
        return new KingMoveStrategy();
    }
}
