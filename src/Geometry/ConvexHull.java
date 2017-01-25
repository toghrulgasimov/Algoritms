/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import static Geometry.Point.turnleft;
import static Geometry.Point.turnright;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 *
 * @author Toghrul
 */
public  class ConvexHull {
    public static ArrayList<Point> l;
    public static ArrayList<Point> ConvexHull(Point[] p) {
        ArrayList<Point> ans = new ArrayList<Point>();
        
        Point[] st = new Point[p.length];
        int stsize = 0;
        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point t, Point t1) {
                if(t.x==t1.x) return Double.compare(t.y, t1.y);
                else return Double.compare(t.x, t1.x);
            }
            
        });
        if(p.length<=1) return null;
        Stack<Point> up = new Stack<Point>();
        Stack<Point> down = new Stack<Point>();
        Point p1=p[0],p2=p[p.length-1];
        up.add(p1);
        down.add(p1);
        for(int i=1;i<p.length;i++){
            if(i==p.length-1||turnright(p1, p[i], p2)){
                while(up.size()>=2&& !turnright(up.get(up.size()-2), up.get(up.size()-1), p[i]))
                    up.pop();
                up.add(p[i]);
            }
            if(i==p.length-1||turnleft(p1, p[i], p2)){
                while(down.size()>=2&& !turnleft(down.get(down.size()-2), down.get(down.size()-1), p[i]))
                    down.pop();
                down.add(p[i]);
            }
        }
        for(int i=0;i<up.size();i++)
            ans.add(up.get(i));
        for(int i=down.size()-2;i>0;i--)
            ans.add(down.get(i));
        return ans;
    }
}
