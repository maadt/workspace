import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MultidimensionalArrayAnswer {
    public static void main(String[] args) {
        List<String> wagashi = new ArrayList<String>();
        wagashi.add("みたらし団子");
        wagashi.add("ういろう");
        wagashi.add("せんべい");
        wagashi.add("羊羹");

        List<String> yogashi = new ArrayList<String>();
        yogashi.add("ショートケーキ");
        yogashi.add("プリン");
        yogashi.add("シュークリーム");
        yogashi.add("クッキー");
        yogashi.add("マシュマロ");
        yogashi.add("チョコレート");

        Map<String, List<String>> sweets = new HashMap<String, List<String>>();
        sweets.put("和菓子", wagashi);
        sweets.put("洋菓子", yogashi);

        for (String key : sweets.keySet()) {//全キーが配列のような形でセットとして返される。
            System.out.println(key + ": " + sweets.get(key).size() + "個");//代入されたキーのsizeを出力。
        }
        System.out.println();

        sweets.forEach((key, value) -> {//BiConsumerインターフェースのオブジェクトであり、二つの引数を受け取る。
            System.out.println(key + ": " + value.size() + "個");
        });
        System.out.println();
    }
}
