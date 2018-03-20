package edu.whu.swe.lxl.learn.test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class MergeSortTest {
    @Test
            public void testMergeSort() {
        int[] array1 = {3, 7, 9, 34, 789};
        int[] array2 = {1, 82, 4};
        int[] testDest = new int[array1.length + array2.length];
        System.arraycopy(array1,0,testDest,0,array1.length);
        System.arraycopy(array2,0,testDest,array1.length,array2.length);
        int[] arrayDest = new int[testDest.length];
        assertArrayEquals("MergeSort is wrong",testDest,arrayDest);
        System.out.println(Arrays.toString(arrayDest));
    }
}
