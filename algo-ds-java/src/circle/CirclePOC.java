package circle;

import circle.beans.Circle;
import circle.beans.PointF;

public class CirclePOC {

    public static void main (String []args) {

        Circle A = new Circle(3.62f, 3.06f, 2.12f);
        Circle B = new Circle(5.52f, 4.58f, 2.73f);
        Circle C = new Circle(7.44f, 3.3f, 2.51f);

        double x1 = A.x, y1=A.y;
        double x2= B.x, y2=B.y;
        double r1 = A.radius, r2 = B.radius;

        // Calculate distance between centers of the circles
        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Check for intersection
        if (d <= Math.abs(r1 - r2) || d >= r1 + r2) {
            System.out.println("The circles do not intersect.");
        } else {
            // Calculate the intersection points
            /*double h = (r1 * r1 - r2 * r2 + d * d) / (2 * d);
            double x3 = x1 + h * (x2 - x1) / d;
            double y3 = y1 + h * (y2 - y1) / d;
            double x4 = x3 + (y2 - y1) * Math.sqrt(r1 * r1 - h * h) / d;
            double y4 = y3 - (x2 - x1) * Math.sqrt(r1 * r1 - h * h) / d;*/

            // Calculate the first intersection point (x3, y3)
            double a = (r1 * r1 - r2 * r2 + d * d) / (2 * d);
            double h = Math.sqrt(r1 * r1 - a * a);
            double x3 = x1 + a * (x2 - x1) / d;
            double y3 = y1 + a * (y2 - y1) / d;

            // Calculate the two possible values for x4 and y4
            double x4_1 = x3 + h * (y2 - y1) / d;
            double y4_1 = y3 - h * (x2 - x1) / d;
            double x4_2 = x3 - h * (y2 - y1) / d;
            double y4_2 = y3 + h * (x2 - x1) / d;

            // Display the intersection points
            System.out.println("Intersection Points:");
            System.out.println("Point 1: (" + x3 + ", " + y3 + ")");
            //System.out.println("Point 2: (" + x4 + ", " + y4 + ")");
        }

        /*CirclePOC circlePOC = new CirclePOC();

        PointF intersectionPoint = circlePOC.intersectionPoint (A, B);

        System.out.println("intersectionPoint=("+intersectionPoint.x+","+intersectionPoint.y+")");*/
    }

    public PointF intersectionPoint (Circle circle_1, Circle circle_2) {
        float h = getH (circle_1, circle_2);
        float d = distance(circle_1, circle_2);
        float x = circle_1.x+h * (circle_2.x-circle_1.x) / d;
        float y = circle_1.y+h * (circle_2.y-circle_1.y) / d;
        return new PointF(x,y);
    }
    public float getH (Circle circle_1, Circle circle_2) {
        float distance = distance (circle_1, circle_2);
        return square(circle_1.radius) - square(circle_2.radius) + square(distance) / (2*distance);
    }
    private float distance (Circle circle_1, Circle circle_2) {
        return (float)Math.sqrt(square (Math.abs(circle_1.x-circle_2.x))) + square (Math.abs(circle_1.y-circle_2.y));
    }
    private float square (float value) {
        return value * value;
    }
}
