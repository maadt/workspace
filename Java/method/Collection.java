import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class CollectionAnswer {
    public static void main(String[] args) {
        List<String> animalList = new ArrayList<String>();
        animalList.add("dog");//配列の要素の追加
        animalList.add("cat");
        animalList.add("mouse");
        animalList.set(2, "hamster");//配列の要素の変更

        //連想配列の宣言はジェネリクスにキーの型と要素の型を指定する。
        Map<String, String> dogDetails = new HashMap<String, String>();
        dogDetails.put("name", "コタロー");//連想配列の要素の追加
        dogDetails.put("type", "ブルテリア");
        dogDetails.replace("type", "ボルゾイ");//連想配列の要素の変更

        Map<String, String> catDetails = new HashMap<String, String>();
        catDetails.put("name", "コジロー");
        catDetails.put("type", "マンチカン");

        Map<String, String> hamsterDetails = new HashMap<String, String>();
        hamsterDetails.put("name", "ハムタロー");
        hamsterDetails.put("type", "キンクマ");

        //連想配列のまとめ方...要素の型を連想配列型にする必要がある。
        Map<String, Map<String, String>>animalDetails = new HashMap<String, Map<String, String>>();
        animalDetails.put(animalList.get(0), dogDetails);
        animalDetails.put(animalList.get(1), catDetails);
        animalDetails.put(animalList.get(2), hamsterDetails);

        //forEachの引数にキー名と要素名を宣言する
        animalDetails.forEach((key, animalDetail) -> {
            System.out.println("[" + key + "]");
            System.out.println("名前：" + animalDetail.get("name"));//格納された配列のキーを指定することで要素を取り出す。
            System.out.println("種類：" + animalDetail.get("type"));
            System.out.println();
        });
    }
}
