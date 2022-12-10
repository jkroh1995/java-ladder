package util;

import domain.player.Players;

public class WinningValidator {

    private static final String ERROR_NUMBER = "[ERROR] 결과는 참여할 사람의 수와 같아야 합니다.";

    String winning;

    public WinningValidator(String winning, Players players) {
        this.winning = winning;
        validate(players);
    }

    private void validate(Players players) {
        validateNumberOfResult(players);
    }

    private void validateNumberOfResult(Players players) {
        String [] winningArray = winning.split(",");
        if(winningArray.length!=players.size()){
            throw new IllegalArgumentException(ERROR_NUMBER);
        }
    }
}
