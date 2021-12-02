package com.hanyuling.algorithm.linklist;

public class FlipsList {

    public static void main(String[] args) {
        LinkNode head = new LinkNode(1, new LinkNode(2, new LinkNode(3, new LinkNode(4, new LinkNode(5, null)))));
        LinkNode he = head;

        LinkNode newHead = new LinkNode(0,null);
        LinkNode flip = flip4(head,newHead);
        while (newHead != null) {
            System.out.println(newHead.value);
            newHead = newHead.next;
        }
    }

    public static LinkNode flip(LinkNode head) {
        LinkNode tmp = null;
        LinkNode result = new LinkNode(0, null);
        LinkNode curr = head;
        while (curr != null) {
            tmp = curr.next;
            curr.next = result.next;
            result.next = curr;
            curr = tmp;
        }
        return result.next;
    }

    public static LinkNode flip2(LinkNode head) {
        LinkNode prev = null;
        var curr = head;
        while (curr != null) {
            var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static LinkNode flip3(LinkNode head) {
        LinkNode cur = null;
        LinkNode next = head;
        LinkNode tmp = null;
        while (next != null) {
            tmp = next;
            next = next.next;
            tmp.next = cur;
            cur = tmp;
        }
        return cur;
    }

    public static LinkNode flip4(LinkNode node, LinkNode head) {
        if (node == null) {
            return head;
        }

        LinkNode tmp = flip4(node.next, head);
        tmp.next = node;
        node.next = null;
        return node;
    }

    static class LinkNode {
        int value;
        LinkNode next;

        public LinkNode(int value, LinkNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
