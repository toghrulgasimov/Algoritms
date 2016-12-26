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
public class Sortings {
    public static int[] CountingSort(int[] a, int max) {
        int n = a.length;
        int[] b = new int[n];
        int[] c = new int[max + 1];
        for(int i = 0; i < n; i++)
            c[a[i]]++;
        for(int i = 1; i <= max; i++)
            c[i] += c[i - 1];
        for(int i = n - 1; i >= 0; i--) {
            b[--c[a[i]]] = a[i];
        }
        return b;
    }
}
