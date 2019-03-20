package edu.whu.swe.lxl.learn.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2_jd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        long _2 = 2;
        long _1 = 1;
        List<Long> ns=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ns.add(in.nextLong());
        }
        for(long n:ns){
            resolve(n);
        }
    }

    public static void resolve(long _n) {
        long n=_n;
        long y ;
        for (; (n&1)==0; n/= 2) {
        }
        if(n==_n)
        System.out.println("No");
        else
            System.out.println(n+" "+_n/n);
    }

}
