package com.hanyuling.algorithm.linklist;

public class FlipsList {

    public static void main(String[] args) {
        LinkNode head = new LinkNode(1, new LinkNode(2, new LinkNode(3, new LinkNode(4, new LinkNode(5, null)))));

        LinkNode flip = flip5(head);
        while (flip != null) {
            System.out.println(flip.value);
            flip = flip.next;
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

    public static LinkNode flip5(LinkNode head) {
        LinkNode newHead = null;
        LinkNode tmp = null;
        while (head != null) {
            tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
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
