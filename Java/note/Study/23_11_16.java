//2023.11.16(Thu) 学習会
//実務におけるクラスとメソッドの使い方

public class Sample {
    private int num;//フィールドは基本的にprivate
    public Sample() {

    }
    PUblic void setNum(int num) {
        this.num = num;
    }
    public int getNum() {//フィールドにアクセスしたいときgetter-setterを使う。(可視性)
        return this.num;
    }
    public int square() {
        return this.num * this.num;
    }
}

public class Main {
    Run|Debug
    public static void main(String[] args) {
        Sample sam = new Sample();
        sam.setNum();
        sam.square();
    }
}
