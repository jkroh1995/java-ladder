package controller.domain;

import domain.game.Game;
import domain.game.LookUpNames;
import domain.game.Result;
import domain.game.Winning;
import domain.ladder.Ladder;
import domain.player.Players;
import java.util.List;
import java.util.Map;
import util.InputHandler;

public class GameController {

    Game game = new Game();

    public Winning getWinning(InputHandler inputHandler, Players players) {
        return new Winning(inputHandler.getWinning(players));
    }

    public Result getResult(Players players, Ladder ladder, Winning winning) {
        return new Result(game.makeResult(players, ladder, winning));
    }

    public LookUpNames getLookUpNames(InputHandler inputHandler, Players players) {
        String wantLook = inputHandler.getResult(players.getPlayersList());
        return new LookUpNames(wantLook);
    }

    public List<String> getNamesList(LookUpNames lookUpNames, Players players) {
        return lookUpNames.getNamesList(players);
    }

    public Map<String, String> getInputNamesResult(Players players, Result result, List<String> nameList) {
        return game.getResult(players, result, nameList);
    }

    public boolean isRestart(LookUpNames lookUpNames) {
        return lookUpNames.getRestart();
    }
}
