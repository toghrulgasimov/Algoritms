package number;

import java.util.ArrayList;

public class NumberAlgorithms {

    public static ArrayList<Integer> primes(int n) {
        ArrayList<Integer> p = new ArrayList<Integer>();
        int[] lp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (lp[i] == 0) {
                lp[i] = i;
                p.add(i);
            }
            for (int j = 0; j < p.size() && p.get(j) <= lp[i] && i * p.get(j) <= n; j++) {
                lp[i * p.get(j)] = p.get(j);
            }
        }
        return p;
    }

    public static int[] getPhi(int n) {
        int[] phi = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            phi[i] = i;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = i + i; j <= n; j += i) {
                phi[j] -= phi[i];
            }
        }
        return phi;
    }
    public static long pow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if (b % 2 == 1) ans *= a;
            b >>= 1;
            a *= a;
        }
        return ans;
    }
    public static long powMod(long a, long b, long m) {
        long ans = 1;
        while (b > 0) {
            if (b % 2 == 1) ans = (ans * a) % m;
            b >>= 1;
            a = (a * a) % m;
        }
        return ans;
    }
    public static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static long gcdextend(long a, long b, long[] X) {
        if(b == 0) {
            X[0] = 1; X[1] = 0;
            return a;
        }else {
            long d = gcdextend(b, a % b, X);
            long x = X[1];
            long y = X[0] - X[1] * (a / b);
            X[0] = x;
            X[1] = y;
            return d;
        }
    }
}