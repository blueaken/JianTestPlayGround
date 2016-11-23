package ninechapter_algorithm.chapter6_linkedlist.optional.reverselinkedlist.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/10/16 21:54
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

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }
}
