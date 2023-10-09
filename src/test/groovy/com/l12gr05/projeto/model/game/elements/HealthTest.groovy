package com.l12gr05.projeto.model.game.elements


import com.l12gr05.projeto.model.game.Position
import spock.lang.Specification

class HealthTest extends Specification{

    def 'Health creation' () {
        given:
        Health health = new Health(50, 50)
        Position position = new Position(50, 50)

        when:
        Position position1 = health.getPosition()

        then:
        position == position1
    }

}
