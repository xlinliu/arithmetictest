package edu.whu.swe.lxl.learn.tencent;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        long[] result=new long[N];
        for(int i=0;i<N;i++){
            int n=in.nextInt();
            long[] a=new long[n];
            for(int j=0;j<n;j++){
                a[j]=in.nextInt();
            }
            result[i]=resolve(a);
        }
        for(long anser:result){
            System.out.println(anser);
        }


    }
    static long resolve(long[] a){
        int n=a.length-1;
        for(int i=1;i<=n;i++){
            long T=a[i]-a[0];
            if(isOk(a,T)) return T;
        }
        return a[n]-a[0];
    }

    static boolean isOk(long[] a, long T){
        int n=a.length-1;
        for(int i=1;i<=n-1;i++){
            int j=i+1;
            while(j<=n&&a[j]<=a[i]+T){
                if(a[j]==a[i]+T) break;
                j+=1;
            }
            if(j>n||a[j]>a[i]+T) return false;
        }
        return true;
    }
}
