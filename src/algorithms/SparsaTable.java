package algorithms;


public class SparsaTable {
    public long[][] M;
    public int[] log;
    public int n, k;
    public SparsaTable(int n) {
        log = new int[n + 1];
        log[1] = 0;
        this.n = n;
        
        for(int i = 2; i <= n; i++) {
            log[i] = log[i >> 1] + 1;
        }
        
        this.k = log[n];
        M = new long[n][k + 1];
    }
    public void init(long[] a) {
        for(int i = 0; i < n; i++) {
            M[i][0] = a[i];
        } // 
        for(int j = 1; j <= k; j++) {
            for(int i = 0; i + (1<<(j - 1)) < n; i++) {
                M[i][j] = Math.min(M[i][j - 1], M[i + (1<<(j - 1))][j - 1]);
            }
        }
    }
    public long get(int l, int r) {
        int k = log[r - l + 1];
        return Math.min(M[l][k], M[r - (1<<k) + 1][k]);
    }
}
