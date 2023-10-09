package com.l12gr05.projeto.controller;

import com.l12gr05.projeto.Game;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, KeyStroke key, long time) throws IOException;
}
