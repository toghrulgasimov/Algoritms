/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

/**
 *
 * @author Toghrul
 */
public class Line {
        public Geometry.Point p1, p2;
        public double a, b, c;
        public Line(Geometry.Point p1, Geometry.Point p2) {
            this.p1 = p1;
            this.p2 = p2;
            a = p1.y - p2.y;
            b = p2.x - p1.x;
            c = p1.x * p2.y - p2.x * p1.y;
        }
        public static Geometry.Point intersect(Line m, Line n) {
            double d = m.a * n.b - m.b * n.a;
            if(Math.abs(d) < 1e-9) return null;
            double x = -(m.c * n.b - n.c * m.b) / d;
            double y = -(m.a * n.c - m.c * n.a) / d;
            return new Geometry.Point(x, y);
        }
    }
