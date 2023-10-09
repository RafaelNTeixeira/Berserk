package com.l12gr05.projeto.state;

import com.l12gr05.projeto.controller.Controller;
import com.l12gr05.projeto.controller.menu.LeaderboardController;
import com.l12gr05.projeto.model.menu.Leaderboard;
import com.l12gr05.projeto.viewer.menuViewer.LeaderboardViewer;
import com.l12gr05.projeto.viewer.menuViewer.Viewer;


public class LeaderBoardState extends State<Leaderboard> {
    public LeaderBoardState(Leaderboard model) {
        super(model);
    }

    @Override
    protected Viewer<Leaderboard> getViewer() {
        return new LeaderboardViewer(getModel());
    }

    @Override
    protected Controller<Leaderboard> getController() {
        return new LeaderboardController(getModel());
    }
}
