package datastructure;

public  class BinaryHeap {
    public long[]a;
    public int size=0;
    public BinaryHeap(int n) {
        a=new long[n];
    }
    public void print(int x){
        if(x>=size)return;
        System.out.print(a[x]+" ");
        print(x*2+1);
        print(x*2+2);
    }
    public void insert(long x){
        size++;
        a[size-1]=x;
        int cur=size-1;
        while(cur>0){
            if(a[(cur-1)/2]>a[cur]){
                long tmp=a[(cur-1)/2];
                a[(cur-1)/2]=a[cur];
                a[cur]=tmp;
            }
            cur=(cur-1)/2;
        }
    }
    public void delete(int k){
        a[k]=a[size-1];
        size--;
        int l=0,r=0,cur=k,min=-1;
        while(true){
            l=cur*2+1;
            r=cur*2+2;
            min=cur;
            if(l<size&&a[l]<a[min])min=l;
            if(r<size&&a[r]<a[min])min=r;
            if(cur==min)break;
            long tmp=a[cur];a[cur]=a[min];a[min]=tmp;
            cur=min;
        }
    }
}