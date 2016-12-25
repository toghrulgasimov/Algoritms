/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Toghrul
 */
public class SegmentTreeSum {
    public int height, maxsize;
    public long T[];
    public SegmentTreeSum(int[] a) {
        height = (int)Math.ceil((Math.log(a.length) / Math.log(2)));
        maxsize = (int)(2 * Math.pow(2, height) - 1);
        T = new long[maxsize];
        init(1, a, 0, a.length - 1);
    }
    public void init(int x, int[] a, int l, int r) {
        if(l == r) {
            T[x] = a[l];
        }else {
            int m = (l + r) >> 1;
            init(x << 1, a, l, m);
            init(x << 1 | 1, a, m + 1, r);
            T[x] = T[x << 1] + T[x << 1 | 1];
        }
    }
    public long getSum(int x, int l, int r, int ll, int rr) {
        if(ll <= l && r <= rr) return T[x];
        if(r < ll || rr < l) return 0;
        int m = (l + r) >> 1;
        return getSum(x << 1, l, m, ll, rr) + getSum(x << 1 | 1, m + 1, r, ll, rr);
    }
}
