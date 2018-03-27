package edu.whu.swe.lxl.learn;

import java.util.Arrays;

public class FindTopN {
    public static int[] findTopN(int[] array,int n){
        int[] topN=new int[n];
        Arrays.sort(array,0,n-1);
        int lastSortedIndex=0,minIndex=0;
        for(int i=n;i<array.length;i++){
            if(array[i]>array[minIndex])
            {
                array[minIndex] = array[i];
                if(minIndex==lastSortedIndex&&lastSortedIndex<n-1)
                    ++lastSortedIndex;

                minIndex=findMin(array,0,lastSortedIndex);
            }
        }
        System.arraycopy(array,0,topN,0,n);
        return topN;
    }
    public static int findMin(int[] array,int l,int r){
        int index=l;
        for(int i=l;i<=r;i++){
            if(array[i]<array[index])
                index=i;
        }
        return index;
    }
}
