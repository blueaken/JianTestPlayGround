package lintcode.design;

import java.util.HashMap;
import java.util.Map;

/*
    - use doubly linked list and hashmap
    - linkedhashmap is also an option
    - ref previous notes
*/
public class LRUCache_LE_146 {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    //head & tail are 2 null nodes
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache_LE_146(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        //remove cur node
        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;

        //move cur to tail
        moveToTail(cur);

        return map.get(key).value;
    }

    public void put(int key, int value) {
        //get method will move updated node to tail, no need to call moveToTail again here
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        //if size is full, remove the top node
        if (map.size() == this.capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;

        }

        Node node = new Node(key, value);
        map.put(key, node);
        moveToTail(node);
    }

    private void moveToTail (Node node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
}
