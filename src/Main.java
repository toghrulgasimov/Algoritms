
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


    public static class SparsaTable {

        public int[][] M;
        public int[] log;
        public int n, k;

        public SparsaTable(int n) {
            log = new int[n + 1];
            log[1] = 0;
            this.n = n;

            for (int i = 2; i <= n; i++) {
                log[i] = log[i >> 1] + 1;
            }

            this.k = log[n];
            M = new int[n][k + 1];
        }

        public void init(int[] a) {
            for (int i = 0; i < n; i++) {
                M[i][0] = a[i];
            } // 
            for (int j = 1; j <= k; j++) {
                for (int i = 0; i + (1 << (j - 1)) < n; i++) {
                    M[i][j] = Math.min(M[i][j - 1], M[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        public int get(int l, int r) {
            if (r < l) {
                return 0;
            }
            int k = log[r - l + 1];
            return Math.min(M[l][k], M[r - (1 << k) + 1][k]);
        }
    }

    public static class SparsaTable2 {

        public int[][] M;
        public int[] log;
        public int n, k;

        public SparsaTable2(int n) {
            log = new int[n + 1];
            log[1] = 0;
            this.n = n;

            for (int i = 2; i <= n; i++) {
                log[i] = log[i >> 1] + 1;
            }

            this.k = log[n];
            M = new int[n][k + 1];
        }

        public void init(int[] a) {
            for (int i = 0; i < n; i++) {
                M[i][0] = a[i];
            } // 
            for (int j = 1; j <= k; j++) {
                for (int i = 0; i + (1 << (j - 1)) < n; i++) {
                    M[i][j] = Math.max(M[i][j - 1], M[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        public int get(int l, int r) {
            if (r < l) {
                return 0;
            }
            int k = log[r - l + 1];
            return Math.max(M[l][k], M[r - (1 << k) + 1][k]);
        }
    }
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        InputReader in = new InputReader(inputStream);

        int n = in.nextInt();
        int[] a = in.nextArray(n);
        int[] b = in.nextArray(n);
        SparsaTable sa = new SparsaTable(n);
        sa.init(a);
        SparsaTable sa2 = new SparsaTable(n);
        sa2.init(b);
        long ans = 0;
        for(int i = 0; i < n; i++) {
            int l = i, r = n - 1, m;
            int lower = -1;
            while(l <= r) {
                m = (l + r) >> 1;
                int d1 = sa.get(i, m);
                int d2 = sa2.get(1, m);
                if(d1 == d2) {
                    lower = m;
                    r = m - 1;
                }else if(d1 > d2) {
                    l = m + 1;
                }else {
                    r = m - 1;
                }
            }
            l = i; r = n - 1; m = 0;
            int upper = -1;
            while(l <= r) {
                m = (l + r) >> 1;
                int d1 = sa.get(i, m);
                int d2 = sa2.get(1, m);
                if(d1 == d2) {
                    lower = m;
                    l = m  + 1;
                }else if(d1 > d2) {
                    l = m + 1;
                }else {
                    r = m - 1;
                }
            }
            if(lower > -1 && lower > -1)
            ans += (upper - lower);
        }
        out.println(ans);
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
