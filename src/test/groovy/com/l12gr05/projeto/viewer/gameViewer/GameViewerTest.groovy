package com.l12gr05.projeto.viewer.gameViewer

import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.game.elements.Hero
import com.l12gr05.projeto.graphics.GUILaterna
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena
import com.l12gr05.projeto.model.game.elements.Bullet
import com.l12gr05.projeto.model.game.elements.Enemy.Boss
import com.l12gr05.projeto.model.game.elements.Enemy.King
import com.l12gr05.projeto.model.game.elements.Enemy.Monster
import com.l12gr05.projeto.model.game.elements.Wall
import spock.lang.Specification

class GameViewerTest extends Specification{

    private def gui

    def 'Draw elements'(){
        given:
        Arena arena = new Arena(50, 50, 1)
        GameViewer gameViewer = new GameViewer(arena)
        gui = Mock(GUILaterna.class)
        Monster monster = arena.getMonsters()[0]
        Wall wall = arena.getWalls()[1]
        King king = arena.getKings()[0]
        Hero hero = arena.getHero()
        int life = hero.getEnergy()
        List<Bullet> list = new ArrayList<>()
        Bullet hbullet = new Bullet(5, 5, 'u' as char, true)
        Bullet ebullet = new Bullet(5, 10, 'd' as char, false)
        list.add(hbullet)
        list.add(ebullet)
        arena.setBullets(list)

        when:
        gameViewer.drawElements(gui)

        then:

        1*gui.drawEnemyBullet(ebullet.getPosition())
        1*gui.drawHeroBullet(hbullet.getPosition())
        1*gui.drawWall(wall.getPosition())
        1*gui.drawMonster(monster.getPosition())
        1*gui.drawHero(hero.getPosition())
        1*gui.drawKing(king.getPosition())
        1*gui.drawText(_,_,_)
        1 * gui.drawHeart(new Position(4, 0))
        1 * gui.drawHeart(new Position(5, 0))
        13*gui.drawHeart(_)

    }

    def 'draw elements lvl 6'(){
        given:
        Arena arena = new Arena(50, 50, 6)
        GameViewer gameViewer = new GameViewer(arena)
        gui = Mock(GUILaterna.class)
        Boss boss = arena.getBoss()


        when:
        gameViewer.drawElements(gui)

        then:

        17*gui.drawHeart(_)
        1*gui.drawBoss(boss.getPosition())
        1 * gui.drawHeartBoss(new Position(33, 0))
        1 * gui.drawHeartBoss(new Position(32, 0))
        10*gui.drawHeartBoss(_)

    }
}
