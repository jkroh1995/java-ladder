package view;

import java.util.Scanner;

public class InputView {

    private static final String REQUIRE_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUIRE_WINNING = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_HEIGHT = "최대 사다리 높이는 몇개인가요?";
    private static final String ASK_RESULT = "결과를 보고 싶은 사람은?";

    Scanner sc = new Scanner(System.in);

    public String readPlayersName() {
        System.out.println(REQUIRE_PLAYERS_NAME);
        return sc.nextLine();
    }

    public String readWinning() {
        System.out.println(REQUIRE_WINNING);
        return sc.nextLine();
    }

    public String readLadderHeight() {
        System.out.println(ASK_HEIGHT);
        return sc.nextLine();
    }

    public String readResult() {
        System.out.println(ASK_RESULT);
        return sc.nextLine();
    }
}
