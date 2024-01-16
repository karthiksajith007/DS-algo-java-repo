package circle.beans;

public class Circle extends PointF {

    public float radius;

    public Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
    }
}
