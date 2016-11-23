package ninechapter_algorithm.chapter6_linkedlist.optional.nthtolastnodeinlist;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/17/16 09:06
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list.
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (n == 0) {
            return null;
        }

        ListNode runner = head;
        for (int i = 0; i < n; i++) {
            runner = runner.next;
        }

        ListNode walker = head;
        while (runner != null) {
            walker = walker.next;
            runner = runner.next;
        }
        return walker;
    }
}
