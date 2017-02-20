package number;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberAlgorithms {

    long sumdivisor(int[] d){
        long ans=1;
        for(int i=2;i<=1000;i++){
            if(d[i]>0)
            ans *= (pow(i,d[i]+1)-1)/(i-1);
        }
        return ans;
    }
    public static int[] sieveEratosthenes(int n) {
		if(n <= 32){
			int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
			for(int i = 0;i < primes.length;i++){
				if(n < primes[i]){
					return Arrays.copyOf(primes, i);
				}
			}
			return primes;
		}

		int u = n + 32;
		double lu = Math.log(u);
		int[] ret = new int[(int) (u / lu + u / lu / lu * 1.5)];
		ret[0] = 2;
		int pos = 1;

		int[] isp = new int[(n + 1) / 32 / 2 + 1];
		int sup = (n + 1) / 32 / 2 + 1;

		int[] tprimes = { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
		for(int tp : tprimes){
			ret[pos++] = tp;
			int[] ptn = new int[tp];
			for(int i = (tp - 3) / 2;i < tp << 5;i += tp)
				ptn[i >> 5] |= 1 << (i & 31);
			for(int i = 0;i < tp;i++){
				for(int j = i;j < sup;j += tp)
					isp[j] |= ptn[i];
			}
		}

		// 3,5,7
		// 2x+3=n
		int[] magic = { 0, 1, 23, 2, 29, 24, 19, 3, 30, 27, 25, 11, 20, 8, 4,
				13, 31, 22, 28, 18, 26, 10, 7, 12, 21, 17, 9, 6, 16, 5, 15, 14 };
		int h = n / 2;
		for(int i = 0;i < sup;i++){
			for(int j = ~isp[i];j != 0;j &= j - 1){
				int pp = i << 5 | magic[(j & -j) * 0x076be629 >>> 27];
				int p = 2 * pp + 3;
				if(p > n)
					break;
				ret[pos++] = p;
				for(int q = pp;q <= h;q += p)
					isp[q >> 5] |= 1 << (q & 31);
			}
		}

		return Arrays.copyOf(ret, pos);
	}
    int phi(int n) {
        int result = n;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

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

    public static boolean isPrime(long a) {
        for (long i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long inverse(long a, long MOD) {
        return powMod(a, MOD, MOD - 2);
    }

    public static int[] getPhitourist(int n) {
        int[] phi = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            phi[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i + i; j <= n; j += i) {
                phi[j] -= phi[i];
            }
        }
        return phi;
    }

    public static int[] getPhi(int n) { // das ist besser
        int[] phi = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            phi[i] = i;
        }
        for (int p = 2; p <= n; p++) {
            if (phi[p] == p) {
                phi[p] = p - 1;
                for (int j = p + p; j <= n; j += p) {
                    phi[j] = (phi[j] / p) * (p - 1);
                }
            }

        }
        return phi;
    }

    public static boolean isPrimeRandom(long n) {
        return true;
    }

    public static long pow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ans *= a;
            }
            b >>= 1;
            a *= a;
        }
        return ans;
    }

    public static long powMod(long a, long b, long m) {
        long ans = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ans = (ans * a) % m;
            }
            b >>= 1;
            a = (a * a) % m;
        }
        return ans;
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long gcdextend(long a, long b, long[] X) {
        if (b == 0) {
            X[0] = 1;
            X[1] = 0;
            return a;
        } else {
            long d = gcdextend(b, a % b, X);
            long x = X[1];
            long y = X[0] - X[1] * (a / b);
            X[0] = x;
            X[1] = y;
            return d;
        }
    }
}
