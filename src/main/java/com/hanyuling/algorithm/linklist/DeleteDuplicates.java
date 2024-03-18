package com.hanyuling.algorithm.linklist;

public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(4, new ListNode(1, new ListNode(1, new ListNode(5, null)))));
        ListNode listNode = deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;

        }

    }

    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     * leecode 82
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }
}
