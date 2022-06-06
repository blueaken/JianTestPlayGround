package lintcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
    - implemented with doubly linked list + hashmap
 */
public class LRUCache_LE_146_P1 {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    //init dummy head and tail node of the doubly linked list
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap<Integer, Node>();

    public LRUCache_LE_146_P1(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            //remove the node first
            node.next.prev = node.prev;
            node.prev.next = node.next;

            moveToTail(node);
            return node.val;
        } else {
            return -1;
        }
    }

    private void moveToTail(Node node) {
        //this method should only move node to tail, remove node should process in caller method
        node.next = tail;
        node.prev = tail.prev;
        node.prev.next = node;
        tail.prev = node;
    }

    public void put(int key, int value) {
        //get method updates the node to tail, no more process needed
        if (get(key)!= -1) {
            map.get(key).val = value;
            return;
        }

        if (map.size() == capacity) {
            //remove the top node
            Node top = head.next;
            head.next = top.next;
            top.next.prev = head;
            map.remove(top.key);
        }

        Node node = new Node(key, value);
        moveToTail(node);
        map.put(key, node);
        return;
    }

}
