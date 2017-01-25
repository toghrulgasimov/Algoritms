package Geometry;

public class Point {
        public double x, y;
        
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public static Point sum(Point a, Point b) {
            return new Point(a.x + b.x, a.y + b.y);
        }
        public static Point minus(Point a, Point b) {
            return new Point(a.x - b.x, a.y - b.y);
        }
        public static Point mul(Point a, double x) {
            return new Point(a.x * x, a.y * x);
        }
        public static double mul(Point a, Point b) {
            return a.x * b.y - b.x * a.y;
        }
        public static double dist(Point a, Point b) {
            return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
        }
        public static boolean on(Point a, Point b, Point c) {
            if(Math.abs(dist(a, b) - dist(a, c) - dist(b, c)) < 1e-9) return true;
            return false;
        }
        public static boolean turnleft(Point p0, Point p1, Point p2) {
            p1 = minus(p1, p0);
            p2 = minus(p2, p0);
            double d = mul(p1, p2);
            return d > 0;
        }
        public static boolean turnright(Point p0, Point p1, Point p2) {
            p1 = minus(p1, p0);
            p2 = minus(p2, p0);
            double d = mul(p1, p2);
            return d < 0;
        }
    }