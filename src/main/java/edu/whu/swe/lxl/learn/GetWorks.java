package edu.whu.swe.lxl.learn;

import java.util.Arrays;
import java.util.Scanner;

public class GetWorks {
    static class Work implements Comparable<Work> {
        int maney;
        int ability;

        public Work(int maney, int ability) {
            this.maney = maney;
            this.ability = ability;
        }

        public int getManey() {
            return maney;
        }

        public int getAbility() {
            return ability;
        }


        @Override
        public int compareTo(Work o) {
            if(maney>o.maney)
                return 1;
            else if(maney<o.maney)
                return -1;
            else
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        Work[] works=new Work[N];
        int[] pepole = new int[M];

        for(int i=0;i<N;i++){
            int ability=in.nextInt();
            int maney=in.nextInt();
            works[i] = new Work(maney, ability);
        }
        for(int i=0;i<M;i++){
            int a=in.nextInt();
            pepole[i]=a;
        }
        Arrays.sort(works,Work::compareTo);
        for(int i:pepole){
            int j=N-1;
            for(;j>=0;j--){
                if(works[j].getAbility()<=i)
                    break;
            }
            if(j>=0){
            System.out.println(works[j].getManey());}
            else {
                System.out.println(0);}

        }
        }
    }

