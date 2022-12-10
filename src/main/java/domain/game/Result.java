package domain.game;

import java.util.List;

public class Result {

    List<String> result;

    public Result(List<String>result){
        this.result = result;
    }

    public String get(int index) {
        return result.get(index);
    }
}
