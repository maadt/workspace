class SkillCheckTestA {
    public static void main(String[] args) {
        //Q1
        int number7 = 7;
        int number8 = 5;
        int differenceNumber = number7 - number8;

        switch (differenceNumber % 2) {
            case 0:
                System.out.println("偶数か0です");
                break;
            case 1:
                System.out.println("奇数です");
                break;
        }

        //Q2
        int count = 0;
        for (int i = 20; i <= 50; i++) {
            if ((i % 2 == 0) && ((i / 2) % 2 == 1)) {
                count++;
            }
        }
        System.out.println(count + "個");

        //Q3
        int max = 999;
        int min = 0;
        int countMax = 5;

        for (int i = max; i > min; i--) {
            if (i % 3 == 0 || i % 7 == 0) {
                countMax--;
            }
            if (countMax == 0) {
                System.out.println(i);
                break;
            }
        }

        //Q4
        int[][][] numberList = {
            {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            },
            {
                {10, 11, 12},
                {13, 14, 15}
            },
            {
                {16, 17, 18},
                {19, 20, 21}
            }
        };

        for (int i = 0; i < numberList.length; i++) {
            for (int j = 0; j < numberList[i].length; j++) {
                for (int k = 0; k < numberList[i][j].length; k++) {
                    System.out.print(numberList[i][j][k] + " ");
                }
            }
        }
        System.out.println();

        //Q5
        int width = 11;
        int height = 5;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("0");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

/*
■全体：8/10

■基礎スキルチェック再テストA：点数 5/5
Q1. 〇

Q2. 〇

Q3. 〇

Q4. 〇

Q5. 〇
75行目：2で整数を割ったときは余りは`1`、または`0`なので、`else if`ではなく、`else`で十分です。
*/
