
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


    public static int n, m;
    public static int[] a, l, r, b;
    public static class Triple {
        public int l, r, k;

        public Triple(int l, int r, int k) {
            this.l = l;
            this.r = r;
            this.k = k;
        }
        
    }
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        InputReader in = new InputReader(inputStream);
        
        n = in.nextInt();
        m = in.nextInt();
        a = in.nextArray(n);
        b = new int[n];
        l = new int[m];
        r = new int[m];
        for(int i = 0; i < m; i++) {
            l[i] = in.nextInt() - 1;
            r[i] = in.nextInt() - 1;
            b[l[i]]++;
            if(r[i] < n - 1)
                b[r[i] + 1]--;
        }
        for(int i = 1; i < n; i++) {
            b[i] += b[i - 1];
        }
        Arrays.sort(a);
        //in.printAr(b);
        ArrayList<Triple> l = new ArrayList<Triple>();
        int x = 0;
        for(int i = 0; i < n; i++) {
            if(b[x] != b[i]) {
                l.add(new Triple(x, i - 1, b[x]));
                //out.println(x + " " + (i - 1) + " " + b[x]);
                x = i;
            }
            
        }
        l.add(new Triple(x, n - 1, b[x]));
        //out.println(x + " " + (n - 1) + " " + b[x]);
        Collections.sort(l, new Comparator<Triple>() {
            @Override
            public int compare(Triple t, Triple t1) {
                return Integer.compare(t1.k, t.k);
            }
            
        });
        int t = n - 1;
        long ans = 0;
        for(Triple xx : l) {
            for(int i = xx.l; i <= xx.r; i++, t--) {
                ans += 1L * xx.k * a[t];
            }
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
