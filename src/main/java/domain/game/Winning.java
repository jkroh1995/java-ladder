package domain.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winning {

    List<String> winning;

    public Winning(String winning) {
        String[] winnings = winning.split(",");
        for (int index = 0; index < winnings.length; index++) {
            winnings[index] = winnings[index].replace(" ", "");
            winnings[index] = " " + winnings[index];
        }
        this.winning = new ArrayList<>(Arrays.asList(winnings));
    }

    public int size() {
        return winning.size();
    }

    public String getWinning(int number) {
        return winning.get(number);
    }
}
