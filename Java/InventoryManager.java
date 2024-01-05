import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Item> items = new ArrayList<Item>();
        List<Object> sampleItemData = new ArrayList<Object>();
        sampleItemData.add("マウス");
        sampleItemData.add(15000);
        try {
            Item sampleItem = new Item(sampleItemData);
            items.add(sampleItem);
            while (true) {
                System.out.println("1. 商品追加");
                System.out.println("2. 商品一覧表示");
                System.out.println("3. 商品削除");
                System.out.println("4. 終了");
                System.out.print("選択してください: ");
                int choice = Integer.parseInt(reader.readLine());

                if (choice == 1) {
                    System.out.print("商品の名前を入力してください: ");
                    String name = reader.readLine();

                    System.out.print("商品の価格を入力してください: ");
                    int price = Integer.parseInt(reader.readLine());

                    //Q4 商品の追加処理を呼び出して動作確認
                    addItem(items, name, price);
                } else if (choice == 2) {
                    //Q3 商品の一覧表示処理を呼び出して動作確認
                    displayItems(items);
                } else if (choice == 3) {
                    System.out.print("削除する商品の番号を入力してください: ");
                    int itemIndex = Integer.parseInt(reader.readLine()) - 1;
                    //Q5 商品の削除処理を呼び出して動作確認
                    if (itemIndex >= 0 && itemIndex < items.size()) {
                        removeItem(items, itemIndex);
                    } else {
                        System.out.println("無効な番号です。");
                    }
                } else if (choice == 4) {
                    break;
                } else {
                    System.out.println("無効な選択です。");
                }
            }
        // Q2 catchの()内に数値、入力の例外処理を実装してください。
        } catch (NumberFormatException | IOException e) {
            System.out.println("無効な入力です。");
        // Q2 catchの()内に不正な引数の例外処理を実装してください。
        } catch (IllegalArgumentException e) {
            System.out.println("データが不正です。");
        } finally {
            System.out.println("プログラムを終了します。");
        }
    }

    // Q4 addItemメソッドを実装してください
    static void addItem(List<Item> items, String name, int price) {
        List<Object> toAddItem = new ArrayList<Object>();
        toAddItem.add(name);
        toAddItem.add(price);
        Item item = new Item(toAddItem);
        items.add(item);
        System.out.println("商品が追加されました。");
        displayItems(items);
    }

    // Q3 displayItemsメソッドを実装してください
    static void displayItems(List<Item> items) {
        System.out.println("商品一覧:");
        int num = 1;
        for (Item item : items) {
            System.out.println(num + ": " + item.showItem());
            num++;
        }
    }

    // Q5 removeItemメソッドを実装してください
    static void removeItem(List<Item> items, int index) {
        items.remove(index);
        System.out.println("商品が削除されました。");
        displayItems(items);
    }
}

//Q1 Itemクラスを実装してください
class Item {
    // 処理
    private String name;
    private int price;

    public Item(List<Object> itemData) throws IllegalArgumentException {
        if (itemData.size() != 2) {
            throw new IllegalArgumentException();
        } else {
            itemData.forEach( element -> {
                if (element instanceof String) {
                    this.name = (String) element;
                } else if (element instanceof Integer) {
                    this.price = (int) element;
                } else {
                    throw new IllegalArgumentException();
                }
            });
        }
    }

    public String showItem() {
        return "商品: " + name + " 価格: " + price;
    }
}
/*
■商品管理システム：点数 3/5

Q1. ×
106行目：
正常に動作しますが、int型のpriceに代入するので、int型に型キャストするほうが自然に感じます。
↓
int(プリミティブ型)...整数のみを扱うためメモリ効率が良い
Integer(クラス型)...様々な機能を提供する

109行目：
IllegalArgumentExceptionの発生条件の指定箇所が不適切です。
99行目からのif文にelseが複数あるためにコンパイルエラーします
↓
条件分岐の処理の流れと利用方法

Q2. 〇

Q3. ×
79行目：
数字の後は`.`ではなく`:`を指定されています。
↓
確認不足。一言一句丁寧に確認する。

Q4. 〇
toItemはちょっと違和感があります。
toAddItem、itemDataや、newItem等がいいでしょう。
↓
toItemだと、存在しない配列(item)に要素を追加するかのように見える。

Q5. 〇
*/
