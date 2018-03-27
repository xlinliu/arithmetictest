package edu.whu.swe.lxl.learn;

import java.util.Scanner;

public class GetMagic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String arg = in.nextLine();
        int n = Integer.valueOf(arg);

    }

    public static void getMaic(int n) {
        if (n == 1) {
            System.out.print(1);
            return;
        }
        if (n == 2) {
            System.out.print(2);
            return;
        }
        if (n % 2 == 0) {
            getMaic((n >> 1) - 1);
            System.out.print(2);
        } else {
            getMaic((n - 1) >> 1);
            System.out.print(1);
        }
    }
}
