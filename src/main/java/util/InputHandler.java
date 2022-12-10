package util;

import domain.player.Players;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import view.InputView;
import view.OutputView;

public class InputHandler {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public List<String> getPlayersName() {
        try{
            String names = inputView.readPlayersName();
            new NameValidator(names);
            String[] namesArray = makeNamesArray(names);
            return new ArrayList<>(Arrays.asList(namesArray));
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getPlayersName();
        }
    }

    public String getWinning(Players players) {
        try{
            String winning = inputView.readWinning();
            new WinningValidator(winning, players);
            return winning;
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getWinning(players);
        }
    }

    public int getLadderHeight() {
        try{
            String height = inputView.readLadderHeight();
            new HeightValidator(height);
            return Integer.parseInt(height);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getLadderHeight();
        }
    }

    public String getResult(List<String> players) {
        try{
            String result = inputView.readResult();
            new ResultValidator(result, players);
            return result;
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getResult(players);
        }
    }

    private String[] makeNamesArray(String names) {
        String [] namesArray = names.split(",");
        for(int i=0;i<namesArray.length;i++){
            namesArray[i]= namesArray[i].replace(" ","");
        }
        return namesArray;
    }
}
