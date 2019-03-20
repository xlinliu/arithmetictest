package edu.whu.swe.lxl.learn.sort;

import java.util.Random;

public class QuickSort {
    private static final int CUTOFF = 10;

    public static void main(String[] args) {
        Random random = new Random();
        int N = 100000;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt();
        }
        quickSort(array, 0, array.length - 1);

        for (int j = array.length - 1;j>0;j--)
            assert  array[j] > array[j - 1];
    }

    public static void quickSort(int[] array, int left, int right) {
        if (right - left <= CUTOFF) {
            insertSort(array, left, right);
            return;
        } else {
            median3(array, left, right);
            int i = left, j = right - 1;
            while (i < j) {
                while (array[++i] < array[right - 1]) ;
                while (array[--j] > array[right - 1]) ;
                if (i < j) {
                    swap(array, i, j);
                }
            }
            swap(array, i, right - 1);
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        }
    }

    public static void insertSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = array[i];
            int j = i;
            while (j > left && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public static void median3(int[] array, int left, int right) {

        int center = (left + right) / 2;
        if (array[center] < array[left])
            swap(array, center, left);
        if (array[right] < array[left])
            swap(array, left, right);
        if (array[center] > array[right])
            swap(array, center, right);
        swap(array, center, right - 1);
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
