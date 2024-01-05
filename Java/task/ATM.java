import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Execution {//実行用メソッド
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.selectMenu();
    }
}

class CommonIO {//メニュー表示、入力用クラス
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    //メニュー表示用メソッド
    private static void showMenu(Map<Integer, String> menu) {//受け取ったmenu配列を表示
        menu.forEach((key, value) -> System.out.print(key + ":" + value + " "));
        System.out.println();
    }
    //入力された数値を受け取って処理文に返すメソッド
    public static int inputMenu(Map<Integer, String> menu) {//Bankクラスのmenu配列を受け取る
        while (true) {
            showMenu(menu);//Bankクラスのmenu配列を渡す
            int input = inputNum();
            if (input > 0 && input <= menu.size()) {//メニュー内の数字であればinputに代入
                return input;//returnで繰り返し終了、inputを返す
            }
            System.out.println("該当する半角数字で入力してください");//条件外の入力で表示
        }
    }
    //入力用メソッド
    public static int inputNum() {
        try {
            return Integer.parseInt(BR.readLine());//入力処理と数値変換して返す
        } catch (NumberFormatException | IOException e) {
            return 0;//例外キャッチで繰り返しを続行させる
        }
    }
}

class Bank {
    private Map<Integer, String> menu = new HashMap<Integer, String>();
    private Map<String, String> user = new HashMap<String, String>();
    private ATM atm = new ATM();

    public Bank() {
        user.put("name", "taro");
        user.put("balance", "10000");
        menu.put(1, "ATM 利用");
        menu.put(2, "終了");
    }

    public void selectMenu() {
        System.out.println("いらっしゃいませ、ようこそ SLS銀行へ");
        boolean isFinished = true;
        while (isFinished) {//プログラムを終了させるためのwhile文
            int inputMenu = CommonIO.inputMenu(this.menu);
            switch (inputMenu) {
                case 1:
                    this.useATM();
                    break;
                case 2:
                    System.out.println("ご利用ありがとうございました、またのご利用お待ちしております");
                    isFinished = false;
                    break;//無限ループ防止
            }
        }
    }

    private void useATM() {//メニューでATMを選択した場合に実行される
        this.atm.setUser(this.user);//ATMにユーザー情報を共有する
        user = this.atm.selectMenu();
    }
}


class ATM {
    private static final int MIN_DEPOSIT_AMOUNT = 1;
    private static final int MAX_DEPOSIT_AMOUNT = 2000000;
    private static final int MIN_WITHDRAWAL_AMOUNT = 1;
    private static final int MAX_WITHDRAWAL_AMOUNT = 500000;

    private Map<Integer, String> menu = new HashMap<Integer, String>();
    private Map<String, String> user = new HashMap<String, String>();

    public ATM() {
        menu.put(1, "預け入れ");
        menu.put(2, "引き出し");
        menu.put(3, "残高照会");
        menu.put(4, "終了");
    }

    public Map<String, String> selectMenu() {
        System.out.println(this.user.get("name") + " 様ようこそ");
        boolean isFinished = true;
        while (isFinished) {
            int inputMenu = CommonIO.inputMenu(menu);
            switch (inputMenu) {
                case 1:
                    this.deposit();
                    break;
                case 2:
                    this.withdrawal();
                    break;
                case 3:
                    this.balanceInquiry();
                    break;
                case 4:
                    System.out.println("ATM のご利用ありがとうございました");
                    isFinished = false;
                    break;//なぜwhile文を終わらせた後にbreak？
            }
        }
        return this.user;//ユーザー情報の更新
    }

    private void balanceInquiry() {
        System.out.println("残高は " + this.user.get("balance") + " 円です");
    }

    private void deposit() {
        int amount = -1;//預金額
        while (true) {
            System.out.println("ご入金額を入力してください");
            amount = CommonIO.inputNum();//預金額の入力とフィールドへの代入
            if (amount >= MIN_DEPOSIT_AMOUNT && amount <= MAX_DEPOSIT_AMOUNT) {//最低金額と最高金額の指定
                break;
            }
            System.out.println(MIN_DEPOSIT_AMOUNT + " 円から " + (MAX_DEPOSIT_AMOUNT / 10000) + " 万円以内で入力してください");
            //最低金額と最高金額の表示
        }
        this.user.replace("balance", String.valueOf(Integer.parseInt(this.user.get("balance")) + amount));
        //ユーザー情報の上書き。新残高 = 旧残高 + 預金額 (String.valueOf...文字列に変換)
        System.out.println(amount + " 円お預かりしました");
    }

    private void withdrawal() {
        int balance = Integer.parseInt(this.user.get("balance"));//ユーザー情報をフィールドに渡す
        if (balance <= 0) {
            System.out.println("残高がありません");
            return;//メソッドの処理を終了させる
        }

        int amount = -1;
        while (true) {
            System.out.println("ご出金額を入力してください");
            amount = CommonIO.inputNum();
            if (amount < MIN_WITHDRAWAL_AMOUNT || amount > MAX_WITHDRAWAL_AMOUNT) {
                System.out.println(MIN_WITHDRAWAL_AMOUNT + " 円から " + (MAX_WITHDRAWAL_AMOUNT / 10000) + " 万円以内で入力してください");
                continue;//以降の処理を省略しwhile文先頭に戻る
            }
            if (amount <= balance) {//なぜelse-ifを使わない？
                break;//while文の終了
            }
            System.out.println("残高が不足しています、残高は " + this.user.get("balance") + " 円です");
        }
        System.out.println(amount + " 円お返ししました");
        this.user.replace("balance", String.valueOf(balance - amount));
    }

    public void setUser(Map<String, String> user) {//Bankからユーザー情報を受け取る
        this.user = user;
    }
}
