package edu.whu.swe.lxl.learn.jd;

import java.util.Scanner;
import java.util.Stack;

public class Main3_jd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.valueOf(in.nextLine());
        String[] strs = new String[count];
        for (int i = 0; i < count; i++) {
            strs[i] = in.nextLine();
        }
        for (String str : strs) {
            if(str.length()<2){
                System.out.println("No");
                break;
            }
            if (resolve(str.toCharArray()))
                System.out.println("Yes");
            else
                System.out.println("No");

        }

    }

    public static boolean resolve(char[] str) {
        Stack<Boolean> s = new Stack<>();

        for (char c : str) {
            boolean flag = c == '(';
            if (s.isEmpty())
                s.push(flag);
            else if (s.peek() && !flag)
                s.pop();
            else
                s.push(flag);
        }
        if (s.isEmpty())
            return true;
        else if (s.size() != 2)
            return false;
        else {
            boolean a = s.pop();
            boolean b = s.pop();
            return a != b;
        }
    }
}
