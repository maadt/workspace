package content.calc;

import content.polygon.Polygon;

public class Square extends Polygon {
    Square() {
        super(4);
    }

    @Override
    protected String introduction() {
        return "正方形";
    }

    int area(int height, int base) {
        return height * base;
    }

    void showIntroduction() {
        System.out.println(this.introduction() + "は" + super.introduction() + "です。");
    }
}
