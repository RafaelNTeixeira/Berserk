package com.l12gr05.projeto.state;

import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.controller.game.ArenaController;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.arena.Arena;
import com.l12gr05.projeto.viewer.gameViewer.GameViewer;
import com.l12gr05.projeto.viewer.menuViewer.Viewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}