package edu.whu.swe.lxl.learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

public class SafeAccess {
    public static void main(String[] args) {
        SafeAccess safeAccess = new SafeAccess(5, 1);


        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int count = 0;
            while (true) {
                Thread.sleep(count<10?180:200);
//            String str = in.readLine();
                System.out.println(safeAccess.safeAccess());
                ++count;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SafeAccess(int accessCount, int sampleTime) {
        this.accessCount = accessCount;
        this.sampleTime = sampleTime * 1000;
    }

    int accessCount;
    int sampleTime;
    static Queue<Long> accessList = new LinkedList<>();

    public String safeAccess() {
        long currentTime = System.currentTimeMillis();
        if (accessList.size() < accessCount) {
            //调用access
            accessList.add(currentTime);
            return "Success";
        }
        long oldes = accessList.poll();
        accessList.add(currentTime);
        if ((currentTime - oldes) < sampleTime)
            return "Access denied";
        else
            //access
            return "Success";
    }
}
