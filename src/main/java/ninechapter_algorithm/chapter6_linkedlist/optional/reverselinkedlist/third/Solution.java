package ninechapter_algorithm.chapter6_linkedlist.optional.reverselinkedlist.third;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/21/16 14:33
 */
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }

        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
