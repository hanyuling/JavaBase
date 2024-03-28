package com.hanyuling.algorithm.dataStructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MinStack {
    Deque<Integer> min ;
    Deque<Integer> stack;


    public MinStack() {
        min = new ArrayDeque<>();
        stack = new ArrayDeque<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        min.push(Math.min(min.peek(), val));
    }

    public void pop() {
        min.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
