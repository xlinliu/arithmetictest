package edu.whu.swe.lxl.learn.Search;

public class MinNumInRotatedArray {
    public static void main(String[] args){
        int[] array={};
        int min=findMin(array);
        assert min==0;

    }
    public static int findMin(int[] array){
        int left=0,right=array.length-1;
        if(array[left]<array[right])
            return array[left];
        int mid;
        while (true){
            if(left==right-1)
                return array[right];
            mid=(left+right)>>>1;
            if(array[mid]>array[left])
                left=mid;
            else if(array[mid]<array[left])
                right=mid;
            else {
                int min=array[left];
                for(;left<=right;left++){
                    if(left<right&&array[left]>array[left+1])
                        return array[left + 1];
                    if(array[left]<mid)
                        min=array[left];
                }
                return mid;
            }
        }
    }
}
