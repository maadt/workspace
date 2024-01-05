class Answer01 {
    public static void main(String[] args) {
        // 練習問題-3
        int checkTarget = 0;
        switch (checkTarget) {
            case 5:
            case 7://caseを追加して処理をまとめる
                System.out.println("条件にヒットしました");
                break;
            default:
                System.out.println("条件に合いませんでした");
                break;
        }
    }
}
