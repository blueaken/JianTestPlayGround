package ninechapter_algorithm.chapter8_data_structure.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 5/2/16 17:00
 */
class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache_With_HashMap_and_DoubleLinkedNode {
    private Map<Integer, Node> map;
    private int capacity;
    private Node dummyHead;
    private Node dummyTail;

    // @param capacity, an integer
    public LRUCache_With_HashMap_and_DoubleLinkedNode(int capacity) {
        // write your code here
        this.capacity = capacity;
        this.map = new HashMap<>();
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }

        Node cur = map.get(key);

        //remove current node
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        //move cur to the tail
        moveToTail(cur);

        return cur.val;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;

            //remove current node
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            //move cur to the tail
            moveToTail(cur);
            return;
        }

        if (map.size() == this.capacity) {
            //remove head node
            int headKey = dummyHead.next.key;
            dummyHead.next = dummyHead.next.next;
            dummyHead.next.prev = dummyHead;
            map.remove(headKey);
        }

        Node cur = new Node(key, value);
        map.put(key, cur);
        moveToTail(cur);
        return;
    }

    private void moveToTail(Node node) {
        node.next = dummyTail;
        node.prev = dummyTail.prev;
        dummyTail.prev.next = node;
        dummyTail.prev = node;
    }

    public static void main(String[] args) {
        //expect: 1,-1,1
//        LRUCache_With_HashMap_and_DoubleLinkedNode cache = new LRUCache_With_HashMap_and_DoubleLinkedNode(2);
//        cache.set(2, 1);
//        cache.set(1, 1);
//        System.out.println(cache.get(2));
//        cache.set(4, 1);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));

        //expect: 4,3,2,-1,-1,2,3,-1,5
        LRUCache_With_HashMap_and_DoubleLinkedNode cache = new LRUCache_With_HashMap_and_DoubleLinkedNode(3);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);
        cache.set(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.set(5, 5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }
}
