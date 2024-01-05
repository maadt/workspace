import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class Janken {
    // フィールド追加
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in)); // 定数として扱う
    private Map<Integer, String> hands = new HashMap<Integer, String>();
    private List<String> results = new ArrayList<String>();
    private int playerHand;
    private int cpuHand;

    public Janken() {
        this.hands.put(1, "グー");
        this.hands.put(2, "チョキ");
        this.hands.put(3, "パー");
        this.results.add("あいこ");
        this.results.add("負け");
        this.results.add("勝ち");
    }

    // 実行処理
    public void execution() {
        // 処理追加
        this.inputPlayerHand();
    }
    // 選択肢を表示する
    private void showMenu(Map<Integer, String> menu) {
        menu.forEach((key, value) -> System.out.print(key + ":" + value + " "));
        System.out.println();
    }

    // プレイヤーの手を入力する
    private void inputPlayerHand() {
        while (true) {
            this.showMenu(this.hands);
            // プレイヤーの手をセット
            this.playerHand = this.inputNum();
            // １～３の範囲内であれば繰り返し処理を終了する
            if (this.playerHand > 0 && this.playerHand <= this.hands.size()) {
                break;
            }
            System.out.println("該当する半角数字で入力してください");
        }
        this.setCpuHand();
        this.printHands();
        this.printResult();
        this.inputNextAction();
    }
    // 数字入力と数値であるかの判断
    private int inputNum() {
        try {
            return Integer.parseInt(BR.readLine());
        } catch (NumberFormatException | IOException e) {
        // NumberFormatExceptionが発生した場合 → 数値以外が入力されたと判断する
        // 強制的に 0 を返却
        return 0;
        }
    }
    //CPUの入力処理
    private void setCpuHand() {
        this.cpuHand = new Random().nextInt(this.hands.size()) + 1;
    }
    private void printHands() {
        System.out.println("Player : " + this.hands.get(this.playerHand));
        System.out.println("CPU    : " + this.hands.get(this.cpuHand));
    }
    private void printResult() {
        int resultIndex = this. judgeResult();
        System.out.println("Result : " + this.results.get(resultIndex));
    }
    private int judgeResult() {
        if (this.playerHand == this.cpuHand) {
            return 0;
        } else if ((this.playerHand == 1 && this.cpuHand == 2) || (this.playerHand == 2 && this.cpuHand == 3) || (this.playerHand == 3 && this.cpuHand == 1)) {
            return 2;
        } else {
            return 1;
        }
    }
}

class Execution {
    public static void main(String[] args) {
        Janken janken = new Janken();
        janken.execution();
    }
}
