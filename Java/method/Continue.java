class Answer02 {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("処理をスキップします。");
                continue;//以降の処理は行われず繰り返し処理は続行される。
            }
            System.out.println(i + "回目の出力です。");
        }
    }
}
