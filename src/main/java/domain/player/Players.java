package domain.player;

import java.util.ArrayList;
import java.util.List;

public class Players {

    List<Player> players = new ArrayList<>();

    public Players(List<String>players){
        for(String name : players){
            this.players.add(new Player(name));
        }
    }

    public int size() {
        return players.size();
    }

    public String getPlayerName(int number) {
        return players.get(number).getName();
    }

    public List<String> getPlayersList() {
        List<String>playersList = new ArrayList<>();
        for(int i=0;i< players.size();i++){
            playersList.add(getPlayerName(i));
        }
        return playersList;
    }
}
