package com.l12gr05.projeto.graphics;

import com.l12gr05.projeto.model.game.Position;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public interface GUI {

    KeyStroke getNextAction() throws IOException;
    void drawHeart(Position position);
    void drawHeartBoss(Position position);
    void drawHero(Position position);
    void drawWall(Position position);
    void drawMonster(Position position);
    void drawBoss(Position position);
    void drawKing(Position position);
    void drawHeroBullet(Position position);
    void drawEnemyBullet(Position position);
    void drawText(Position position, String text, String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;

}
