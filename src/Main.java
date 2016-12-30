
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

    public static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static Map<Long, Boolean> m = new HashMap<>();
    public static long x = 1234567, y = 123456, z = 1234;
    public static long n;
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        InputReader in = new InputReader(inputStream);
        
        n = in.nextInt();
        
        for(int i = 0; i * x <= n; i++) {
            for(int j = 0; i * x + j * y <= n; j++) {
                if((n - i * x - j*y) % z == 0) {
                    out.println("YES"); out.close();
                    return;
                }
            }
        }
        out.println("NO");
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
