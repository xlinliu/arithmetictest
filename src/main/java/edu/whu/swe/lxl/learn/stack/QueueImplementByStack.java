package edu.whu.swe.lxl.learn.stack;

import edu.whu.swe.lxl.learn.queue.StackImplementByQueue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueImplementByStack<T> {
    public static void main(String[] args) {
        int N = 10;
        QueueImplementByStack<Integer> queue = new QueueImplementByStack<>();
        for (int i = 0; i < N; i++) {
            queue.add(i);
        }
        for (int i = 0; i < N; i++) {
            System.out.print(queue.remove());
        }
    }

    private final StackImplementByQueue<T> in = new StackImplementByQueue<>();
    private final StackImplementByQueue<T> out = new StackImplementByQueue<>();

    public void add(T e) {
        in.push(e);
    }

    public T remove() {
        if (out.isEmpty()) {
            while (!in.isEmpty())
                out.push(in.pop());
        }
        if (out.isEmpty())
            throw new NoSuchElementException("Attempt to remove an empty queue");
        T e = out.pop();

        return e;
    }
}
