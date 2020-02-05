package com.interviewbit.heapandmap.maps;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> map;
    Node start;
    Node end;
    int capacity;

    public LRUCache(final int capacity) {
        this.map = new HashMap<>();
        this.start = new Node(0, 0);
        this.end = new Node(0, 0);
        this.capacity = capacity;
        this.start.next = this.end;
        this.end.prev = this.start;
    }

    public int get(final int key) {
        if (this.map.containsKey(key)) {
            final Node node = this.map.get(key);
            this.removeNode(node);
            this.addNode(node);
            return node.val;
        }
        return -1;
    }

    private void addNode(final Node node) {
        node.next = this.start.next;
        this.start.next = node;
        node.prev = this.start;
        node.next.prev = node;
    }

    private void removeNode(final Node node) {
        final Node temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;
    }

    public void set(final int key, final int value) {
        final Node node = new Node(key, value);

        if (this.map.containsKey(key)) {
            final Node temp = this.map.get(key);
            this.removeNode(temp);
            this.addNode(node);
        } else {
            if (this.capacity == this.map.size()) {
                final Node temp = this.end.prev;
                this.removeNode(temp);
                this.map.remove(temp.key);
            }

            this.addNode(node);
        }

        this.map.put(key, node);
    }
}
