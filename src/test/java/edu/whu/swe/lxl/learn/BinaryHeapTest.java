package edu.whu.swe.lxl.learn;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BinaryHeapTest {
    private int count = 10000;
    private Random random = new Random();
    BinaryHeap<Integer> heap = new BinaryHeap<>();

    @Test
    public void insert() {

        for (int i = 0; i < count; i++) {
            heap.insert(random.nextInt());
        }
    }

    @Test
    public void findMin() {

        insert();
        int i = Integer.MIN_VALUE, j;
        while (true) {

            try {
                j = heap.deleteMin();
                assert i <= j : "wrong";
                i = j;
            }catch (Exception e){
                break;
            }
        }

    }

    @Test
    public void findMinWhenEmpty() {

        BinaryHeap<Integer> heap = new BinaryHeap<>();
        int i = Integer.MIN_VALUE, j;
        while (true) {
            try {
                j = heap.deleteMin();
                assert i <= j : "wrong";
                i = j;

            }catch (Exception e){
                break;
            }
        }

    }

    @Test
    public void deleteMin() {
        try {
            heap.deleteMin();
            assert false:"delete empty";
        }catch (Exception e){

        }
        heap.insert(1);
        try {
            heap.deleteMin();
        }catch (Exception e){
            assert false:"heap is not empty,but delete failed";
        }
        try {
            heap.deleteMin();
            assert false:"delete empty";
        }catch (Exception e){

        }

    }

    @Test
    public void isEmpty() throws Exception{
        assert heap.isEmpty();
        heap.insert(2);
        assert !heap.isEmpty();
        heap.deleteMin();
        assert heap.isEmpty();
        insert();
        assert !heap.isEmpty();
        findMin();
        assert heap.isEmpty();
    }
    @Test
    public void testConstruct() throws Exception{
        int count = 1115;
        Random random = new Random();

        Integer[] array = new Integer[count];
        for(int i=0;i<count;i++){
            array[i]=random.nextInt();
        }
        BinaryHeap<Integer> heap = new BinaryHeap<>(array);
        int i = Integer.MIN_VALUE, j;
        int firstDelete=0;
        while (!heap.isEmpty()&&firstDelete<count/3) {
            j = heap.findMin();
            assert i <= j : "wrong";
            i = j;
            heap.deleteMin();
            firstDelete++;
        }
        for (int e = 0; e < count/3; e++) {
            heap.insert(random.nextInt());
        }
        i = Integer.MIN_VALUE;
        while (!heap.isEmpty()) {
            j = heap.findMin();
            assert i <= j : "wrong";
            i = j;
            heap.deleteMin();
        }
    }

}