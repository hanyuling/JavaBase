package com.hanyuling.algorithm.linklist;

import java.util.List;

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
     *
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
        } else if (tmp2 != null) {
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


    public ListNode sortList11(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        int n = 0;
        while (node != null) {
            n++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < n; subLength <<= 1) {
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

                ListNode merged = merge11(head1, head2);
                pre.next = merged;
                while (pre.next != null) {
                    pre = pre.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    private ListNode merge11(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0, null);
        ListNode tmp = dummyHead;
        ListNode tmp1 = head1;
        ListNode tmp2 = head2;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
                tmp = tmp.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
                tmp = tmp.next;
            }
        }
        if (tmp1 != null) {
            tmp.next = tmp1;
        }
        if (tmp2 != null) {
            tmp.next = tmp2;
        }
        return dummyHead.next;
    }

    public static ListNode sortLinkedList22(ListNode head) {
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
        for (int sublength = 1; sublength < length; sublength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < sublength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < sublength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merge = merge22(head1, head2);
                prev.next = merge;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    private static ListNode merge22(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0, null);
        ListNode pre = dummyHead;
        ListNode p1 = head1, p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                pre.next = p1;
                p1 = p1.next;
                pre = pre.next;
            } else {
                pre.next = p2;
                p2 = p2.next;
                pre = pre.next;
            }
        }
        if (p1 != null) {
            pre.next = p1;
        }
        if (p2 != null) {
            pre.next = p2;
        }
        return dummyHead.next;
    }


    public static ListNode sortLinkedList33(ListNode head) {
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
                ListNode merge = merge33(head1, head2);
                pre.next = merge;
                if (pre.next != null) {
                    pre = pre.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    private static ListNode merge33(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        ListNode p1 = head1, p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummyHead.next;
    }


}



























