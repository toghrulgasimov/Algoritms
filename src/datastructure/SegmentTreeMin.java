/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author Toghrul
 */
public class SegmentTreeMin {
    public class Node {
        long d;
        public Node(long d) {
            this.d = d;
        }
    }
    public Node merge(Node t1, Node t2){
        return new Node(Math.min(t1.d, t2.d));
    }
    public int height, maxsize, n;
    public Node T[];
    public SegmentTreeMin(long[] a) {
        n = a.length;
        height = (int)Math.ceil((Math.log(a.length) / Math.log(2)));
        maxsize = (int)(2 * Math.pow(2, height) - 1);
        T = new Node[maxsize + 1];
        init(1, a, 0, a.length - 1);
    }
    public void init(int x, long[] a, int l, int r) {
        if(l == r) {
            T[x] = new Node(a[l]);
        }else {
            int m = (l + r) >> 1;
            init(x << 1, a, l, m);
            init((x << 1) | 1, a, m + 1, r);
            T[x] = merge(T[x << 1], T[(x << 1) | 1]);
        }
    }
    public Node getMin(int x, int l, int r, int ll, int rr) {
        if(ll <= l && r <= rr) return T[x];
        if(r < ll || rr < l) return new Node(Long.MAX_VALUE);
        int m = (l + r) >> 1;
        return merge(getMin(x << 1, l, m, ll, rr), getMin((x << 1) | 1, m + 1, r, ll, rr));
    }
    public void update(int x, int l, int r, int i, long v) {
        if(l == r && l == i) {
            T[x] = new Node(v);
            return;
        }
        int m = (l + r) >> 1;
        if(l <= i && i <= m) update(x << 1, l, m, i, v);
        else if(m + 1 <= i && i <= r)update(x << 1 | 1, m + 1, r, i, v);
        T[x] = merge(T[x << 1], T[x << 1 | 1]);
    }
    public void update(int i, long v) {
        update(1, 0, n - 1, i, v);
    }
    public Node getMin(int l, int r) {
        return getMin(1, 0, n - 1, l, r);
    }
}
