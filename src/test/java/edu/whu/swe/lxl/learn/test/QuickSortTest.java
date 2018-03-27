package edu.whu.swe.lxl.learn.test;

import edu.whu.swe.lxl.learn.FindTopN;
import edu.whu.swe.lxl.learn.QuickSort;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortTest {
    @Test
    public void testQuickSort() {
        Integer[] array = {1,0};
        Integer[] sortedArray = new Integer[array.length];
        System.arraycopy(array,0,sortedArray,0,array.length);
        Arrays.sort(sortedArray);
        QuickSort.sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
        assertArrayEquals("sort failed",array,sortedArray);
    }
    @Test
    public void testE() {
//System.out.print(Integer.parseInt("F",16));
System.out.print(1%(-12));
    }

}
