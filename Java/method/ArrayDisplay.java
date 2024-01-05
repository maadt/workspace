public class ArrayAndForAnswer {
    public static void main(String[] args) {
        String[] products = {
            "水",
            "コーラ",
            "オレンジジュース",
            "カフェオレ"
        };
        String productsStr = "";

        for (int i = 0; i < products.length; i++) {
            productsStr += (i + 1) + ":" + products[i] + " ";//予め用意された空の変数を利用して配列の要素を出力する場合、文字列の連結を使用する。
        }
        System.out.println(productsStr);
        System.out.println();

        int num = 1;//拡張for文を利用する場合は数値のカウントで繰り返し回数を表示する。
        for (String productName : products) {
            productsStr += num + ":" + productName + " ";
            num++;
        }
        System.out.println(productsStr);
        System.out.println();
    }
}
