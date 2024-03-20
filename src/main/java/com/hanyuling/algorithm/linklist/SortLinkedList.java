package com.hanyuling.algorithm.linklist;

public class SortLinkedList {


    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, null)))));
        ListNode listNode = sortLinkedList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * @param head
     * @return
     */
    public static ListNode sortLinkedList(ListNode head) {
       return sortList(head, null);
    }

    private static ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode res1 = sortList(head, mid);
        ListNode res2 = sortList(mid, tail);
        return merge(res1, res2);
    }

    private static ListNode merge(ListNode res1, ListNode res2) {
        ListNode newhead = new ListNode();
        ListNode index = newhead;
        ListNode tmp1 = res1;
        ListNode tmp2 = res2;

        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val <= tmp2.val) {
                index.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                index.next = tmp2;
                tmp2 = tmp2.next;
            }
            index = index.next;
        }

        if (tmp1 != null) {
            index.next = tmp1;
        }else if (tmp2 != null) {
            index.next = tmp2;
        }

        return newhead.next;
    }


    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength & curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode sortList3(ListNode head) {

        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode pre = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                pre.next = merged;
                while (pre.next != null) {
                    pre = pre.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode sortLinkedList4(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode pre = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                pre.next = merged;
                while (pre.next != null) {
                    pre = pre.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

}






























