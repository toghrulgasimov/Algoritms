package strings;


/**
 *
 * @author Toghrul
 */
public class StringAlgorithms {

    public static long[] pow;

    public static long[] getHashArray(String s) {
        long[] hash = new long[s.length()];

        hash[0] = s.charAt(0);
        pow[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            hash[i] = hash[i - 1] * 31 + s.charAt(i);
            pow[i] = pow[i - 1] * 31;
        }
        return hash;
    }

    public static long getHash(long[] hash, int l, int r) {
        if (l == 0) {
            return hash[r];
        }
        return hash[r] - hash[l - 1] * pow[r - l + 1];
    }

    public static int[] KMP(String s) {
        int n = s.length();
        int[] fail = new int[s.length()];
        fail[0] = -1;
        int k = -1;
        for (int i = 1; i < n; i++) {
            while (k > -1 && s.charAt(k + 1) != s.charAt(i)) {
                k = fail[k];
            }
            if (s.charAt(k + 1) == s.charAt(i)) {
                k++;
            }
            fail[i] = k;
        }
        return fail;
    }
    public static int[] palindrome(char[] str)
	{
		int n = str.length;
		int[] r = new int[2*n];
		int k = 0;
		for(int i = 0, j = 0;i < 2*n;i += k, j = Math.max(j-k, 0)){
			// 普通の回文検査
			while(i-j >= 0 && i+j+1 < 2*n && str[(i-j)/2] == str[(i+j+1)/2])j++;
			r[i] = j;
			
			// 定理に基づいて回文検査を端折る
			for(k = 1;i-k >= 0 && r[i]-k >= 0 && r[i-k] != r[i]-k;k++){
				r[i+k] = Math.min(r[i-k], r[i]-k);
			}
		}
		return r;
	}
}
