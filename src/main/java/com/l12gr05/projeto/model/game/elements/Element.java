package com.l12gr05.projeto.model.game.elements;

import com.l12gr05.projeto.model.game.Position;

public abstract class Element {
    public Position position;

    public Element(int x, int y) {
        position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

}
