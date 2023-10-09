package com.l12gr05.projeto.viewer.gameViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena;
import com.l12gr05.projeto.model.game.elements.*;
import com.l12gr05.projeto.model.game.elements.Enemy.Boss;
import com.l12gr05.projeto.model.game.elements.Enemy.King;
import com.l12gr05.projeto.model.game.elements.Enemy.Monster;
import com.l12gr05.projeto.viewer.menuViewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        List<Wall> walls = getModel().getWalls();
        List<Monster> monsters = getModel().getMonsters();
        List<King> kings = getModel().getKings();
        List<Bullet> bullets = getModel().getBullets();
        List<Health> health = getModel().getHealth();
        Hero hero = getModel().getHero();
        Boss boss = getModel().getBoss();

        drawElements(gui, health, new HeartViewer());
        drawElements(gui, walls, new WallViewer());
        drawElements(gui, monsters, new MonsterViewer());
        drawElements(gui, kings, new KingViewer());
        drawElements(gui, bullets, new BulletViewer());
        drawElement(gui, hero, new HeroViewer());

        if (getModel().getLevel() == 6) {
            drawElement(gui, boss, new BossViewer());
            for (int i = 0; i < getModel().getBoss().getEnergy() ; i++ ) {
                gui.drawHeartBoss(new Position(33 - i, 0));
            }
        }
        int score = getModel().getScore();
        gui.drawText(new Position(0, 0), Integer.toString(score) , "#FFD700");
        for (int i = 0; i < getModel().getHero().getEnergy() ; i++ ) {
            gui.drawHeart(new Position(4 + i, 0));
        }
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements) drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
