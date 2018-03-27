package edu.whu.swe.lxl.learn.sort;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {
    public static void main(String[] args) {
        int n = 100;
        int[] array = new int[n];
        Random random = new Random();
        for(int i=0;i<n;i++)
            array[i]=random.nextInt();
        int[] expected_array = new int[n];
        System.arraycopy(array, 0, expected_array, 0, array.length);
        Arrays.sort(expected_array);
        sort(array);
        for(int i=0;i<n;i++)
            assert expected_array[i]==array[i];
    }

    public static void sort(int... array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i;
            while (j > 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                --j;
            }
            array[j] = tmp;
        }
    }
}

