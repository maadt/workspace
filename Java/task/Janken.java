import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class Janken {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private Map<Integer, String> hands = new HashMap<Integer, String>();
    private Map <Integer, String> playAgainOrEnd = new HashMap<Integer, String>();
    private List<String> results = new ArrayList<String>();
    private int playerHand;
    private int cpuHand;
    private int result;
    private int battleCount;
    private int winCount;
    private int loseCount;

    public Janken() {
        this.hands.put(1, "グー");
        this.hands.put(2, "チョキ");
        this.hands.put(3, "パー");
        this.playAgainOrEnd.put(1, "もう一度対戦する");
        this.playAgainOrEnd.put(2, "終了する");
        this.results.add("あいこ");
        this.results.add("負け");
        this.results.add("勝ち");
    }

    public void execution() {
        while (true) {
            this.inputPlayerHand();
            this.setCpuHand();
            this.judgement();
            this.showResult();
            if (this.isPlayAgainOrEnd() == 2) {
                this.showFinalResult();
                break;
            }
        }
    }

    private void showMenu(Map<Integer, String> menu) {
        menu.forEach((key, value) -> System.out.print(key + ":" + value + " "));
        System.out.println();
    }

    private void inputPlayerHand() {
        while (true) {
            this.showMenu(this.hands);
            this.playerHand = this.inputNum();
            if (this.playerHand > 0 && this.playerHand <= this.hands.size()) {
                break;
            }
            System.out.println("該当する半角数字で入力してください");
        }
    }
    private int inputNum() {
        try {
            return Integer.parseInt(BR.readLine());
        } catch (NumberFormatException | IOException e) {
        return 0;
        }
    }
    private void setCpuHand() {
        this.cpuHand = new Random().nextInt(this.hands.size()) + 1;
    }

    private void judgement() {
        this.battleCount++;
        this.result = (this.playerHand - this.cpuHand + 3) % 3;
        if (this.result == 2) {
            this.winCount++;
        }else if (this.result == 1) {
            this.loseCount++;
        }
    }
    private int isPlayAgainOrEnd() {
        while (true) {
            this.showMenu(this.playAgainOrEnd);
            int input = this.inputNum();
            if (input > 0 && input <= this.playAgainOrEnd.size()) {
                return input;
            }
            System.out.println("該当する半角数字で入力してください");
        }
    }
    private void showResult() {
        System.out.println("Player : " + hands.get(this.playerHand));
        System.out.println("CPU    : " + hands.get(this.cpuHand));
        System.out.println("Result : " + results.get(this.result));
    }
    private void showFinalResult() {
        int draw = this.battleCount - this.winCount - this.loseCount;
        System.out.println("最終結果:" + this.winCount + "勝 " + this.loseCount + "敗 " + draw + "引き分け");
    }
}

class Execution {
    public static void main(String[] args) {
        Janken janken = new Janken();
        janken.execution();
    }
}
