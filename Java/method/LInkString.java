class Answer02 {
    public static void main(String[] args) {
        // 練習問題-4
        for (int i = 1; i <= 20; i++) {
            String message = "";
            if (i % 3 == 0) {
                message += "Oh!";
            }
            if (i % 4 == 0) {
                message += "Yes!!";
            }
            System.out.println(i + " " + message);
        }//条件によって出力する文字が増減する場合、文字列の連結を使うと綺麗。
    }
}
