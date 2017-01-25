
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    //                       0 1 2 3 4
    public  static class ConvexHull {
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
            if(i==p.length-1||Point.turnright(p1, p[i], p2)){
                while(up.size()>=2&& !Point.turnright(up.get(up.size()-2), up.get(up.size()-1), p[i]))
                    up.pop();
                up.add(p[i]);
            }
            if(i==p.length-1||Point.turnleft(p1, p[i], p2)){
                while(down.size()>=2&& !Point.turnleft(down.get(down.size()-2), down.get(down.size()-1), p[i]))
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
    
    public static class  Point {
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
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        InputReader in = new InputReader(inputStream);
        
        int n = in.nextInt();
        Point[] p = new Point[n];
        for(int i=0;i<n;i++){
            p[i]=new Point(in.nextInt(),in.nextInt());
        }
        ArrayList<Point>ans = ConvexHull.ConvexHull(p);
        double sum=0;
        for(int i=0;i<ans.size();i++){
            sum+=Point.dist(ans.get(i), ans.get((i+1)%ans.size()));
        }
        out.printf("%.1f\n", sum);
        out.close();
    }

    static class InputReader {

        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream), 32624);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public double[] nextArrayd(int n) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextDouble();
            }
            return a;
        }

        private BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public void printAr(int[] a) {
            System.out.print("[");
            for (long x : a) {
                System.out.print(x + ",");
            }
            System.out.print("]");
        }
    }

}