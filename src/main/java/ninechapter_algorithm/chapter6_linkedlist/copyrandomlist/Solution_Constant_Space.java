package ninechapter_algorithm.chapter6_linkedlist.copyrandomlist;

import type.RandomListNode;

/**
 * Author: blueaken
 * Date: 4/25/16 2:51 PM
 */
public class Solution_Constant_Space {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }

        //shallow copy and add into origin linked list
        RandomListNode node = head;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }

        //deep copy random onto the new nodes
        node = head;
        while (node != null && node.next != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        //split and return
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode nodeNew = dummy;
        node = head;
        while (node != null && node.next != null) {
            nodeNew.next = node.next;
            node = node.next.next;
            nodeNew = nodeNew.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(-1);
        node.next = new RandomListNode(1);

        copyRandomList(node).print();
    }
}
