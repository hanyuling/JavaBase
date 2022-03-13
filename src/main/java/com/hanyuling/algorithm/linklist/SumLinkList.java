package com.hanyuling.algorithm.linklist;

public class SumLinkList {

    public static void main(String[] args) {
        ListNode n = new ListNode(1, new ListNode(9, new ListNode(4, new ListNode(5, new ListNode(3, new ListNode(3, null))))));
        ListNode m = new ListNode(1, new ListNode(9, new ListNode(5, new ListNode(4, new ListNode(8, new ListNode(3, null))))));
        ListNode sum = sum(n, m);
        while (sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }
    }

    public static ListNode sum(ListNode n, ListNode m) {
        if (n == null || m == null) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode next = head;
        ListNode tmp = head;
        while (n != null) {
            int sum = n.val + m.val;
            if (sum > 10) {
                while (tmp != next) {
                    tmp.val = (tmp.val + 1) % 10;
                    tmp = tmp.next;
                }
            }
            next.val = sum % 10;
            n = n.next;
            m = m.next;
            next.next = new ListNode();
            if (sum != 9) {
                tmp = next;
            }
            next = next.next;
        }
        while (tmp.next != next) {
            tmp = tmp.next;
        }
        tmp.next = null;
        return head;
    }
}
