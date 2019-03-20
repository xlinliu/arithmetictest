package edu.whu.swe.lxl.learn.string;

import java.util.Scanner;

public class DuplicationString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (judge(str, 0, i)) {
                System.out.print(str.substring(0, i + 1));
                return;
            }
        }
        System.out.print(false);

    }

    public static boolean judge(String str, int left, int right) {
        if(str.length()==right - left + 1)
            return false;
        if (str.length() % (right - left + 1) != 0)
            return false;
        for (int i = right - left + 1; i < str.length(); i += right - left + 1) {
            for (int j = 0; j < right - left + 1; j++) {
                if (str.charAt(j) != str.charAt(j + i))
                    return false;

            }
        }
        return true;

    }


}
