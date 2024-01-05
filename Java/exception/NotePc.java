class Polygon {
    public void introduction() {
        System.out.println("多角形です。");
    }
}

class Square extends Polygon {
    @Override
    public void introduction() {
        System.out.println("正方形です。");
    }
}

class Triangle extends Polygon {
    @Override
    public void introduction() {
        System.out.println("三角形です。");
    }
}

class Execution {
    public static void main(String[] args) {
        // 処理
        Shape shape = new Shape();
        for(Polygon polygon : shape.polygons) {
            polygon.introduction();
        }
    }
}

// Shape クラス
class Shape {
    public Polygon[] polygons = new Polygon[3];

    public Shape() {
        polygons[0] = new Polygon;
        polygons[1] = new Square;
        polygons[2] = new Triangle;
    }

}
