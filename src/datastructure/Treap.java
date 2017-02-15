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
public class Treap {
    public class Node {
        long d,b;
        public Node(long d,long b) {
            this.d=d;
            this.b=b;
        }
    }
    public Node[]a;
    public int size=0;
    public Treap(int n) {
        a=new Node[n];
        
    }
    public void print(int x){
        if(x>=size)return;
        System.out.print(a[x].d+" ");
        print(x*2+1);
        print(x*2+2);
    }
    public void insert(long x){
        size++;
        a[size-1]=new Node(x,0);
        int cur=size-1;
        while(cur>0){
            if(a[(cur-1)/2].d>a[cur].d){
                //swap(a[(cur-1)/2],a[cur]);
                Node tmp=a[cur];a[cur]=a[(cur-1)/2];a[(cur-1)/2]=tmp;
            }
            cur=(cur-1)/2;
        }
    }
    public void insertb(long b,long h){
        
    }
    public void delete(int k){
        a[k]=a[size-1];
        a[size-1]=null;
        size--;
        int l=0,r=0,cur=k,min=-1;
        while(true){
            l=cur*2+1;
            r=cur*2+2;
            min=cur;
            if(l<size&&a[l].d<a[min].d)min=l;
            if(r<size&&a[r].d<a[min].d)min=r;
            if(cur==min)break;
            //swap(a[cur],a[min]);
            Node tmp=a[cur];a[cur]=a[min];a[min]=tmp;
            cur=min;
        }
    }
}
