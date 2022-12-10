package controller.domain;

import domain.player.Players;
import util.InputHandler;

public class PlayerController {

    public Players getPlayers(InputHandler inputHandler) {
        return new Players(inputHandler.getPlayersName());
    }
}
