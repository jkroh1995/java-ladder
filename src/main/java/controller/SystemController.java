package controller;

import controller.domain.GameController;
import controller.domain.LadderController;
import controller.domain.PlayerController;
import domain.game.Result;
import domain.game.Winning;
import domain.ladder.Ladder;
import domain.game.LookUpNames;
import domain.player.Players;
import java.util.List;
import java.util.Map;
import util.InputHandler;
import view.OutputView;

public class SystemController {

    PlayerController playerController = new PlayerController();
    LadderController ladderController = new LadderController();
    GameController gameController = new GameController();
    OutputView outputView = new OutputView();
    InputHandler inputHandler = new InputHandler();

    public void run() {
        Players players = playerController.getPlayers(inputHandler);
        Winning winning = gameController.getWinning(inputHandler, players);
        Ladder ladder = ladderController.getLadder(players);
        outputView.printPlayersLadderWinnings(players, ladder, winning);
        Result result = gameController.getResult(players, ladder, winning);
        showResult(players, result);
    }

    private void showResult(Players players, Result result) {
        LookUpNames lookUpNames = gameController.getLookUpNames(inputHandler, players);
        if (!gameController.isRestart(lookUpNames)) {
            return;
        }
        List<String> nameList = gameController.getNamesList(lookUpNames, players);
        Map<String, String> resultMap = gameController.getInputNamesResult(players, result, nameList);
        outputView.printResult(nameList, resultMap);
        showResult(players, result);
    }
}
