package com.hanyuling.algorithm.linklist;

public class Linked2Stack {

    private Node HEAD = new Node(0,null);
    private Node top;


    public boolean push(int value){
        if (HEAD == null) {
            HEAD = new Node(0, null);
        }
        Node node = new Node(value, null);
        Node tmp = HEAD.next;
        HEAD.next = node;
        node.next = tmp;
        top = node;
        return true;
    }

    public Node pop() {
        Node tmp = top;
        HEAD.next = top.next;
        top = HEAD.next;
        return tmp;
    }



    class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
