package edu.whu.swe.lxl.learn;

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args){
        Integer[] array = {1};
//        permuteByRecursion(array,4);
        while(permuteByEnum(array)>=0)
        System.out.println(Arrays.toString(array));
    }

    public static <T extends Comparable<? super T>>void permuteByRecursion(T[] array,int n){
        if(n==array.length-1){
            System.out.print(Arrays.toString(array)+"\n");
            return;
        }

        for(int i=n;i<array.length;i++){
            swap(array,i,n);
            permuteByRecursion(array,n+1);
            swap(array,i,n);

        }
    }
    public static  <T extends Comparable<? super T>> int permuteByEnum(T[] array){
        if(array.length<2)
            return array.length;
        int i=array.length-2,j;
        while (i>=0){
            if (array[i].compareTo(array[i+1])<0)
                break;
            --i;
        }
        if(i<0) return i;
        for(j=array.length-1;j>i;j--){
            if(array[i].compareTo(array[j])<0)
                break;
        }
        swap(array,i,j);
        int l=i+1,r=array.length-1;
        while (l<r){
            swap(array,l++,r--);
        }
        return i;
    }
    private static <T extends Comparable<? super T>> void swap(T[] array,int i,int j){
        T temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
