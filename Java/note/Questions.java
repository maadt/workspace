Q.クラスにprotected修飾子は使えない？

Q.UMLの関連について

Q.boolean型の引数
class Sample1 {
    public static void main(String[] args) {
        int number1 = 5;
        int number2 = 3;
        String text = "あああああ";
        boolean boolValue = true;

        boolValue = isEven(number1, number2);
        System.out.print(boolValue);
    }

    public static boolean isEven(int minuend, int subtrahend) {//boolean型は引数の数関係なし？
        return (minuend - subtrahend) % 2 == 0;
    }
}


Q.どこで繰り返し処理をしているか？
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Sample5 {
    public static void main(String[] args) {
        input();
    }

    public static int input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String inputStr = br.readLine();
            int inputNum = Integer.parseInt(inputStr);
            return inputNum;
        } catch (IOException | NumberFormatException e) {
            System.out.println("数値を入力してください");
            return input();
        }
    }
}

Q.拡張for文、forEach文に適用するとどうなるか？
（標準API:ArrayList:課題6）

import java.util.ArrayList;
import java.util.List;

class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("あ");
        list.add("ああ");
        list.add("あああ");
        list.add("ああああ");

        for (int i = 0; i < list.size(); i++) {
            System.out.println((list.get(i)).length());
        }

        /*
        for (String text : list) {
            System.out.println(list.length());
        }
        */

        /*
        list.forEach(index -> {
            index = (list.get()).length();
            System.out.println(index);
        });
        */
    }
}

Q.この書き方は良くないか？（標準API:ArrayList:課題5）

import java.util.ArrayList;
import java.util.List;

class Sample1 {
    import java.util.ArrayList;
import java.util.List;

class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(42);
        list.add(24);
        list.add(128);
        list.add(127);

        list.set(1, 22);
        list.remove(list.size() - 1);//

        System.out.print(list.get(list.size()));//
    }
}
}



オブジェクト指向/スーパークラス
this()を記述した場合は同じクラス内の別のコンストラクタを呼び出します?
class Parent {
    public Parent() { // (1)
        System.out.print("Parentの処理 ... ");
    }

    public Parent(int arg) { // (2)
        System.out.print("Parentの処理 ... " + arg + " を受け取った。");
    }
}

class Child extends Parent {
    public Child(int arg) { // (3)
        // 何も書いてないが(1)のコンストラクタが呼ばれている
        System.out.print("Childの処理 ... " + arg + " を受け取った。");
    }

    public Child() {
        // (3)が(1)を呼ぶのでここでは(1)のコンストラクタは呼べなくなる
        this(999);
    }
}

class Sample {
    public static void main(String[] args) {
        // Parentの処理 ...を出力
        Parent p = new Parent();

        // Parentの処理 ... Childの処理 ... 10 を受け取った。を出力
        Child c = new Child(10);
        // Parentの処理 ... Childの処理 ... 999 を受け取った。を出力
        Child c2 = new Child();
    }
}

Q.インスタンスの際どんな引数を渡すか？
A.コンストラクタが受け付けている値を渡す

Q.拡張for文とは？(オブジェクト指向、継承とオーバーライド、課題４から)

Q.String.join
