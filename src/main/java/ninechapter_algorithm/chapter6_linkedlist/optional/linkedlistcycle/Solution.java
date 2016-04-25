package ninechapter_algorithm.chapter6_linkedlist.optional.linkedlistcycle;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 4/25/16 9:03 AM
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
