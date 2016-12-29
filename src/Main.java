
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        InputReader in = new InputReader(inputStream);
        
        int n = in.nextInt(), k = in.nextInt();
        String[] pass = new String[n];
        for(int i = 0; i < n; i++) {
            pass[i] = in.next();
        }
        String correct = in.next();
        Arrays.sort(pass, new Comparator<String>() {
            @Override
            public int compare(String t, String t1) {
                return Integer.compare(t.length(), t1.length());
            }
        });
        int min = 0, max = 0;
        for(int i = 0; i < n; i++) {
            if(pass[i].length() == correct.length()) {
                min = i;
                break;
            }
        }
        for(int i = 0; i < n; i++) {
            if(pass[i].length() == correct.length()) {
                max = i;
            }
        }
        int ans1 = 0, t = 0;
        for(int i = 0; i <= min; i++) {
            if(t % k == 0 && t != 0) ans1 += 5;
            ans1 += 1;
            t++;
        }
        int ans2 = 0; t = 0;
        for(int i = 0; i <= max; i++) {
            if(t % k == 0 && t != 0) ans2 += 5;
            ans2 += 1;
            t++;
        }
        out.println(ans1 + " " + ans2);
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
