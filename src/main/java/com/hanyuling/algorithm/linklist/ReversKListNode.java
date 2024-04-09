package com.hanyuling.algorithm.linklist;

import com.hanyuling.algorithm.linklist.ListNode;

/**
 * @author: wrg
 * @date: 2024/3/27 15:25
 */
public class ReversKListNode {
    //单链表 每k个节点逆序
    // 结尾不满足k个节点 不逆序 返回新的列表
    // 12345678 32165478 3 O(n) 空间复杂度

    public static ListNode reversk(ListNode head, int k) {
        ListNode hair = new ListNode(0, head);
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] listNodes = myReverse(head, tail);
            head = listNodes[0];
            tail = listNodes[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    private static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;
        }
        return new ListNode[]{tail, head};
    }


    public static ListNode reversk2(ListNode head, int k) {
        ListNode hair = new ListNode(0, head);
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }

            ListNode nex = tail.next;
            ListNode[] listNodes = myReverse2(head, tail);
            head = listNodes[0];
            tail = listNodes[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    private static ListNode[] myReverse2(ListNode head, ListNode tail) {
        ListNode p = head, prev = tail.next;
        while (prev != tail) {
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;
        }
        return new ListNode[]{tail, head};
    }
}
