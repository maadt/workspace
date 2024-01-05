import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Janken {
    private Map<Integer, String> hands = new HashMap<Integer, String>();//じゃんけんの手
    private List<String> results = new ArrayList<String>();//勝敗の結果表示
    public Janken() {//各フィールドに初期値を設定する
    hands.put(1, "グー");
    hands.put(2, "チョキ");
    hands.put(3, "パー");
    results.add("あいこ");
    results.add("負け");
    results.add("勝ち");
    }
    private int playerChoice;
    public void execution() {

        while(true) {
            try {
                BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
                );
                displayHands();
                int playerChoice = Integer.parseInt(br.readLine());
                if (playerChoice < 1 || playerChoice > 3) {
                    throw new IOException();
                } else {
                    this.playerChoice = playerChoice;
                    break;
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("該当する半角英数字で入力してください");
            }
        }
    }
    private void displayHands() {
        hands.forEach((key, value) -> {
            System.out.print(key + ":" + value + " ");
        });
        System.out.println();
    }
}

class Execution {
    public static void main(String[] args) {
        Janken janken = new Janken();
        janken.execution();
    }
}
