class Polygon {
    public Polygon() {
        System.out.println("オブジェクトPolygonを初期化します。");
    }
    public void introduction() {
        System.out.println("多角形です。");
    }
}

class Square extends Polygon {
    public Square() {
        System.out.println("オブジェクトSquareを初期化します。");
    }
    @Override
    public void introduction() {
        System.out.println("正方形です。");
    }
}

class Triangle extends Polygon {
    public Triangle() {
        System.out.println("オブジェクトTriangleを初期化します。");
    }
    @Override
    public void introduction() {
        System.out.println("三角形です。");
    }
}

class Execution {
    public static void main(String[] args) {
        Shape shape = new Shape();

        /*
        for (Polygon polygon : shape.polygons) {
            polygon.introduction();
        }
        */
    }
}

class Shape {
        Polygon[] polygons = new Polygon[3];

        public Shape() {

            polygons[0] = new Polygon();//Polygonクラスのオブジェクトを生成して初期化。
            polygons[1] = new Square();//Squareクラスのオブジェクトを生成して初期化。
            polygons[2] = new Triangle();//Triangleクラスのオブジェクトを生成して初期化。
        }
}

/*
・Polygon型配列にSquare,Triangleを代入できるのは、継承によるポリモーフィズムが働くため。
・コンストラクタによってオブジェクトの初期化が行われる。
*/
