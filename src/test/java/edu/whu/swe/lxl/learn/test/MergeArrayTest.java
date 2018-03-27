package edu.whu.swe.lxl.learn.test;

import edu.whu.swe.lxl.learn.FindTopN;
import edu.whu.swe.lxl.learn.MergeArray;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class MergeArrayTest {
    @Test
    public void testMerge() {
        int[] array = {3, 7, 9, 34, 789,1, 4, 8, 100};
        int[] testArray = Arrays.copyOf(array, array.length);
        int[] arrayDest = new int[array.length];
        Arrays.sort(testArray);
        try {
            MergeArray.merge(array, 5, arrayDest);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(array));
        assertArrayEquals("MergeSort is wrong", arrayDest, testArray);

    }

}
