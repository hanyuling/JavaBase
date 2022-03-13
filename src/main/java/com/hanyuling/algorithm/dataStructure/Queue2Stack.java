package com.hanyuling.algorithm.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Queue2Stack {
    Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) {
        Queue2Stack stack = new Queue2Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public Queue2Stack() {

    }

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return  queue.poll();
    }

    public int top() {
        return  queue.peek();
    }

    public boolean empty() {
        return  queue.isEmpty();
    }
}
