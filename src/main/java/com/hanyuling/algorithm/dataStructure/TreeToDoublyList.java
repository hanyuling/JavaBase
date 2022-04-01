package com.hanyuling.algorithm.dataStructure;


import org.w3c.dom.Node;

public class TreeToDoublyList {

    public static void main(String[] args) {
        TreeToDoublyList list = new TreeToDoublyList();
        Node root = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
        Node head = list.treeToDoublyList(root);
        Node node = head;
        boolean flag = true;
        while (node != null && (node != head || flag)) {
            System.out.println(node.val);
            node = node.right;
            flag = false;
        }
    }


    Node head = null;
    Node pre = null;

    public Node treeToDoublyList(Node root) {
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
