package edu.whu.swe.lxl.learn;

import java.util.Arrays;

public class Combination<T> {
    public static void main(String[] args) throws Exception {
        Integer[] array = {1, 8, 6, 3};
        Combination<Integer> combination = new Combination<>(array, 0);
        while (combination.hashNext()) {
            System.out.println(Arrays.toString(combination.next()));
        }
    }

    private boolean[] flas;
    private T[] array;
    private int n;
    private boolean isFirst = true;

    public Combination(T[] array, int n) throws Exception {
        this.flas = new boolean[array.length];
        this.array = array;
        this.n = n;
        if (n > array.length || n < 0)
            throw new Exception("n must not be between 0 and the length of array");
    }

    public boolean hashNext() {
        if (isFirst) {
            Arrays.fill(flas, 0, n, true);
            Arrays.fill(flas, n, array.length, false);
            isFirst = false;
            return true;
        }
        int i = 0;
        while (i < array.length - 1) {
            if (flas[i] && !flas[i + 1]) {
                flas[i] = false;
                flas[i + 1] = true;
                break;
            }
            ++i;
        }
        if (i == array.length - 1)
            return false;
        int zeroNum = 0;
        for (int j = 0; j < i; j++) {
            if (flas[j])
                break;
            ++zeroNum;
        }
        if (zeroNum > 0) {
            Arrays.fill(flas, 0, i - zeroNum, true);
            Arrays.fill(flas, i - zeroNum, i, false);
        }
        return true;
    }

    public T[] next() {
        Object[] resultArray = new Object[n];
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (flas[j]) {
                resultArray[i++] = array[j];
            }
        }
        return (T[]) resultArray;
    }
}
