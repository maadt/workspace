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
    private Map <Integer, String> action = new HashMap<Integer, String>();
    private List<String> results = new ArrayList<String>();
    private List<Integer> grades = new ArrayList<Integer>();
    private int playerHand;
    private int cpuHand;
    private int playerAction;
    private int draw = 0;
    private int lose = 0;
    private int win = 0;

    public Janken() {
        this.hands.put(1, "グー");
        this.hands.put(2, "チョキ");
        this.hands.put(3, "パー");
        this.action.put(1, "もう一度対戦する");
        this.action.put(2, "終了する");
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
        this.inputPlayerAction();
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
            this.grades.add(0);
            return 0;
        } else if ((this.playerHand == 1 && this.cpuHand == 2) || (this.playerHand == 2 && this.cpuHand == 3) || (this.playerHand == 3 && this.cpuHand == 1)) {
            this.grades.add(2);
            return 2;
        } else {
            this.grades.add(1);
            return 1;
        }
    }
    private void showNextMenu(Map<Integer, String> nextMenu) {
        nextMenu.forEach((key, value) -> System.out.print(key + ":" + value + " "));
        System.out.println();
    }
    private void inputPlayerAction() {
        while (true) {
            this.showNextMenu(this.action);
            this.playerAction = this.inputNum();
            if (this.playerAction > 0 && this.playerAction <= this.action.size()) {
                break;
            }
            System.out.println("該当する半角数字で入力してください");
        }
        if (this.playerAction == 1) {
            this.execution();
        } else if (this.playerAction == 2) {
            this.showGrades();
        }
    }
    private void showGrades() {
        this.total();
        System.out.println("最終結果:" + this.win + "勝 " + this.lose + "敗 " + this.draw + "引き分け");
    }
    private void total() {
        for (int total : grades) {
            if (total == 0) {
                this.draw++;
            } else if (total == 1) {
                this.lose++;
            } else {
                this.win++;
            }
        }
    }
}

class Execution {
    public static void main(String[] args) {
        Janken janken = new Janken();
        janken.execution();
    }
}
