package com.l12gr05.projeto.viewer.gameViewer


import com.l12gr05.projeto.model.game.elements.Hero
import com.l12gr05.projeto.graphics.GUILaterna
import spock.lang.Specification

class HeroViewerTest extends Specification {
    private def gui
    private def hero


    void setup() {
        hero = Mock(Hero.class)
        gui = Mock(GUILaterna.class)
    }

    def 'Hero Draw'() {
        given:
        def hero_viewer = new HeroViewer()

        when:
        hero_viewer.draw(hero, gui)

        then:
        1 * gui.drawHero(hero.getPosition())
    }
}
