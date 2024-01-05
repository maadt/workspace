class Answer01 {
    public static void main(String[] args) {
        // 準備
        int num1 = 8;
        int num2 = 13;

        // 練習問題-1
        boolean isMultiple = num2 % num1 == 0;
        if (isMultiple) {//if文はtrueなら実行される。
            System.out.println(num2 + "は" + num1 + "の倍数です");
        } else {
            System.out.println(num2 + "は" + num1 + "の倍数ではありません");
        }
    }
}
