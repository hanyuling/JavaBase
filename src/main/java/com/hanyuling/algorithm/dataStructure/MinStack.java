package com.hanyuling.algorithm.dataStructure;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack();
        min = new Stack();
    }

    public void push(int val) {
        stack.push(val);
        min.push(min.isEmpty() ? 0 : Math.min(min.peek(), val));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
