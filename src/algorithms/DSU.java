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
public class DSU {
    public int[] parent;
    public int[] rank;
    public int count;
    public DSU(int n) { 
        parent = new int[n];
        rank = new int[n];
        count = n;
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return;
        if(rank[x] > rank[y]) {
            parent[y] = x;
        }else {
            parent[x] = y;
            if(rank[x] == rank[y]) rank[y]++;
        }
    }
}
