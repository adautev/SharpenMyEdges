package ConvexHull.Utils;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public static class Utils {
        public static boolean CounterClockWise(Point a, Point b, Point c){
            double planarArea = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
            return planarArea < 0;
        }
    }
}
