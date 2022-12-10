package view;

import domain.game.Winning;
import domain.ladder.Ladder;
import domain.player.Players;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final int EACH_COLUMN_LENGTH = 7;
    private static final String PRINT_RESULT = "%s : %s\n";
    private static final String BLANK = " ";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printPlayersLadderWinnings(Players players, Ladder ladder, Winning winning) {
        printPlayer(players);
        printLadder(ladder);
        printWinning(winning);
    }

    public void printResult(List<String> wantLook, Map<String, String> result) {
        printBlankLine();
        for(int i=0;i< wantLook.size();i++){
            System.out.printf(PRINT_RESULT,wantLook.get(i), result.get(wantLook.get(i)));
        }
    }

    private void printBlankLine() {
        System.out.println();
    }

    private void printWinning(Winning winning) {
        for (int number = 0; number < winning.size(); number++) {
            String win = winning.getWinning(number);
            System.out.print(win + BLANK.repeat(EACH_COLUMN_LENGTH - win.length()));
        }
        printBlankLine();
    }

    private void printLadder(Ladder ladder) {
        for(int height=0;height<ladder.getHeight();height++){
            for(int width=0; width< ladder.getWidth();width++){
                System.out.print(ladder.getBlock(height, width));
            }
            printBlankLine();
        }
    }

    private void printPlayer(Players players) {
        for (int number = 0; number < players.size(); number++) {
            String name = players.getPlayerName(number);
            System.out.print(name + BLANK.repeat(EACH_COLUMN_LENGTH - name.length()));
        }
        printBlankLine();
    }
}
