package algorithms;


public class BinarySear {
    public static int searchl(long[] a, int l, int r, long x) {
        int ans = -1;
        while(l <= r) {
            int m = (l + r) / 2; // 1 2 3 5 5 5 5 7
            if(x <= a[m]) {
                ans = m;
                r = m - 1;
            }else {
                l = m;
            }
        }
        return ans;
    }
    public static int searchr(long[] a, int l, int r, long x) {
        int ans = -1;
        while(l <= r) {
            int m = (l + r) / 2; // 1 2 3 5 5 5 5 7
            if(a[m] <= x) {
                ans = m;
                l = m + 1;
            }else {
                r = m - 1;
            }
        }
        return ans;
    }
}
