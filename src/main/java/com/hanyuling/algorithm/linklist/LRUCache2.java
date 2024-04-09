package com.hanyuling.algorithm.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wrg
 * @date: 2024/4/1 15:09
 */
public class LRUCache2 {


    Map<Integer, DListNode> cache;
    DListNode head,tail;

    int capacity;

    int size;

    public LRUCache2(int capacity) {
        cache = new HashMap<>();
        head = new DListNode(0, 0);
        tail = new DListNode(0, 0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        DListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DListNode node = cache.get(key);
        if (node == null) {
            node = new DListNode(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
        } else {
            node.val = value;
            moveToHead(node);
        }
        if (size > capacity) {
            DListNode tail = removeTail();
            cache.remove(tail.key);
            size--;
        }
    }

    private DListNode removeTail() {
        DListNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void moveToHead(DListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DListNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }


    class DListNode {
        int key;
        int val;

        DListNode next;
        DListNode prev;

        public DListNode(int k, int v) {
            key = k;
            val = v;
        }
    }
}
