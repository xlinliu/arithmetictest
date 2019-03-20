package edu.whu.swe.lxl.learn.stack;

import java.util.*;

public class PostfixFormula {
    public static void main(String[] args) {
        String resultstr = convert("((15 / (7 - (1 + 1))) * 3) - (2 + (1 + 1))");
        double result = calculate(resultstr);
        System.out.println(result);
    }

    public static String convert(String expression) {
        StringBuilder postfixFormula = new StringBuilder();
        Stack<Character> s = new Stack<>();
        StringBuilder num = new StringBuilder();
        boolean afterOperator = false;
        for (char c : expression.toCharArray()) {
            if (c == ' ') continue;
            char top;
            if (c == '+' || c == '-') {
                afterOperator = true;
                while (!s.isEmpty() && (top = s.peek()) != '(') {
                    postfixFormula.append(' ');
                    postfixFormula.append(s.pop());
                }
                s.push(c);
            } else if (c == '*' || c == '/') {
                afterOperator = true;
                while (!s.isEmpty() && (top = s.peek()) != '(' && top != '+' && top != '-') {
                    postfixFormula.append(' ');
                    postfixFormula.append(s.pop());
                }
                s.push(c);

            } else if (c == ')') {
                afterOperator = true;
                while (s.peek() != '(') {
                    postfixFormula.append(' ');
                    postfixFormula.append(s.pop());
                }
                s.pop();
            } else if (c == '(') {
                afterOperator = true;
                s.push(c);
            } else if (c >= '0' && c <= '9') {
                if (afterOperator) {
                    postfixFormula.append(' ');
                    afterOperator = false;
                }
                postfixFormula.append(c);
            }
        }
        while (!s.isEmpty()) {
            postfixFormula.append(' ');
            postfixFormula.append(s.pop());
        }
        return postfixFormula.toString().trim();
    }

    public static double calculate(String postExpress) {
        String[] ops = postExpress.split(" ");
        Stack<Double> operands = new Stack<>();
        for (String op : ops) {
            char c = op.charAt(0);
            if (c == '+') {
                double result = operands.pop() + operands.pop();
                operands.push(result);
            } else if (c == '-') {
                double result = operands.pop() - operands.pop();
                operands.push(result);
            } else if (c == '*') {
                double result = operands.pop() * operands.pop();
                operands.push(result);
            } else if (c == '/') {
                double result = operands.pop() / operands.pop();
                operands.push(result);
            } else {
                double operand = Double.valueOf(op);
                operands.push(operand);
            }
        }
        return operands.pop();
    }
}
