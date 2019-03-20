package edu.whu.swe.lxl.learn.stack;

import java.util.Stack;

public class IsPopOrder {
    public static void main(String[] args) {
        boolean isPopOrder = isPopOrder(new Integer[]{1/*1, 2, 3, 4, 5*/}, new Integer[]{1/*4, 3, 5, 1, 2*/});
        assert isPopOrder;
    }

    public static <T> boolean isPopOrder(T[] pushOrder, T[] popOrder) {
        Stack<T> stack = new Stack<>();
        int i_push = 0;
        int i = 0;
        for (; i < popOrder.length; i++) {
            T popElement = popOrder[i];
            if (!stack.isEmpty() && stack.peek() == popElement)
                stack.pop();
            else {
                while (i_push < pushOrder.length) {
                    if (pushOrder[i_push] != popElement) {
                        stack.push(pushOrder[i_push]);
                        ++i_push;
                    } else {
                        ++i_push;
                        break;
                    }
                }
            }
        }
        if (stack.isEmpty() && i == popOrder.length && i_push == pushOrder.length)
            return true;
        else
            return false;

    }

    public static <T> boolean isPopOrder2(T[] pushOrder, T[] popOrder) {
        if(pushOrder.length!=popOrder.length)
            return false;
        Stack<T> stack = new Stack<>();
        int i_pop = 0, i_push = 0;
        while (true) {
            if (i_pop == popOrder.length && i_push == pushOrder.length && stack.isEmpty())
                return true;
            if (i_push == popOrder.length && i_pop != popOrder.length && stack.peek() != popOrder[i_pop])
                return false;
            T popE = popOrder[i_pop];

            if (!stack.isEmpty() && stack.peek() == popE) {
                while (!stack.isEmpty() && stack.peek() == popE) {
                    stack.pop();
                    ++i_pop;
                }
            } else {
                T pushE = pushOrder[i_push];
                stack.push(pushE);
                ++i_push;
            }

        }

    }
}
