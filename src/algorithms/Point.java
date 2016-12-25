package algorithms;

public  class Point {
    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public static double dist(Point a,Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (b.y - a.y) * (b.y - a.y));
    }
}