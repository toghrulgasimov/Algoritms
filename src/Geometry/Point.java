package Geometry;

public class Point {
        public double x, y;
        
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public Point sum(Point a, Point b) {
            return new Point(a.x + b.x, a.y + b.y);
        }
        public Point minus(Point a, Point b) {
            return new Point(a.x - b.x, a.y - b.y);
        }
        public Point mul(Point a, double x) {
            return new Point(a.x * x, a.y * x);
        }
        public double mul(Point a, Point b) {
            return a.x * b.y - b.x * a.y;
        }
        
    }