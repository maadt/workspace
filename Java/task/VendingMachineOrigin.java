import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Drink {//オブジェクトの情報を保持、各情報をカプセル化する
    private String name;
    private int price;
    private int stocks;

    public Drink(String name, int price, int stocks) {
        this.name = name;
        this.price = price;
        this.stocks = stocks;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getStocks() {
        return stocks;
    }
    public void setStocks(int stocks) {
        this.stocks = stocks;
    }
}

class DepositManager {
    public DepositManager() {}
    private int deposit = 0;
    public void setDeposit(int deposit) {
        this.deposit += deposit;
    }
    public int getDeposit() {
        return this.deposit;
    }
    public int getChangeAndInit(int change) {
        this.deposit = 0;
        return change;
    }
}

class VendingMachine {//基軸となるクラス
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private Map<Integer, Drink> drinks = new HashMap<Integer, Drink>();
    DepositManager deposit = new DepositManager();
    private int select = 0;

    public VendingMachine() {//Mapとして配列のインスタンスを生成することで、複数の情報を保持できる
    // 飲み物の投入
        this.drinks.put(1, new Drink("コーラ", 100, 2));
        this.drinks.put(2, new Drink("お茶", 150, 1));
        this.drinks.put(3, new Drink("コーヒー", 120, 0));
    }
    //実行用メソッド
    public void execution() {
        while (this.getAllStocks() > 0) {
            this.showDrink();
            this.selectDrink();
            this.checkDeposit();
            this.getDrink();
            this.getChange();
        }
        System.out.println("全て売り切れました");
    }
    // 飲物の取得・表示
    private void showDrink() {
        System.out.println("---------------------------");
        this.drinks.forEach((index, drink) -> {
            System.out.print(index + ": " + drink.getName());
            if (drink.getStocks() == 0) {
                System.out.print(" ( 売切 )");
            } else {
                System.out.print(" ( " + drink.getPrice() + " 円 )");
            }
            System.out.println();
        });
        System.out.println("---------------------------");
    }
    private int inputNum() {//入力専用のメソッド
        try {
            return Integer.parseInt(BR.readLine());
        } catch (NumberFormatException | IOException e) {
            return 0;//繰り返し処理を続行する
        }
    }
    // 商品の選択
    private void selectDrink() {
        int select = -1;
        while (true) {
            System.out.println("商品を選択してください");
            select = this.inputNum();
            if (select < 1 || select > this.drinks.size()) {
                continue;
            }
            if (this.checkStocks(select)) {
                break;
            }
            System.out.println("売り切れです");
        }
        this.select = select;//フィールドselectに代入する意味
    }
    // 在庫チェック
    private boolean checkStocks(int select) {//呼び出し元の繰り返し処理が真偽値で行われるためboolean型の値を返す
        int stocks = this.drinks.get(select).getStocks();//Map要素のキーを受け取って、継承関係にあるgetメソッドから情報を受け取る
        return stocks > 0;
    }
        // 入金額チェック
    private void checkDeposit() {
        this.deposit();//入金処理
        int deposit = this.deposit.getDeposit();//フィールドからDepositManagerにアクセスし入金額を取得する
        int price = this.drinks.get(this.select).getPrice();//Mapの要素キーを取得し値段を取得する
        while (this.deposit < price) {//値段に対して入金額が不足している場合の繰り返し処理
            System.out.println("入金額が足りません 現在の投入金額 " + this.deposit + " 円");
            this.deposit();
            deposit = this.deposit.getDeposit();
        }
    }
    // 入金
    private void deposit() {
        int input = -1;
        while (input <= 0) {
            System.out.println("お金を入れてください");
            input = this.inputNum();//入力処理
        }
        this.deposit.setDeposit(input);//入力された値をDepositManagerのフィールドに渡す
    }
    // 商品を出す
    private void getDrink() {
        System.out.println(this.drinks.get(this.select).getName() + " を購入しました");//Mapの要素のキーから名前を取得する
        int stocks = this.drinks.get(this.select).getStocks();//在庫数を取得
        this.drinks.get(this.select).setStocks(--stocks);//在庫数を上書き
    }
    // お釣りを返す・入金額のリセット
    private void getChange() {
        int price = this.drinks.get(this.select).getPrice();//Mapの要素のキーから値段を取得する
        int deposit = this.deposit.getDeposit();
        int change = this.deposit - price;
        // 差額がある場合はお釣りを返却する、入金額をリセットする
        if (change > 0) {
            System.out.println(change + " 円のお返しです");
            this.deposit = 0;
        }
    }
    // 全在庫数の確認
    private int getAllStocks() {
        int allStocks = 0;
        // 値を取り出してカウントする際はforEachでは工夫が必要なのでfor文を使用する
        // 今までの学習内容を踏まえた実装
        /*
        for (int i = 1; i <= this.drinks.size(); i++) {
            allStocks += this.drinks.get(i).getStocks();
        }
        */
        // Mapを拡張for文で取り出すときは一手間が必要だがこんな実装もあり
        // Map<Integer, Drink>のDrinkにあたるvalueだけ取り出す
        for (Drink drink : this.drinks.values()) {//Drink drinkにnew Drink("商品名", 値段, 在庫数)を渡す
            allStocks += drink.getStocks();
            }
        /*
        //Map.Entryで<Integer, Drink>型を指定
        //entrySet()で<Integer, Drink>型のキーと要素を取り出す
        for (Map.Entry<Integer, Drink> drink : this.drinks.entrySet()) {
            allStocks += drink.getValue().getStocks();
        }
        */
        return allStocks;
    }
}

class Execution {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.execution();
    }
}
