package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-04-24
 */

class LRUCacheTest {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        System.out.println(cache.get(13)); // 2
        cache.put(2, 19); // 2:2 , 1:1
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(5, 25); // 1:1, 4:1
        System.out.println(cache.get(8));
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        System.out.println(cache.get(11)); // -1
        cache.put(9, 12);
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));

        //Line 2
        //System.out.println(cache.get(3));
        //System.out.println(cache.get(4));
    }
}

public class LRUCache {

    private int capacity;
    private Node head, tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        int val = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            val = node.val;

            if (node.next == null) {
                return val;
            }

            if (node.prev == null) {
                head = head.next;
                head.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            tail.next = node;
            node.prev = tail;
            tail = node;

            map.remove(key);
            map.put(key, node);
        }

        return val;
    }

    // 3. insert 3
    // 3, 4 insert 3
    // 3, 4 insert 4

    // if head == null
    // if map containsKey
    // if map is at capacity
    // if map doesn't contain
    public void put(int key, int value) {
        if (head == null) {

            head = new Node(key, value);
            tail = head;
            map.put(key, head);
            return;

        } else if (map.containsKey(key)) {

            Node node = map.get(key);

            if (node.next == null) {
                node.key = key;
                node.val = value;
                return;
            }

            if (node.prev == null) {
                head = head.next;
                head.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

        } else if (map.size() == capacity) {

            //Delete first element
            int lruKey = head.key;
            map.remove(lruKey);

            if (head.next == null) {
                head.key = key;
                head.val = value;
                map.put(key, head);
                return;
            }

            head = head.next;
            head.prev = null;
        }

        Node node = new Node(key, value);
        tail.next = node;
        node.prev = tail;
        tail = node;

        //add element to map
        map.put(key, tail);
    }
}

class Node {
    Node next;
    Node prev;
    int key;
    int val;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}