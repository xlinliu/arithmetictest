package edu.whu.swe.lxl.learn.test;

import edu.whu.swe.lxl.learn.ProductQueue;

public class ProductQueueTest {
    public static void main(String[] args){
        final ProductQueue<Integer> queue=new ProductQueue<Integer>(10);
        Thread in=new Thread(){
            @Override
            public void run() {
                for(Integer i=0;i<10;i++){
                    try {
                        queue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread in1=new Thread(){
            @Override
            public void run() {
                for(Integer i=100;i<110;i++){
                    try {
                        queue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread out=new Thread(){
            @Override
            public void run() {
                for(Integer i=0;i<20;i++){
                    try {
                        int a=queue.take();
                        System.out.print(a+"  ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        in1.start();
        in.start();

        out.start();


    }
}
