package ninechapter_algorithm.chapter6_linkedlist.optional.middleoflinkedlist.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/17/16 18:16
 */
public class Solution {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // Write your code here
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
