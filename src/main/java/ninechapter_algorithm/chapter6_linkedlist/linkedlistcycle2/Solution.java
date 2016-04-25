package ninechapter_algorithm.chapter6_linkedlist.linkedlistcycle2;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 4/25/16 9:21 AM
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        while (head != slow.next) {
            slow = slow.next;
            head = head.next;
        }
        return head;
    }
}
