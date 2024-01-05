package content.calc;

public class Execution {
    public static void main(String[] args) {
        Square squ = new Square();
        System.out.println(squ.getVertex());
        System.out.println(squ.area(10, 10));
        squ.showIntroduction();
    }
}
