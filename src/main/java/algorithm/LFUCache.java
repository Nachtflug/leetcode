package algorithm;

import java.util.HashMap;

public class LFUCache {

    private HashMap<Integer, Integer> cache;
    private int capacity, pos;
    private Node scores;
    private static class Node {
        public int key, score;
        public Node next;
        public Node(int key) {
            this.key = key;
            score = 1;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        pos = 0;

    }

    public int get(int key) {
        Integer ret = cache.get(key);
        if (ret == null) return -1;
        inc(key);
        return ret;
    }

    private void inc(int key) {
        if (scores == null) {
            scores = new Node(key);
        } else {
            Node p = scores, pre = null;
            while (p != null && p.key != key) {
                pre = p;
                p = p.next;
            }
            p.score ++;
            if (pre != null) {
                pre.next = p.next;
            } else {
                scores = p.next;
                pre = p;
            }
            while (pre.next != null && pre.next.score <= p.score) {
                pre = pre.next;
            }
            insertAfter(p, pre);
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        int cur = get(key);
        if (cur == -1) {
            if (pos >= capacity)
                evict();
            else
                pos ++;
            newNode(key);
        }
        cache.put(key, value);
    }

    private void newNode(int key) {
        Node newNode = new Node(key);
        if (scores == null) {
            this.scores = newNode;
        } else {
            if (scores.score > 1) {
                newNode.next = scores;
                scores = newNode;
                return;
            }
            Node p = scores;
            while (p.next != null && p.next.score <= 1) {
                p = p.next;
            }
            insertAfter(newNode, p);
        }
    }

    private void insertAfter(Node newNode, Node p) {
        if (p == newNode)
            scores = p;
        Node next = p.next;
        p.next = newNode;
        newNode.next = next;
    }

    private void evict() {
        cache.remove(scores.key);
        scores = scores.next;
    }

}
