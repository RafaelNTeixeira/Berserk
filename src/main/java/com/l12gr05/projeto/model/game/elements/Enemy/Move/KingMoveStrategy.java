package com.l12gr05.projeto.model.game.elements.Enemy.Move;

import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Wall;

import java.util.*;

public class KingMoveStrategy implements MoveStrategy {

    public boolean canMove(Position position) {
        return position.getX() >= 0 && position.getY() >= 0 && position.getX() <= 33 && position.getY() <= 23;
    }

    public boolean contains(boolean[][] matrixOfWalls, Position position) {
        int x = position.getX();
        int y = position.getY();
        return matrixOfWalls[x][y];
    }

    @Override
    public Position move(Position position, Position position_hero , boolean[][] matrixOfWalls) {
        boolean equals = position.equals(position_hero);
        if (equals) {
            return position;
        }
        List<Position> steps = new ArrayList<>() ;
        steps.add(new Position(1,0)); steps.add(new Position(-1,0));
        steps.add(new Position(0,-1)); steps.add(new Position(0,1));
        steps.add(new Position(1,1)); steps.add(new Position(-1,1));
        steps.add(new Position(1,-1)); steps.add(new Position(-1,-1));

        boolean[][]  used = new boolean[35][27];
        Position[][] parent = new Position[35][27];
        Queue<Position> q = new ArrayDeque<>();
        q.add(position);

        int x = position.getX();
        int y = position.getY();
        used[x][y] = true;

        while (!q.isEmpty()) {
            Position tmp = q.remove();
            for (Position step : steps) {
                Position tmp2 = tmp.add(step);
                boolean canMove = canMove(tmp2);
                if (canMove) {
                    boolean contains = contains(matrixOfWalls, tmp2);
                    if (!contains) {
                        if (!used[tmp2.getX()][tmp2.getY()]) {
                            used[tmp2.getX()][tmp2.getY()] = true;
                            q.add(tmp2);
                            parent[tmp2.getX()][tmp2.getY()] = new Position(tmp.getX(), tmp.getY());
                        }
                    }
                }
                boolean equals1 = tmp2.equals(position_hero);
                if (equals1) {
                    break;
                }
            }
        }

        int x1 = position_hero.getX();
        int y1 = position_hero.getY();
        if (!used[x1][y1]) {
            return position;
        }

        Position tmp = new Position(position_hero.getX(), position_hero.getY());
        while (true) {
            boolean equals2 = parent[tmp.getX()][tmp.getY()].equals(position);
            if (equals2) break;
            tmp = parent[tmp.getX()][tmp.getY()];
        }

        return new Position(tmp.getX(), tmp.getY());
    }
}
