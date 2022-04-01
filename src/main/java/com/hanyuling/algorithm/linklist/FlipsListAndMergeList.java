package com.hanyuling.algorithm.linklist;

import java.util.List;

public class FlipsListAndMergeList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(10, new ListNode(2, new ListNode(9,
                new ListNode(3, new ListNode(8, new ListNode(4, new ListNode(7,
                        new ListNode(5, new ListNode(6, new ListNode(6)))))))))));
        getList(head);
    }

    public static ListNode getList(ListNode head) {
        ListNode up = head;
        ListNode down = head.next;
        splitList(up, down);
        down = flipsList(down);
        ListNode list = merge(up, down);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
        return null;
    }

    private static ListNode merge(ListNode up, ListNode down) {
        ListNode node = new ListNode();
        ListNode tmp = node;
        ListNode upTmp = up;
        ListNode downTmp = down;
        while (upTmp != null && downTmp != null) {
            if (upTmp.val < downTmp.val) {
                tmp.next = upTmp;
                upTmp = upTmp.next;
            } else {
                tmp.next = downTmp;
                downTmp = downTmp.next;
            }
            tmp = tmp.next;
        }
        if (upTmp != null ) {
            tmp.next = upTmp;
        }
        if (downTmp != null) {
            tmp.next = downTmp;
        }
        return node.next;
    }

    private static ListNode flipsList(ListNode down) {
        ListNode head = down;
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    private static void splitList(ListNode up, ListNode down) {
        ListNode upTmp = up;
        ListNode downTmp = down;
        while (upTmp.next != null && downTmp.next != null) {
            upTmp.next = downTmp.next;
            upTmp = upTmp.next;
            downTmp.next = upTmp.next;
            downTmp = downTmp.next;
        }
        if (upTmp != null && upTmp.next != null) {
            upTmp.next = null;
        }
        if (downTmp != null && downTmp.next != null) {
            downTmp.next = null;
        }
    }
}
