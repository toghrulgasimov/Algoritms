package datastructure;


public class SparsaTable {
    public int[][] M;
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
        M = new int[n][k + 1];
    }
    public void init(int[] a) {
        for(int i = 0; i < n; i++) {
            M[i][0] = a[i];
        } // 
        for(int j = 1; j <= k; j++) {
            for(int i = 0; i + (1<<j) - 1 < n; i++) {
                M[i][j] = Math.min(M[i][j - 1], M[i + (1<<(j - 1))][j - 1]);
            }
        }
    }
    public int get(int l, int r) {
        if(r < l) return 0;
        int k = log[r - l + 1];
        return Math.min(M[l][k], M[r - (1<<k) + 1][k]);
    }
}
