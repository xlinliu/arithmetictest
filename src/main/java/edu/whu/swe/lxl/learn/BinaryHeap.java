package edu.whu.swe.lxl.learn;

import sun.invoke.empty.Empty;

public class BinaryHeap<T extends Comparable<? super T>> {
    public static void main(String[] args)throws Exception {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.insert(-1777164405);
        heap.insert(-979422830);
        heap.insert(-449276958);
        heap.insert(1188480257);
        heap.insert(639424961);
        while (!heap.isEmpty()) {
            System.out.println(heap.findMin());
            heap.deleteMin();
        }
    }

    private Object[] array;
    private final int defualtSize;
    private int currentSize;


    public BinaryHeap() {
        this(15);
    }

    public BinaryHeap(int capacity) {
        defualtSize = capacity;
        array = new Object[capacity];
        currentSize = 0;
    }

    public BinaryHeap(T[] items) {
        array = items;
        currentSize = items.length;
        defualtSize = 15;
        buildHeap();
    }

    public void insert(T x) {
        if (currentSize + 1 > array.length)
            reSize();
        array[currentSize++] = x;
        putUp(currentSize - 1);
    }

    public T findMin() throws Exception {
        if(isEmpty())
            throw new Exception("attempt to find Empty heap");
        return (T) array[0];
    }

    public T deleteMin()throws Exception {

        if (isEmpty()) {
            throw new Exception("attempt to delete an empty heap");
        }
        T minElement=findMin();
        array[0] = array[currentSize - 1];
        --currentSize;
        putDown(0);
        if (currentSize > defualtSize && currentSize << 1 < array.length) {
            Object[] newArray = new Object[currentSize];
            System.arraycopy(array, 0, newArray, 0, currentSize);
            array = newArray;
        }
        return minElement;
    }

    public boolean isEmpty() {
        return currentSize > 0 ? false : true;
    }

    private void putDown(int i) {
        int left = (i << 1) + 1;
        int right = (i << 1) + 2;
        if (left > currentSize - 1)
            return;
        else {
            if (right > currentSize - 1) {//左子树非空，右子树空，由于是完全二叉树，所以可以判断该左子树只有一个节点
                if (((T) array[i]).compareTo((T) array[left]) > 0)//如果节点大余左节点，则互换
                    swap(i, left);
                return;
            }
            if (((T) array[left]).compareTo((T) array[right]) < 0) {
                if (((T) array[i]).compareTo((T) array[left]) > 0) {
                    swap(i, left);
                    putDown(left);
                }
            } else {
                if (((T) array[i]).compareTo((T) array[right]) > 0) {
                    swap(i, right);
                    putDown(right);
                }
            }
        }
    }

    private void putUp(int i) {
        int parents = (i - 1) >> 1;
        if (parents >= 0 && ((T) array[parents]).compareTo((T) array[i]) > 0) {
            swap(parents, i);
            putUp(parents);
        }

    }

    private void buildHeap() {
        for (int i = (currentSize - 1)>>1; i >= 0; i--) {
            putDown(i);
        }
    }

    private void reSize() {
        Object[] newArray = new Object[currentSize << 1];
        System.arraycopy(array, 0, newArray, 0, currentSize);
        array = newArray;
    }

    private void swap(int i, int j) {
        T temp = (T) array[i];
        array[i] = array[j];
        array[j] = temp;

    }

}
