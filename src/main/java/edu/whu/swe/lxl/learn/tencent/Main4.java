package edu.whu.swe.lxl.learn.tencent;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inData = in.nextLine();
        String[] dataStrs = inData.split(",");
        int sum = 0;
        int max = 0;
        int maxNUm=Integer.MIN_VALUE;
        for (int i = 0; i < dataStrs.length; i++) {
            int data = Integer.parseInt(dataStrs[i].trim());
            if(data>maxNUm)
                maxNUm=data;
            sum += data;
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        if(maxNUm<=0)
            System.out.print(maxNUm);
        else
        System.out.print(max);

    }
}
