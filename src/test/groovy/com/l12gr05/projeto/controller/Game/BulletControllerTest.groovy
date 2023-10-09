package com.l12gr05.projeto.controller.Game

import com.l12gr05.projeto.Game
import com.googlecode.lanterna.input.KeyStroke
import com.l12gr05.projeto.controller.game.BulletController
import com.l12gr05.projeto.model.game.Position
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena
import com.l12gr05.projeto.model.game.elements.Bullet
import com.l12gr05.projeto.model.sounds.SoundControl
import spock.lang.Specification

class BulletControllerTest extends Specification{

    private def arena
    private def bulletController
    private def game
    private def key
    private def time
    private def instance

    def setup(){
        arena = new Arena(34,24,1)
        bulletController = new BulletController(arena)
        game = Mock(Game.class)
        key = Mock(KeyStroke.class)
        time = 5000
        instance = Mock(SoundControl.class)
    }

    def 'Test cons'() {
        expect:
        bulletController.getModel().getWidth() == 34
        bulletController.getModel().getHeight() == 24
        bulletController.lastMovementBullet == 0
    }

    def 'Has Walls'(){
        given:
        Position position = new Position(16,3)
        Position position1 = new Position(5, 5)

        when:
        boolean f1 = bulletController.hasWalls(position)
        boolean f2 = bulletController.hasWalls(position1)

        then:
        f1
        !f2
    }

    def 'Has Monster'(){
        given:
        Position position = new Position(0,2)

        when:
        boolean f1 = bulletController.hasMonster(position, game , instance)

        then:
        !f1
    }

    def 'Has Monster 2'(){
        given:
        Position position1 = new Position(8, 9)
        int m_size = arena.getMonsters().size()
        def score = arena.getScore()
        game.getScore() >> 5

        when:
        boolean f2 = bulletController.hasMonster(position1, game, instance)
        int m_size2 = arena.getMonsters().size()

        then:
        score + 5 == bulletController.getModel().getScore()
        f2
        m_size2 == m_size-1
        1 * instance.start(_)
        1 * game.changeScoreBy(_);
    }

    def 'King life 1'(){
        given:
        Position position = new Position(0,2)
        Position position1 = new Position(3, 4)

        when:
        boolean f1 = bulletController.hasKings(position, game, instance)
        boolean f2 = bulletController.hasKings(position1, game, instance)

        then:
        !f1
        f2
    }

    def 'King life not die'(){
        given:
        Position position1 = new Position(3, 4)
        int k_size = arena.getKings().size()

        when:
        bulletController.hasKings(position1, game, instance)


        then:
        arena.getKings().size() == k_size
    }

    def 'King life 0'(){
        given:
        Position position1 = new Position(3, 4)
        def k_size = arena.getKings().size()
        def score = arena.getScore()
        game.getScore() >> 10

        when:
        bulletController.hasKings(position1, game, instance)
        bulletController.hasKings(position1, game,  instance)

        then:
        bulletController.getModel().getKings().size() == k_size - 1
        1 * instance.start(_)
        1 * game.changeScoreBy(_)
        bulletController.getModel().getScore() == 10 + score
    }

    def 'King life < 0'(){
        given:
        Position position1 = new Position(3, 4)
        int k_size = arena.getKings().size()

        when:
        bulletController.hasKings(position1, game,  instance)
        bulletController.hasKings(position1, game, instance)
        bulletController.hasKings(position1, game, instance)

        then:
        arena.getKings().size() == k_size - 1
    }

    def 'Step bullet hits wall'(){
        given:
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(0, 2, 'd' as char, true)
        list_b.add(bullet)
        arena.setBullets(list_b)

        when:
        bulletController.stepMovimentBullet(game, instance)

        then:
        arena.getBullets().size() == 0
    }

    def 'Step bullet hits monster'(){
        given:
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(8, 10, 'u' as char, true)
        list_b.add(bullet)
        arena.setBullets(list_b)

        when:
        bulletController.stepMovimentBullet(game, instance)

        then:
        arena.getBullets().size() == 0
    }

    def 'Step bullet hits King'(){
        given:
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(3, 5, 'u' as char, true)
        list_b.add(bullet)
        arena.setBullets(list_b)

        when:
        bulletController.stepMovimentBullet(game, instance)

        then:
        arena.getBullets().size() == 0
    }

    def 'Step bullet hits Hero'(){
        given:
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(7, 21, 'u' as char, false)
        list_b.add(bullet)
        arena.setBullets(list_b)
        def energy = bulletController.getModel().getHero().getEnergy()

        when:
        bulletController.stepMovimentBullet(game, instance)

        then:
        arena.getBullets().size() == 0
        energy - 1 == bulletController.getModel().getHero().getEnergy()
        1 * instance.stop(_)
        1 * instance.start(_)
    }

    def 'Step bullet hits Boss'(){
        given:
        Arena arena1 = new Arena(34,24,6)
        BulletController bulletController1 = new BulletController(arena1)
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(18, 13, 'u' as char, true)
        list_b.add(bullet)
        arena1.setBullets(list_b)
        def energy = bulletController1.getModel().boss.energy

        when:
        bulletController1.stepMovimentBullet(game, instance)

        then:
        arena1.getBullets().size() == 0
        energy - 1 == bulletController1.getModel().boss.energy
    }

    def 'Step 30 '(){
        given:
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(3, 3, 'd' as char, true)
        list_b.add(bullet)
        arena.setBullets(list_b)

        when:
        bulletController.step(game, key, 30)

        then:
        bullet.position.x == 3
        bullet.position.y == 3
    }

    def 'Step  29 + 10'(){
        given:
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(3, 3, 'd' as char, true)
        list_b.add(bullet)
        arena.setBullets(list_b)
        bulletController.setlastMovementBullet(20)

        when:
        bulletController.step(game, key, 30)

        then:
        bullet.position.x == 3
        bullet.position.y == 3
    }

    def 'Step  35'(){
        given:
        List<Bullet> list_b = new ArrayList<>()
        Bullet bullet = new Bullet(3, 3, 'd' as char, true)
        list_b.add(bullet)
        arena.setBullets(list_b)

        when:
        bulletController.step(game, key, 35)

        then:
        bullet.position.x == 3
        bullet.position.y == 4
    }
}
