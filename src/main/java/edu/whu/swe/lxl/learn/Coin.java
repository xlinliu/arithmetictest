package edu.whu.swe.lxl.learn;

public class Coin {
    public static void main(String[] args) {
        int n = 5;
        int count = function(n);
        System.out.print(count);
    }


    static int function(int n) {

        int i = 0;
        int j = 0;
        while (n != 0) {
            ++i;
            if ((n & 1) != 0)
                ++j;
            n = n >>> 1;
        }
        j-=1;
        return i - j;


    }

}
