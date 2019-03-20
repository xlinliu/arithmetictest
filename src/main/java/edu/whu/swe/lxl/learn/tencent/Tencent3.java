package edu.whu.swe.lxl.learn.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tencent3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int machineCount = in.nextInt();
        int taskCount = in.nextInt();
        List<Machine> machines = new ArrayList<>(machineCount);
        List<Task> tasks = new ArrayList<>(taskCount);
        for (int i = 0; i < machineCount; i++) {
            int zi = in.nextInt();
            int wi = in.nextInt();
            machines.add(new Machine(zi, wi));
        }
        machines.sort(Machine::compareTo);
        boolean canBeDone=false;
        for (int i = 0; i < taskCount; i++) {

            int xi = in.nextInt();
            int yi = in.nextInt();
            tasks.add(new Task(xi,yi));
        }

        int income=0;
        for(Task t:tasks){
            if(machines.get(machineCount-1).wi>t.yi)
                canBeDone=true;
            income+=t.income;
        }
        if(canBeDone)
        System.out.print(taskCount+" "+income);
        else
            System.out.print(0+" "+0);

    }


    private static class Machine implements Comparable<Machine> {
        public int zi;
        public int wi;

        public Machine(int zi, int wi) {
            this.zi = zi;
            this.wi = wi;
        }

        @Override
        public int compareTo(Machine o) {
            if (o.wi < wi)
                return 1;
            if (wi < o.wi)
                return -1;
            else
                return 0;
        }
    }

    private static class Task {
        private int xi;
        private int yi;
        private int income;

        public Task(int xi, int yi) {
            this.xi = xi;
            this.yi = yi;
            this.income = 200 * xi + 3 * yi;
        }
    }
}


