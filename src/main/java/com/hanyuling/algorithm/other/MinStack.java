package com.hanyuling.algorithm.other;

public class MinStack {
    ListNode top;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int val) {
        ListNode ntop;
        if (top != null) {
            ntop = new ListNode(val, val, top);
        } else {
            ntop = new ListNode(val, Math.min(val, top.min), top);
        }
        top = ntop;
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        ListNode pop = top;
        top = top.next;
        return pop.val;
    }

    public int getMin() {
        if (top != null) {
            return top.min;
        }
        return 0;
    }

    class ListNode {
        public int val;
        public int min;//最小值
        public ListNode next;

        public ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }


}


