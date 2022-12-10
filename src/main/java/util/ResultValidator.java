package util;

import domain.player.Players;
import java.util.List;

public class ResultValidator {

    private static final String ERROR_NOT_CONTAIN = "[ERROR] 참여한 사람의 이름만 입려해야 합니다.";

    String result;
    
    public ResultValidator(String result, List<String> players) {
        this.result = result;
        validate(players);
    }

    private void validate(List<String> players) {
        String [] resultList = result.split(",");
        for(int i=0; i< resultList.length; i++){
            resultList[i] = resultList[i].replace(" ","");
            if(!resultList[i].equals("all")&&!resultList[i].equals("")&&!players.contains(resultList[i])){
                throw new IllegalArgumentException(ERROR_NOT_CONTAIN);
            }
        }
    }
}
