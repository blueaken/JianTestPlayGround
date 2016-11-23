package ninechapter_algorithm.chapter8_data_structure.lrucache.second;

import java.util.HashMap;
import java.util.Map;

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

/**
 * Author: blueaken
 * Date: 6/2/16 12:31
 */
public class Solution_DoublyLInkedListAndHashMap {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    // @param capacity, an integer
    public Solution_DoublyLInkedListAndHashMap(int capacity) {
        // write your code here
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        this.capacity = capacity;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            putToTail(cur, tail);
            return cur.val;
        } else {
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            putToTail(cur, tail);
            cur.val = value;
        } else {
            Node cur = new Node(key, value);
            if (map.size() < capacity) {
                putToTail(cur, tail);
            } else {
                //remove first node
                Node toBeRemoved = head.next;
                Node next = toBeRemoved.next;
                head.next = next;
                next.prev = head;
                map.remove(toBeRemoved.key);

                putToTail(cur, tail);
            }
            map.put(key, cur);
        }
    }

    private void putToTail(Node cur, Node tail) {
        //remove current node if existing in linked list
        if (cur.prev != null && cur.next != null) {
            Node prev = cur.prev;
            Node next = cur.next;
            prev.next = next;
            next.prev = prev;
        }

        //add it to the end
        Node prev = tail.prev;
        prev.next = cur;
        cur.prev = prev;
        cur.next = tail;
        tail.prev = cur;
    }

    public static void main(String[] args) {
        //expect: 1,-1,1
        Solution_DoublyLInkedListAndHashMap cache = new Solution_DoublyLInkedListAndHashMap(2);
        cache.set(2, 1);
        cache.set(1, 1);
        System.out.println(cache.get(2));
        cache.set(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
