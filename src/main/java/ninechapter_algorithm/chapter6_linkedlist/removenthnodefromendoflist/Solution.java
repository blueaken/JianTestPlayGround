package ninechapter_algorithm.chapter6_linkedlist.removenthnodefromendoflist;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/10/16 09:27
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return fast;
            }
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode temp = slow.next.next;
        slow.next = temp;
        return dummy.next;
    }
}
