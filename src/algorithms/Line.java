/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

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
            a = p2.y - p1.y;
            b = p1.x - p2.x;
            c = p1.x * p2.y - p2.x * p1.y;
        }
        public double[] intersect(Line m, Line n) {
            
            return new double[3];
        }
    }
