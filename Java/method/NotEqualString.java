class Test {
    public static void main(String[] args) {
        int age = -1;
        String gender = "male";
        String status = "";

        if ((age >= 0 && age <= 5 && gender.equals("female")) || (age >= 0 && age <=10 && gender.equals("male"))) {
            status = "A";
            System.out.print(status);
        } else if (age >= 10 && !gender.equals("male")) {//変数の前に!を付けることで非定型になる
            status = "B";
            System.out.print(status);
        } else if (age < 0) {
            status = "判定対象外";
            System.out.print(status);
        } else {
            status = "C";
            System.out.print(status);
        }
    }
}
