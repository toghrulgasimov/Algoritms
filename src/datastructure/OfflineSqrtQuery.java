package datastructure;
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

public class OfflineSqrtQuery {

    public static int[] M;
    public static int n;
    public static void add(int x) {
        if(x<=n)
        M[x]++;
    }
    public static void remove(int x) {
        if(x<=n)
        M[x]--;
    }
    public static long get(int x) {
        if(x>n) return 0;
        return M[x];
    }
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        InputReader in = new InputReader(inputStream);
        
         n=in.nextInt();int q=in.nextInt();
         M=new int[n+10];
        int[] a=in.nextArray(n);
        int[][] Q=new int[q][3];
        for(int i=0;i<q;i++){
            Q[i][0]=in.nextInt()-1;
            Q[i][1]=in.nextInt()-1;
            Q[i][2]=i;
        }
        int BLOCK_SIZE=(int)Math.sqrt(n);
        
        Arrays.sort(Q, new Comparator<int[]>(){
            @Override
            public int compare(int[] t, int[] t1) {// das ist nicht eine aenliche coke
                int x=t[0]/BLOCK_SIZE;
                int y=t1[0]/BLOCK_SIZE;
                if(x==y) return t1[1]-t[1];
                else return x-y;
            }
        });
        long[] answer=new long[q];
        int L=Q[0][0],R=Q[0][1];
        long ans=0;
        for(int i=Q[0][0];i<=Q[0][1];i++){
            ans -= get(a[i])*get(a[i])*a[i];
            add(a[i]);
            ans += get(a[i])*get(a[i])*a[i];
        }
        answer[Q[0][2]]=ans;
        out.println(Q[0][0] + "asdd " + Q[0][1]);
        for(int i=1;i<q;i++){
            while(L<Q[i][0]){
                ans -= get(a[L])*get(a[L])*a[L];
                remove(a[L]);
                ans -= get(a[L])*get(a[L])*a[L];
                L++;
            }
            while(Q[i][0]<L){
                ans -= get(a[L-1])*get(a[L-1])*a[L-1];
                add(a[L-1]);
                ans += get(a[L-1])*get(a[L-1])*a[L-1];
                L--;
            }
            while(R<Q[i][1]){
                ans -= get(a[R+1])*get(a[R+1])*a[R+1];
                add(a[R+1]);
                ans += get(a[R+1])*get(a[R+1])*a[R+1];
                R++;
            }
            while(R>Q[i][1]){
                ans -= get(a[R])*get(a[R])*a[R];
                remove(a[R]);
                ans += get(a[R])*get(a[R])*a[R];
                R--;
            }
            answer[Q[i][2]]=ans;
        }
        /*for(int i=0;i<q;i++)
            out.println(answer[i]);*/
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