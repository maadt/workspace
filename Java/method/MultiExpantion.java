public class ArrayAndForAnswer {
    public static void main(String[] args) {
        String[] teamList = {
            "A",
            "B",
            "C",
            "D",
            "E"
        };

        for (String teamName1 : teamList) {
            for (String teamName2 : teamList) {//拡張for文を利用した繰り返しの制御
                if (teamName1.equals(teamName2)) {
                    System.out.print("|NoBattle");
                } else {
                    System.out.print("| " + teamName1 + " vs " + teamName2 + " ");
                }
            }
            System.out.println("|");
        }
    }
}
