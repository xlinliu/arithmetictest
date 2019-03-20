package edu.whu.swe.lxl.learn.Search;

public class BinarySearch {
    public static void main(String[] args) {
        int N = 100000;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }
        for (int i = 0; i < 500; i++) {
            int data = (int) Math.random() * N;
            assert data == binarySearch(array, 0, array.length, data);
        }

        assert -1 == binarySearch(array, 0, array.length, -2);
        for (int i = 0; i < 500; i++) {
            int data = (int) Math.random() * N;
            assert data == binarySearch_iterative(array,data);
        }

        assert -1 == binarySearch_iterative(array, -2);
    }

    public static int binarySearch(int[] array, int left, int right, int data) {
        if (left > right)
            return -1;
        int mid = (left + right) / 2;
        if (data > array[mid]) return binarySearch(array, mid + 1, right, data);
        else if (data < array[mid]) return binarySearch(array, left, mid - 1, data);
        else return mid;
    }

    public static int binarySearch_iterative(int[] array,int key){
        int left=0,right=array.length-1;
        int mid;
        while (left<=right){
            mid=(left+right)>>>1;
            if(array[mid]>key) right=mid-1;
            else if(array[mid]<key) left=mid+1;
            else
                return mid;
        }
        return -1;
    }
}
