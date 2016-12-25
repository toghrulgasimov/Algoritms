
package algorithms;


public class Geometry {
    public class Point {
        public double x, y;
        
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public Point sum(Point a, Point b) {
            return new Point(a.x + b.x, a.y + b.y);
        }
        public Point sub(Point a, Point b) {
            return new Point(a.x + b.x, a.y + b.y);
        }
        public Point mul(Point a, double x) {
            return new Point(a.x * x, a.y * x);
        }
        public double mul(Point a, Point b) {
            return a.x * b.y - b.x * a.y;
        }
        
    }
    public class Line {
        public Point p1, p2;
        public double a, b, c;
        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
            a = p2.y - p1.y;
            b = p1.x - p2.x;
            c = p1.x * p2.y - p2.x * p1.y;
        }
        public double[] intersect(Line m, Line n) {
            
            return new double[3];
        }
    }
}
