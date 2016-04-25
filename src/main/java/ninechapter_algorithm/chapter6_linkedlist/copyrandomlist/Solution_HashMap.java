package ninechapter_algorithm.chapter6_linkedlist.copyrandomlist;

import type.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 4/25/16 2:49 PM
 */
public class Solution_HashMap {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode headOrigin = head;
        RandomListNode dummyNew = new RandomListNode(-1);
        RandomListNode node = dummyNew;
        while (headOrigin != null) {
            RandomListNode newNode = new RandomListNode(headOrigin.label);
            map.put(headOrigin, newNode);

            node.next = newNode;
            node = node.next;
            headOrigin = headOrigin.next;
        }

        headOrigin = head;
        RandomListNode headNew = dummyNew.next;
        while (headNew != null) {
            headNew.random = map.get(headOrigin.random);
            headOrigin = headOrigin.next;
            headNew = headNew.next;
        }

        return dummyNew.next;
    }
}
