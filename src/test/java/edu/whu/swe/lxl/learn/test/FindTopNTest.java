package edu.whu.swe.lxl.learn.test;

import edu.whu.swe.lxl.learn.FindTopN;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

public class FindTopNTest {
    @Test
    public void testFindMin(){
        int[] array = {1, 8,0, 4, 90, -1, 455, 3, 7, 8, 0, 2};
        int min= FindTopN.findMin(array, 0, array.length - 1);
        assertEquals(5,min);
    }
    @Test
    public void testFindTopN() {
        int length = 20;
        int n = 5;
        int[] array = new int[length];
        Random random = new Random(5);
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt();
        }
        int[] expecteds = Arrays.copyOf(array, length);
        Arrays.sort(expecteds);
        int[] result = FindTopN.findTopN(array, n);
        Arrays.sort(result);
        for (int i = length - n; i < length; i++) {
            assertEquals( expecteds[i],result[i - (length - n)]);
        }

    }

}
