package content.polygon;

public class Polygon {
    private int vertex; // 頂点

    protected Polygon() {
        this(0);
    }

    protected Polygon(int vertex) {
        this.vertex = vertex;
    }

    protected String introduction() {
        return "多角形";
    }

    public int getVertex() {
        return this.vertex;
    }
}
