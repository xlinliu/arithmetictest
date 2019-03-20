package edu.whu.swe.lxl.learn.queue;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackImplementByQueue<T> {
    private final Queue<T> queue1 = new LinkedList<>();
    private final Queue<T> queue2 = new LinkedList<>();

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty() ? true : false;
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        } else {
            while (queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        }
    }
    public void push(T e){
        if(queue1.isEmpty())
            queue2.add(e);
        else
            queue1.add(e);
    }
}
