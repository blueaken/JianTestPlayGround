package lintcode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_LE_146_P2 {
    /*
        - P2
        - use doubly linked list + hash map, after each visit move the element to the tail
        - if overflow, remove from top
    */

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LRUCache_LE_146_P2(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToTail(node);

            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        //can reuse get() method which already handled moveToTail
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }


        Node node = new Node(key, value);
        moveToTail(node);
        map.put(key, node);

        //remove from head if overflow
        if (map.size() > this.capacity) {
            Node t = head.next;
            t.prev.next = t.next;
            t.next.prev = t.prev;
            map.remove(t.key);
        }
    }

    private void moveToTail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        node.prev.next = node;
        tail.prev = node;
    }
}
