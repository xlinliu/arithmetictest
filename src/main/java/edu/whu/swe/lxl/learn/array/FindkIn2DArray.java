package edu.whu.swe.lxl.learn.array;

import java.util.Arrays;
import java.util.Random;

public class FindkIn2DArray {

    public static void main(String[] args) {
        Random random = new Random();
        int k_row = 10, k_col = 5;
        int k = 0;
        int row = 12, col = 9;
        Integer[][] array = new Integer[row][col];
        array[0][0] = -1500;
        for (int _row = 1; _row < row; _row++) {
            Integer num;
            for (num = random.nextInt(); num < array[_row - 1][0]; )
                num = random.nextInt();

            array[_row][0] = num;

        }
        for (int _col = 1; _col < col; _col++) {
            Integer num;
            for (num = random.nextInt(); num < array[0][_col - 1]; )
                num = random.nextInt();

            array[0][_col] = num;

        }

        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++) {
                Integer num;
                for (num = random.nextInt(); num < array[i - 1][j] || num < array[i][j - 1]; )
                    num = random.nextInt();
                array[i][j] = num;
                if (i == k_row && j == k_col)
                    k = num;

            }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.printf("%d   ,", array[i][j]);
            System.out.print("\n");
        }

//        Integer[][] array = {
//                {2984575, 2984576, 2026474041, 2140336100, 2145387658, 2145848257, 2145869343, 2146834806, 2147333630},
//                {1793791123, 2100013922, 2142893734, 2144494392, 2146411296, 2146928946, 2147353362, 2147379449, 2147446834},
//                {1925151341, 2118946603, 2143777302, 2145826443, 2146452931, 2147402369, 2147483545, 2147483556, 2147483608},
//                {1990702774, 2140036194, 2144838007, 2146371192, 2147133850, 2147467766, 2147483564, 2147483621, 2147483641},
//                {2133131877, 2145881499, 2147354872, 2147474757, 2147476030, 2147481504, 2147483577, 2147483632, 2147483645},
//                {2135556920, 2146373148, 2147436605, 2147480398, 2147481612, 2147482609, 2147483615, 2147483634, 2147483645},
//                {2144298650, 2146989861, 2147442286, 2147481559, 2147483320, 2147483490, 2147483624, 2147483635, 2147483645},
//                {2145757121, 2147299899, 2147468043, 2147482507, 2147483477, 2147483512, 2147483632, 2147483636, 2147483647},
//                {2146028866, 2147352221, 2147472830, 2147482587, 2147483624, 2147483641, 2147483646, 2147483646, 2147483647}};
        for (int i = 0; i < row; i++)
            for (int j = 1; j < col; j++)
                assert array[i][j] > array[i][j - 1];

        for (int i = 1; i < row; i++)
            for (int j = 0; j < col; j++)
                assert array[i][j] > array[i-1][j];
        k = array[k_row][k_col];
        Point point = findK(array, k);

        assert k_row == point.getRow() && k_col == point.getCol() : "wrong";

    }


    public static class Point {
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }

    public static <T extends Comparable<T>> Point findK(T[][] array, T k) {
        int  top = 0, right = array[0].length - 1;
        while (top<array.length&&right>0) {
            if(array[top][right].compareTo(k)==0)
                return new Point(top,right);

            else if(array[top][right].compareTo(k) < 0)
                ++top;
            else
                --right;



        }
        return new Point(top ,right);
    }
}
