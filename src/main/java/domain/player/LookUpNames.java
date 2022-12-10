package domain.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LookUpNames {

    String names;

    public LookUpNames(String names) {
        this.names = names;
    }

    public List<String> getNamesList(Players players) {
        if(names.equals("all")){
            return players.getPlayersList();
        }
        return new ArrayList<>(Arrays.asList(makeNamesArray(names)));
    }

    private String[] makeNamesArray(String names) {
        String [] namesArray = names.split(",");
        for(int i=0;i<namesArray.length;i++){
            namesArray[i]= namesArray[i].replace(" ","");
        }
        return namesArray;
    }
}
