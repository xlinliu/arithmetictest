package edu.whu.swe.lxl.learn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductQueue<T> {
    private final Object[] buffer;
    private final Lock lock = new ReentrantLock(true);
    private final Condition notFull=lock.newCondition();
    private final Condition notEmpty=lock.newCondition();
    private volatile int in;
    private volatile int out;
    private volatile int size;

    public ProductQueue(int capacity) {
        buffer = new Object[capacity];
        out=-1;
        in=0;
    }

    public ProductQueue() {
        this(10);
    }

    public void put(T e) throws InterruptedException {
        lock.lock();
        try {
            while (out==in){
                notFull.await();
            }
            buffer[in]=e;
            if(++in==buffer.length)
                in=0;
            if(out==-1)
                out++;
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }


    }
    public T take() throws InterruptedException{
        lock.lock();
        try {
            while (out == -1) {
                notEmpty.await();
            }
            T e = (T) buffer[out];
            if(++out==buffer.length)
                out=0;
            if (getSize() == 0) {
                out = -1;
                in=0;
            }
            notFull.signalAll();
            return e;
        }finally {
            lock.unlock();
        }

    }

    private int getSize() {
        return (in+buffer.length-out)%buffer.length;
    }

    public int Size(){
        return getSize();
    }

}

