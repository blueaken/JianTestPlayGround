package ninechapter_algorithm.chapter6_linkedlist.copyrandomlist.second;

import type.RandomListNode;

/**
 * Author: blueaken
 * Date: 5/14/16 11:33
 */
public class Solution_Without_HashMap {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        //w/o HashMap
        if (head == null) {
            return head;
        }

        //shallow copy in the origin list
        RandomListNode node = head;
        while (node != null) {
            RandomListNode copy = new RandomListNode(node.label);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }

        //deep copy random
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        //deep copy next and split
        node = head.next;
        while (node != null) {
            if (node.next != null) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head.next;
    }
}
