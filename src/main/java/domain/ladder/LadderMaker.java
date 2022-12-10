package domain.ladder;

import domain.player.Players;
import java.util.Random;

public class LadderMaker {

    private static final String FILL = "------";
    private static final String BLANK = "      ";
    private static final String START = "  ";
    private static final String DIVIDE = "|";

    Random random = new Random();

    public String[][] getLadder(Players players, int height) {
        String[][] ladder = new String[height][players.size() * 2];
        makeLadder(players.size()*2, height, ladder);
        return ladder;
    }

    private void makeLadder(int width, int height, String[][] ladder) {
        for (int row = 0; row < height; row++) {
            makeEachRow(width, ladder, row);
        }
    }

    private void makeEachRow(int width, String[][] ladder, int row) {
        for (int column = 0; column < width; column++) {
            start(ladder, row, column);
            divide(ladder, row, column);
            formalFill(ladder, row, column);
            formalBlank(ladder, row, column);
        }
    }

    private void formalBlank(String[][] ladder, int row, int column) {
        if (column%2==0&&column!=0&&!ladder[row][column - 2].equals(FILL)) {
            int index = random.nextInt(2);
            if (index == 0) {
                ladder[row][column] = BLANK;
                return;
            }
            ladder[row][column] = FILL;
        }
    }


    private void formalFill(String[][] ladder, int row, int column) {
        if (column%2==0&&column != 0 && ladder[row][column - 2].equals(FILL)) {
            ladder[row][column] = BLANK;
        }
    }

    private void start(String[][] ladder, int row, int column) {
        if (column == 0) {
            ladder[row][column] = START;
        }
    }

    private void divide(String[][] ladder, int row, int column) {
        if (column % 2 == 1) {
            ladder[row][column] = DIVIDE;
        }
    }
}
