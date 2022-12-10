package controller;

import domain.game.Result;
import domain.game.Winning;
import domain.game.Game;
import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderMaker;
import domain.player.LookUpNames;
import domain.player.Players;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import util.InputHandler;
import view.OutputView;

public class GameController {

    Game game = new Game();
    OutputView outputView = new OutputView();
    InputHandler inputHandler = new InputHandler();
    LadderMaker ladderMaker = new LadderMaker();

    public void run() {
        Players players = new Players(inputHandler.getPlayersName());
        Winning winning = new Winning(inputHandler.getWinning(players));
        LadderHeight ladderHeight = new LadderHeight(inputHandler.getLadderHeight());
        Ladder ladder = new Ladder(ladderMaker.getLadder(players, ladderHeight.getHeight()));
        outputView.printPlayersLadderWinnings(players, ladder, winning);
        Result result = new Result(game.makeResult(players, winning, ladder));
        showResult(players, result);
    }

    private void showResult(Players players, Result result) {
        String wantLook = inputHandler.getResult(players.getPlayersList());
        if (wantLook.equals("")) {
            return;
        }
        LookUpNames lookUpNames = new LookUpNames(wantLook);
        List<String>nameList= lookUpNames.getNamesList(players);
        Map<String, String> resultMap = game.getResult(players, result, nameList);
        outputView.printResult(nameList, resultMap);
        showResult(players, result);
    }
}
