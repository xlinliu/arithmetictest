package edu.whu.swe.lxl.learn.array;

public class Print2DArrayInCircle {

    public static void main(String[] args) {
        int m = 0, n = 0;
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                array[i][j] = n * i + j + 1;
        print2DArrayInCircle(array);
    }

    public static void print2DArrayInCircle(int[][] array) {

        int top = 0, buttom = array.length - 1, left = 0;
        if(buttom<0)
            return;
        int right = array[0].length - 1;
        boolean first = true;
        while (true) {
            if(right<left)
                return;
            for (int i = left; i <= right; i++) {
                if (first) {
                    System.out.print( array[top][i]);
                    first = false;
                } else
                    System.out.print("," + array[top][i]);
            }
            top += 1;
            if(buttom<top)
                return;
            for (int i = top; i <= buttom; i++)
                System.out.print("," +array[i][right]);
            right -= 1;
            if(right<left)
                return;
            for (int i = right; i >= left; i--)
                System.out.print("," +array[buttom][i]);
            buttom -= 1;
            if(buttom<top)
                return;
            for (int i = buttom; i >= top; i--)
                System.out.print("," +array[i][left]);
            left += 1;

        }
    }
}
