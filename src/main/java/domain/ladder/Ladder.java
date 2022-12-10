package domain.ladder;

public class Ladder {

    String [][] ladder;

    public Ladder(String[][] ladder) {
        this.ladder = ladder;
    }

    public int getHeight() {
        return ladder.length;
    }

    public int getWidth() {
        return ladder[0].length;
    }

    public String getBlock(int row, int column) {
        return ladder[row][column];
    }
}
