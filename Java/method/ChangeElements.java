public class ArrayAndForAnswer {
    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 4, 5, 6, 7};
        int[] arrayB = {11, 21, 31, 41, 51, 61, 71};

        System.out.println("入れ替え前");
        System.out.print("配列Aの要素は ");
        for (int element : arrayA) {
            System.out.print(element + " ");
        }

        System.out.print("\n");
        System.out.print("配列Bの要素は ");
        for (int element : arrayB) {
            System.out.print(element + " ");
        }

        for (int i = 0; i < arrayA.length; i++) {
            int tmp = arrayA[i];//tmpにA[i]を代入
            arrayA[i] = arrayB[i];//A[i]にB[i]を代入
            arrayB[i] = tmp;//B[i]にtmpを代入
        }

        System.out.print("\n");
        System.out.println("入れ替え後");
        System.out.print("配列Aの要素は ");
        for (int element : arrayA) {
            System.out.print(element + " ");
        }

        System.out.print("\n");
        System.out.print("配列Bの要素は ");
        for (int element : arrayB) {
            System.out.print(element + " ");
        }
    }
}
