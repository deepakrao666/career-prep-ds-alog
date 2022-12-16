package com.deepak.leetCode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class CustomNode {
        int key;
        int value;
        CustomNode prev;
        CustomNode next;
    }

    private int count;
    private final int capacity;
    private final CustomNode head;
    private final CustomNode tail;

    private final Map<Integer, CustomNode> cache = new HashMap<>();


    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        this.head = new CustomNode();
        this.tail = new CustomNode();


        this.head.prev = null;
        this.head.next = tail;

        this.tail.next = null;
        this.tail.prev = head;

    }

    public int get(int key) {
        final CustomNode customNode = cache.get(key);

        if (customNode == null) {
            return -1;
        } else {
            this.moveToHead(customNode);
        }
        return customNode.value;
    }


    public void put(int key, int value) {
        CustomNode customNode = cache.get(key);

        if (customNode == null) {
            customNode = new CustomNode();
            customNode.key = key;
            customNode.value = value;

            this.cache.put(key, customNode);
            this.addNode(customNode);

            count++;

            if (count > capacity) {
                CustomNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }

        } else {
            customNode.value = value;
            this.moveToHead(customNode);
        }
    }

    private void moveToHead(CustomNode customNode) {
        this.removeNode(customNode);
        this.addNode(customNode);
    }

    private void addNode(CustomNode customNode) {
        customNode.prev = head;
        customNode.next = head.next;

        head.next.prev = customNode;
        head.next = customNode;
    }

    private void removeNode(CustomNode customNode) {
        CustomNode prev = customNode.prev;
        CustomNode next = customNode.next;

        prev.next = next;
        next.prev = prev;

    }

    private CustomNode popTail() {
        CustomNode prev = tail.prev;
        this.removeNode(prev);
        return prev;
    }
}
