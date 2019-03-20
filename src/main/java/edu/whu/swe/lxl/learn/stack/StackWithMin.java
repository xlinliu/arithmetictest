package edu.whu.swe.lxl.learn.stack;

import java.util.Scanner;
import java.util.Stack;

public class StackWithMin<T extends Comparable<T>> {
    public static void main(String[] args){
        StackWithMin s=new StackWithMin();
        Scanner in=new Scanner(System.in);
        while (in.hasNextInt()){
            s.push(in.nextInt());
            System.out.print(s.min());
        }
    }
    Stack<T> dataStack = new Stack<>();
    Stack<T> minStack = new Stack<>();

    public T pop() {
        minStack.pop();
        return dataStack.pop();
    }

    public void push(T e) {
        dataStack.push(e);
        if(minStack.isEmpty())
            minStack.push(e);
        T min = e.compareTo(minStack.peek()) < 0 ? e : minStack.peek();
        minStack.push(min);
    }
    public T min(){
        return minStack.peek();
    }
}
