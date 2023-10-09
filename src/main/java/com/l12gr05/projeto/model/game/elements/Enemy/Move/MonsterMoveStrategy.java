package com.l12gr05.projeto.model.game.elements.Enemy.Move;

import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Wall;

import java.util.List;
import java.util.Random;

public class MonsterMoveStrategy implements MoveStrategy {
    @Override
    public Position move(Position position, Position position_hero , boolean[][] matrixOfWalls) {
        Random random = new Random();
        return getPositionFromRandom(random, position);
    }

    public Position getPositionFromRandom(Random random, Position position){
        int x = random.nextInt(3) - 1;
        int y = random.nextInt(3) - 1;
        int xPos = position.getX() + x;
        int yPos = position.getY() + y;
        return new Position(xPos, yPos);
    }
}
