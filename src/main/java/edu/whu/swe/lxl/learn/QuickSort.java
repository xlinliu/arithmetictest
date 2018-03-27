package edu.whu.swe.lxl.learn;

public class QuickSort {
    public static <T extends Comparable<T>> void sort(T[] array, int l, int r) {
        if(l>=r) return;
        int i=l,j=r;
        T tmp = array[i];
        while (j > i) {
            while (array[j].compareTo(tmp)>=0&&j>i)
                --j;
            if(j>i)
                array[i++] = array[j];
            while (array[i].compareTo(tmp)<=0&&j>i)
                ++i;
            if(j>i)
                array[j--] = array[i];
        }
        array[j]=tmp;
        sort(array, l, i-1);
        sort(array,i+1,r);
    }
}
