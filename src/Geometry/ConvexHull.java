/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Toghrul
 */
public  class ConvexHull {
    public static ArrayList<Point> l;
    public static ArrayList<Point> ConvexHull(Point[] p) {
        ArrayList<Point> ans = new ArrayList<Point>();
        int miny = 0;
        for(int i = 0; i < p.length; i++) {
            if(p[i].y < p[miny].y)
                miny = i;
        }
        final int y = miny;
        Point[] st = new Point[p.length];
        int stsize = 0;
        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point t, Point t1) {
                if(Point.turnleft(p[y], t, t1)) return 1;
                return 0;
            }
            
        });
        return ans;
    }
}
