/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;


public class Line {
    public double a,b,c;
    public Point p1,p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        if (Math.abs(p1.x-p2.x)<1e-7) { // vertical line is fine
            a=1.0;
            b=0.0;
            c=-p1.x; // default values
        } else {
            a=-(p1.y-p2.y)/(p1.x-p2.x);
            b=1.0;
            c=-(a*p1.x)-p1.y;
        }
    }
    public static boolean areParalel(Line l1,Line l2){
        return Math.abs(l1.a-l2.a)<1e-7&&Math.abs(l1.b-l2.b)<1e-7;
    }
    public static boolean areSame(Line l1,Line l2){
        return areParalel(l1, l2)&&Math.abs(l1.c-l2.c)<1e-7;
    }
    public static Point intersect(Line l1, Line l2){
        if(areParalel(l1, l2)) return null;
        Point p=new Point(0,0);
        p.x = (l2.b * l1.c - l1.b * l2.c) / (l2.a * l1.b - l1.a * l2.b);
        // special case: test for vertical line to avoid division by zero
        if (Math.abs(l1.b) > 1e-7) p.y = -(l1.a * p.x + l1.c);
        else p.y = -(l2.a * p.x + l2.c);
        return p;
    }
}
