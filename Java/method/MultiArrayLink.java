public class MultidimensionalArrayAnswer {
    public static void main(String[] args) {

        String[][][][] fonts = {
            {//0
                {//00
                    {"T", "h", "e", " "},//000
                    {"q", "u"}//001
                },
                {//01
                    {"i"},
                    {"c", "k", " ", "b", "r"},
                    {"o", "w", "n"}
                },
                {//02
                    {" ", "f"}
                }
            },
            {//1
                {
                    {"o", "x" ," ", "j"},
                    {"u"}
                },
                {
                    {"m", "p"},
                    {"s", " ", "o", "v"}
                }
            },
            {//2
                {
                    {"e", "r"},
                    {" ", "t", "h"},
                    {"e", " ", "l"}
                },
                {
                    {"a", "z", "y", " ", "d"},
                    {"o", "g", "."}
                }
            }
        };

        for (int i = 0; i < fonts.length; i++) {
            for (int j = 0; j < fonts[i].length; j++) {
                for (int k = 0; k < fonts[i][j].length; k++) {
                    for (int l = 0; l < fonts[i][j][k].length; l++) {
                        System.out.print(fonts[i][j][k][l]);
                    }
                }
            }
        }
        System.out.println();

        //多次元配列を一次元にして一文字ずつ出力
        for (String[][][] array2 : fonts) {//1週目は7行目の配列を代入。[0][0][0]
            for (String[][] array3 : array2) {//7行目の要素を一つずつ代入。[0][0]
                for (String[] array4 : array3) {//7行目の要素をまとめて一つの配列に
                    for (String font : array4) {//一次元にした配列を変数に代入
                        System.out.print(font);//一文字ずつ出力
                    }
                }
            }
        }
        System.out.println();
    }
}
