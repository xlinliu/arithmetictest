package edu.whu.swe.lxl.learn;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Point o) {
            if(x<o.x)
            return -1;
            else if(x==o.x)
                return 0;
            else
                return 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        boolean[] isOK = new boolean[count];

        for (int i = 0; i < count; i++) {
            int x1 = in.nextInt();
            int x2 = in.nextInt();
            int x3 = in.nextInt();
            int x4 = in.nextInt();
            int y1 = in.nextInt();
            int y2 = in.nextInt();
            int y3 = in.nextInt();
            int y4 = in.nextInt();

            Point[] points = {new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), new Point(x4, y4)};
            int a, b;
            Arrays.sort(points,Point::compareTo);
            if(points[0].y==points[2].y){
                if(((points[0].x-points[3].x)*(points[1].x-points[2].x)+(points[0].y-points[3].y)*(points[1].y-points[2].y)==0)&&
                        (points[0].x-points[3].x)*(points[0].x-points[3].x)+(points[0].y-points[3].y)*(points[0].y-points[3].y)
                                -(points[1].y-points[2].y)*(points[1].y-points[2].y)-(points[1].x-points[2].x)*(points[1].x-points[2].x)==0  )
                    isOK[i]=true;
                else
                    isOK[i]=false;
            }else {
                if(((points[0].x-points[2].x)*(points[1].x-points[3].x)+(points[0].y-points[2].y)*(points[1].y-points[3].y)==0)&&
                        (points[0].x-points[2].x)*(points[0].x-points[2].x)+(points[0].y-points[2].y)*(points[0].y-points[2].y)-
                                (points[1].y-points[3].y)*(points[1].y-points[3].y)-(points[1].x-points[3].x)*(points[1].x-points[3].x)==0  )
                    isOK[i]=true;
                else
                    isOK[i]=false;
            }

        }
        for(boolean ok: isOK){
            if(ok)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

}