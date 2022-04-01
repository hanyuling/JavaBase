package com.hanyuling.algorithm.linklist;

import java.util.List;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        return mergeTowList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    private ListNode mergeTowList(ListNode l, ListNode r) {
        if (l == null || r == null) {
            return l != null ? l : r;
        }
        ListNode ltmp = l;
        ListNode rtmp = r;
        ListNode head = new ListNode();
        ListNode tail = head;
        while (ltmp != null && rtmp != null) {
            if (ltmp.val < rtmp.val) {
                tail.next = ltmp;
                ltmp = ltmp.next;
            }else {
                tail.next = rtmp;
                rtmp = rtmp.next;
            }
            tail = tail.next;
        }
        tail.next = (ltmp != null ? ltmp : rtmp);
        return head.next;
    }
}
