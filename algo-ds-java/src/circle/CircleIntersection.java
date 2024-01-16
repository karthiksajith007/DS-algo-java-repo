package circle;

import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CircleIntersection {

    // Represents a point (x, y) in 2D space
    static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Represents a circle with its center (x, y) and radius
    static class Circle {
        Point center;
        double radius;

        public Circle(double x, double y, double radius) {
            this.center = new Point(x, y);
            this.radius = radius;
        }
    }

    // Function to find the intersection points of two circles
    public static ArrayList<Point> findCircleIntersections(Circle circle1, Circle circle2) {
        ArrayList<Point> intersections = new ArrayList<>();

        // Calculate the distance between the centers of the two circles
        double distance = Point2D.distance(circle1.center.x, circle1.center.y, circle2.center.x, circle2.center.y);

        // Check if the circles are disjoint (no intersection)
        if (distance > circle1.radius + circle2.radius || distance < Math.abs(circle1.radius - circle2.radius)) {
            return intersections; // Empty list (no intersections)
        }

        // Calculate the distance from circle1's center to the line that connects the intersection points
        double a = (circle1.radius * circle1.radius - circle2.radius * circle2.radius + distance * distance) / (2 * distance);
        // Calculate the h value, which represents the distance from circle1's center to the intersection points along the line
        double h = Math.sqrt(circle1.radius * circle1.radius - a * a);

        a = limitPrecisionToTwoDecimals((float)a);
        h = limitPrecisionToTwoDecimals((float) h);

        // Calculate the coordinates of the intersection points
        double x2 = circle1.center.x + a * (circle2.center.x - circle1.center.x) / distance;
        x2 = limitPrecisionToTwoDecimals((float) x2);

        double y2 = circle1.center.y + a * (circle2.center.y - circle1.center.y) / distance;
        y2 = limitPrecisionToTwoDecimals((float) y2);

        double intersectionX1 = x2 + h * (circle2.center.y - circle1.center.y) / distance;
        double intersectionY1 = y2 - h * (circle2.center.x - circle1.center.x) / distance;

        intersectionX1 = limitPrecisionToTwoDecimals((float) intersectionX1);
        intersectionY1 = limitPrecisionToTwoDecimals((float) intersectionY1);

        double intersectionX2 = x2 - h * (circle2.center.y - circle1.center.y) / distance;
        double intersectionY2 = y2 + h * (circle2.center.x - circle1.center.x) / distance;

        intersectionX2 = limitPrecisionToTwoDecimals((float) intersectionX2);
        intersectionY2 = limitPrecisionToTwoDecimals((float) intersectionY2);

        intersections.add(new Point(intersectionX1, intersectionY1));
        intersections.add(new Point(intersectionX2, intersectionY2));

        return intersections;
    }

    public static void main(String[] args) {
        // Example usage
        /*Circle circle1 = new Circle(3.62f, 3.06f, 2.12);
        Circle circle2 = new Circle(5.52f, 4.58f, 2.72);
        Circle circle3 = new Circle(7.44f, 3.3f, 2.51);*/

        Circle circleA = new Circle(7.46f, 3.18, 2.08);
        Circle circleB = new Circle(3.54, 2.56, 2.46);
        Circle circleC = new Circle(3.38, 2.92, 2.21);

        /*Circle circleA = new Circle(3.8f, 5.54, 1.1);
        Circle circleB = new Circle(4.48, 5.7, 1.81);
        Circle circleC = new Circle(5.17, 5.6, 2.49);*/


        List<Point> intersections = new ArrayList<>(10);
        List<Point> circle_A_B = findCircleIntersections(circleA, circleB);
        List<Point> circle_B_C = findCircleIntersections(circleB, circleC);
        List<Point> circle_A_C = findCircleIntersections(circleA, circleC);

        /*for (Point point : intersections) {

        }*/

        System.out.println("Intersection points: A - B");
        for (Point intersection : circle_A_B) {
            System.out.println("(" + intersection.x + ", " + intersection.y + ")");
        }

        System.out.println("Intersection points: B - C");
        for (Point intersection : circle_B_C) {
            System.out.println("(" + intersection.x + ", " + intersection.y + ")");
        }
        System.out.println("Intersection points: A - C");
        for (Point intersection : circle_A_C) {
            System.out.println("(" + intersection.x + ", " + intersection.y + ")");
        }
    }

    public Point getTrilaterationPoint (ArrayList<Point> intersections, Circle... circles) {
        HashMap<Point, Integer> pointMap = new HashMap<>(10);
        Point intersection;
        for (Point point : intersections) {
            for (Circle circle : circles) {

            }
        }
        return null;
    }

    public static float limitPrecisionToTwoDecimals(float number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Float.parseFloat(decimalFormat.format(number));
    }

}
