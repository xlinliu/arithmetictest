package edu.whu.swe.lxl.learn.test;

import edu.whu.swe.lxl.learn.SafeAccess;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SafeAccessTest {
    @Test
    public void testSafeAccess() {
        SafeAccess safeAccess = new SafeAccess(3, 1);


            try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
//                while (true) {
                    String str = in.readLine();
                    System.out.println(safeAccess.safeAccess());
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
