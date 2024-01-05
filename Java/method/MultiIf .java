class Answer01 {
    public static void main(String[] args) {
        // 準備
        int num1 = 8;
        int num2 = 13;

        // 練習問題-2
        if ((num1 + num2) % 7 == 0) {//if文を多重にして条件を追加することができる。
            if (num1 > 10 || num1 % 2 == 0) {
                if (num2 <= 100 && num2 % 6 != 0) {
                    System.out.println("すべての条件を満たしました");
                }
            }
        }
    }
}
