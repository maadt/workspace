public class ArrayAndForAnswer {
    public static void main(String[] args) {

        int[] numberArray = {10, 3, 22, 9, 2, 18};

        int max = numberArray[0];//予め数値を保管する空の変数を用意しておく。
        int min = numberArray[0];
        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] > max) {
                max = numberArray[i];
            }
            if (numberArray[i] < min) {
                min = numberArray[i];
            }
        }
        System.out.println("最大値は" + max);
        System.out.println("最小値は" + min);
        System.out.println();

        //生成した空の変数で大小の比較を行い代入する。
        for (int targetNum : numberArray) {
            if (targetNum > max) {
                max = targetNum;
            }
            if (targetNum < min) {
                min = targetNum;
            }
        }
        System.out.println("最大値は" + max);
        System.out.println("最小値は" + min);
    }
}
