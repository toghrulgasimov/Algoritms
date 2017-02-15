/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;


public class MergeTwoArrayList {
    public static long[]merge(long[]a,long[]b){
        long[]c=new long[a.length+b.length];
        int cura=0,curb=0,curc=0;
        while(cura<a.length||curb<b.length){
            if(cura==a.length)c[curc++]=b[curb++];
            else if(curb==b.length)c[curc++]=a[cura++];
            else if(a[cura]<=b[curb])c[curc++]=a[cura++];
            else if(a[cura]>b[curb])c[curc++]=b[curb++];
        }
        return c;
    }
}
