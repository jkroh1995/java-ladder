package controller.domain;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderMaker;
import domain.player.Players;
import util.InputHandler;

public class LadderController {

    InputHandler inputHandler = new InputHandler();
    LadderMaker ladderMaker = new LadderMaker();

    public Ladder getLadder(Players players) {
        LadderHeight ladderHeight = new LadderHeight(inputHandler.getLadderHeight());
        return new Ladder(ladderMaker.getLadder(players, ladderHeight.getHeight()));
    }
}
