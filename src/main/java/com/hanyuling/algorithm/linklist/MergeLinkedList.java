package com.hanyuling.algorithm.linklist;


public class MergeLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode = mergeTwoLists(l1, l2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }
    public static void test(){
        var a = 1;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode index1 = l1;
        ListNode index2 = l2;
        ListNode newHead = new ListNode();
        ListNode index = newHead;
        ListNode tmp;
        while (index1 != null && index2 != null) {
            if (index1.val < index2.val) {
                tmp = index1;
                index1 = index1.next;
            } else {
                tmp = index2;
                index2 = index2.next;
            }
            index.next = tmp;
            index = index.next;
        }

        if (index1 != null) {
            index.next = index1;
        }
        if (index2 != null) {
            index.next = index2;
        }

        return newHead.next;
    }
}
