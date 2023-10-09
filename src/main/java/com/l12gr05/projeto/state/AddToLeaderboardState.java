package com.l12gr05.projeto.state;

import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.controller.menu.AddToLeaderboardController;
import com.l12gr05.projeto.model.menu.AddToLeaderboard;
import com.l12gr05.projeto.viewer.menuViewer.AddToLeaderboardViewer;
import com.l12gr05.projeto.viewer.menuViewer.Viewer;

public class AddToLeaderboardState extends State<AddToLeaderboard> {
    public AddToLeaderboardState(AddToLeaderboard model) {
        super(model);
    }

    @Override
    protected Viewer<AddToLeaderboard> getViewer() {
        return new AddToLeaderboardViewer(getModel());
    }

    @Override
    protected Controller<AddToLeaderboard> getController() {
        return new AddToLeaderboardController(getModel());
    }
}

