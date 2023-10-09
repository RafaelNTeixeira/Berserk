package com.l12gr05.projeto.model.game.elements


import com.l12gr05.projeto.model.game.Position
import spock.lang.Specification

class BulletTest extends Specification{


    def 'Bullet creation'() {
        given:
        boolean b = true
        Bullet bulletr = new Bullet(10, 10, 'r' as char, b)

        when:
        boolean f1 = bulletr.isHeroBullet()

        then:

        f1
    }

    def 'Set and get position'(){
        given:
        Position position = new Position(10, 10)
        Position position1 = new Position(20, 20)
        boolean b = true
        Bullet bullet = new Bullet(10, 10, 'r' as char, b)

        when:
        Position position2 = bullet.getPosition()
        bullet.setPosition(position1)

        then:
        position == position2
        bullet.getPosition() == position1
    }

    def 'Move'() {
        given:
        boolean b = true
        Bullet bullet1 = new Bullet(5, 5, 'r' as char, b)
        Bullet bullet2 = new Bullet(5, 5, 'l' as char, b)
        Bullet bullet3 = new Bullet(5, 5, 'd' as char, b)
        Bullet bullet4 = new Bullet(5, 5, 'u' as char, b)
        Bullet bullet5 = new Bullet(5, 5, 'q' as char, b)
        Bullet bullet6 = new Bullet(5, 5, 't' as char, b)
        Bullet bullet7 = new Bullet(5, 5, 'a' as char, b)
        Bullet bullet8 = new Bullet(5, 5, 'z' as char, b)
        Bullet bullet9 = new Bullet(5, 5, 'h' as char, b)

        when:
        Position position1 = bullet1.move()
        Position position2 = bullet2.move()
        Position position3 = bullet3.move()
        Position position4 = bullet4.move()
        Position position5 = bullet5.move()
        Position position6 = bullet6.move()
        Position position7 = bullet7.move()
        Position position8 = bullet8.move()
        Position position9 = bullet9.move()

        then:
        position1.equals(new Position(6, 5))
        position2.equals(new Position(4, 5))
        position3.equals(new Position(5, 6))
        position4.equals(new Position(5, 4))
        position5.equals(new Position(4, 4))
        position6.equals(new Position(6, 4))
        position7.equals(new Position(4, 6))
        position8.equals(new Position(6, 6))
        position9.equals(new Position(5, 5))
    }
}
