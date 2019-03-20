package edu.whu.swe.lxl.learn;

import java.util.Arrays;
import java.util.Scanner;

public class PrintToMaxOfNDigit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        print_iterate(n);
    }
    public static void print_iterate(int n) {
        char[] num = new char[n];
        Arrays.fill(num, '0');
        num[n - 1] = '1';
        while (num[0] <= '9') {
            boolean isBeginZero = true;
            for (char digit : num) {
                if (isBeginZero && digit != '0')
                    isBeginZero = false;
                if (!isBeginZero)
                    System.out.print(digit);
            }
            increment(num);
            if(num[0] <= '9')
                System.out.print('、');

        }

    }

    private static void increment(char[] num) {
        int length = num.length;
        num[length - 1] += 1;
        for (int i = length - 1; i > 0; i--) {
            if (num[i] > '9') {
                num[i - 1] += 1;
                num[i] = '0';
            } else {
                break;
            }
        }
    }
}
