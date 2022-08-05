package lintcode.design;

import java.util.HashMap;
import java.util.Map;

public class FirstUnique_LE_1429 {
    /*
        - ref https://blog.csdn.net/MrJustin/article/details/106324890
        - kind of similar to LRU, implemented with a Doubly Linked List and HashMap, but logic is simpler than it
        - similar to a queue behavior, new number added in the tail, retrieve from the head
        - note not necessary for the extra 'used' set from the above link, use map itself
    */

    class Node {
        Node prev, next = null;
        int val;

        Node (int val) {
            this.val = val;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1);
    Node tail = new Node(-1);

    public FirstUnique_LE_1429(int[] nums) {
        //init a doubly linked list
        head.next = tail;
        tail.prev = head;

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    //O(1)
    public int showFirstUnique() {
        return head.next.val;
    }

    //O(1)
    public void add(int value) {
        if (!map.containsKey(value)) {
            addNum(value);
        } else if (map.get(value) == null) {
            //duplicate number has been removed before
            return;
        } else {
            //new duplicate number
            removeMapAndList(value);
        }
    }

    //O(1)
    private void removeMapAndList (int value) {
        Node cur = map.get(value);

        map.put(value, null); // 区别新的重复number和已删除的重复number
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }

    //O(1)
    private void addNum (int value) {
        Node node = new Node(value);
        node.next = tail;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;

        map.put(value, node);
    }
}
