package ninechapter_algorithm.chapter6_linkedlist.copyrandomlist.second;

import type.RandomListNode;

import java.util.HashMap;

/**
 * Author: blueaken
 * Date: 5/14/16 11:19
 */
public class Solution_HashMap {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        //with HashMap
        if (head == null) {
            return null;
        }

        //shallow copy
        RandomListNode node = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        //deep copy next, random
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
