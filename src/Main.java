
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

        char[] a = in.next().toCharArray();
        int t = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {

                for (char x = 'A'; x <= 'A' + k - 1; x++) {
                    if (x != a[i] && i != n - 1 && x != a[i + 1]) {
                        a[i] = x;
                        t++;
                        break;
                    } else if (i == n - 1 && x != a[i]) {
                        a[i] = x;
                        t++;
                        break;
                    }
                }
            }
        }
        char[] b = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            b[n - i - 1] = a[i];
        }
        boolean p = true;
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                p = false;
                break;
            }
        }
        if (p) {
            out.println(t);
            out.println(new String(a));
        } else {
            for (int i = 1; i < n; i++) {
                if (b[i] == b[i - 1]) {

                    for (char x = 'A'; x <= 'A' + k - 1; x++) {
                        if (x != b[i] && i != n - 1 && x != b[i + 1]) {
                            b[i] = x;
                            t++;
                            break;
                        } else if (i == n - 1 && x != b[i]) {
                            b[i] = x;
                            t++;
                            break;
                        }
                    }
                }
            }
            out.println(t);
            for(int i = n - 1; i >= 0; i--) out.print(b[i]);
        }
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
