package domain.game;

import domain.player.Players;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LookUpNames {

    private static final String ALL = "all";

    String names;
    boolean reStart = true;

    public LookUpNames(String names) {
        if(names.equals("")){
            reStart=false;
        }
        this.names = names;
    }

    public List<String> getNamesList(Players players) {
        if(names.equals(ALL)){
            return players.getPlayersList();
        }
        return new ArrayList<>(Arrays.asList(makeNamesArray(names)));
    }

    public boolean getRestart() {
        return reStart;
    }

    private String[] makeNamesArray(String names) {
        String [] namesArray = names.split(",");
        for(int i=0;i<namesArray.length;i++){
            namesArray[i]= namesArray[i].replace(" ","");
        }
        return namesArray;
    }
}
