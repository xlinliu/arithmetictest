package edu.whu.swe.lxl.learn;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int count = 0;
        for (int x = k; x <= n-1; x++) {
            for (int y = k+1 ; y <= n;y++ ) {
                if(x>y)
                    break;
                    count++;

            }
        }
        for(int y=k+1;y<=n-k;y++)
        {
            for(int x=y+k;x<=n;x++)
                count++;
        }


        System.out.print(count);


    }

}