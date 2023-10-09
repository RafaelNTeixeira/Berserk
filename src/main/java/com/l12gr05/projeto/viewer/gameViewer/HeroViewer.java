package com.l12gr05.projeto.viewer.gameViewer;

import com.l12gr05.projeto.graphics.GUI;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Hero;

public class HeroViewer implements ElementViewer<Hero> {
    @Override
    public void draw(Hero hero, GUI gui) {
        Position heroPosition = hero.getPosition();
        gui.drawHero(heroPosition);
    }
}
