import java.io.BufferedReader;
import java.io.FileInputStream;//ファイルを読み込むためのAPI
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;//異なるファイルの文字列をjavaファイルで読み込むためのAPI
import java.util.HashMap;
import java.util.Map;

public class DrinkManager {
private static final String FILE = "drink.csv";//csvファイルのパス(Comma-Separated-Values:コンマで区切られた値)
private static final int NAME = 0;//飲み物の読み取り位置、String[] values[0]に格納される
private static final int PRICE = 1;//金額の読み取り位置、String[] values[1]に格納される
private static final int STOCK = 2;//在庫数の読み取り位置、String[] values[2]に格納される

    public static Map<Integer, Drink> getDrinks() {//csvファイルで指定した配列を格納する
        Map<Integer, Drink> drinks = new HashMap<Integer, Drink>();//csvファイルで指定した値を格納する配列
        //VendingMachineのdrinksと同じ？

        try (BufferedReader br = new BufferedReader(
        //try-with-resources構文...開いたリソースは自動的にクローズされるため効果的にリソース管理を行える(リソース...外部の情報源)
        //そのためAutoCloseableおよびCloseableインターフェースを実装したクラスが期待される(BufferedReader, InputStreamReader, FileInputStreamなど)
                new InputStreamReader(new FileInputStream(FILE), Charset.forName("UTF-8")))) {
                //new FileInputStream(FILE)...引数で指定されたパスのファイルを開く
                //Charset.forName("UTF-8")...文字列のデータをUTF-8に変換する
                int count = 1;
            String line;

            while ((line = br.readLine()) != null) {//要素数分csvファイルの内容を一行ずつ取り出す

                String[] values = line.split(",");//spritメソッドを使用しコンマ区切りで配列化してdrinkを生成
                Drink drink = new Drink(//引数にcsvで指定した値をコンストラクタに渡す
                        values[NAME],
                        Integer.parseInt(values[PRICE]),
                        Integer.parseInt(values[STOCK]));
                drinks.put(count, drink);//(key, values配列)が渡る
                count++;//drinksのキーを指定する
            }
        } catch (NumberFormatException | IOException e) {//FileNotFoundExceptionは不要？
            System.out.println("ファイルの読み込みに失敗しました");
        }
        return drinks;
    }
}
