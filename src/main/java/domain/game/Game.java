package domain.game;

import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private static final String FILL = "-----";

    public List<String> makeResult(Players players, Winning winning, Ladder ladder) {
        List<String>result = new ArrayList<>();
        for(int i=0;i<players.size();i++){
            int position=i*2+1;
            position = getPosition(players, ladder, position);
            result.add(winning.getWinning(position/2));
        }
        return result;
    }

    public Map<String, String> getResult(Players players, Result result, List<String> wantLook) {
        Map<String, String> resultMap = new HashMap<>();
        List<String> playersList = players.getPlayersList();
        for(int i=0;i< wantLook.size();i++){
            int index= playersList.indexOf(wantLook.get(i));
            resultMap.put(players.getPlayerName(index), result.get(index));
        }
        return resultMap;
    }

    private int getPosition(Players players, Ladder ladder, int position) {
        for(int j = 0; j< ladder.getHeight(); j++){
            if(isMoveLeft(ladder, position, j)){
                position -=2;
                continue;
            }
            if(isMoveRight(players, ladder, position, j)){
                position +=2;
            }
        }
        return position;
    }

    private boolean isMoveRight(Players players, Ladder ladder, int position, int j) {
        return position != players.size()*2-1&& ladder.getBlock(j, position +1).equals(FILL);
    }

    private boolean isMoveLeft(Ladder ladder, int position, int j) {
        return ladder.getBlock(j, position -1).equals(FILL);
    }
}
