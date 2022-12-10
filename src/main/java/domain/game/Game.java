package domain.game;

import domain.ladder.Ladder;
import domain.player.Players;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private static final String FILL = "-----";

    public List<String> makeResult(Players players, Ladder ladder, Winning winning) {
        List<String> result = new ArrayList<>();
        for (int player = 0; player < players.size(); player++) {
            int position = player * 2 + 1;
            position = getPosition(players, ladder, position);
            result.add(winning.getWinning(position / 2));
        }
        return result;
    }

    public Map<String, String> getResult(Players players, Result result, List<String> wantLook) {
        Map<String, String> resultMap = new HashMap<>();
        List<String> playersList = players.getPlayersList();
        for (int player = 0; player < wantLook.size(); player++) {
            int index = playersList.indexOf(wantLook.get(player));
            resultMap.put(players.getPlayerName(index), result.get(index));
        }
        return resultMap;
    }

    private int getPosition(Players players, Ladder ladder, int position) {
        for (int height = 0; height < ladder.getHeight(); height++) {
            if (isMoveLeft(ladder, position, height)) {
                position -= 2;
                continue;
            }
            if (isMoveRight(players, ladder, position, height)) {
                position += 2;
            }
        }
        return position;
    }

    private boolean isMoveRight(Players players, Ladder ladder, int position, int height) {
        return position != players.size() * 2 - 1 && ladder.getBlock(height, position + 1).equals(FILL);
    }

    private boolean isMoveLeft(Ladder ladder, int position, int height) {
        return ladder.getBlock(height, position - 1).equals(FILL);
    }
}
