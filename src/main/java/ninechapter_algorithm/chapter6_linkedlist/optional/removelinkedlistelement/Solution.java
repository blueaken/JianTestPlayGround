package ninechapter_algorithm.chapter6_linkedlist.optional.removelinkedlistelement;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/11/16 08:28
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                while (cur.next != null && cur.next.val == val) {
                    cur = cur.next;
                }
                cur = cur.next;
                prev.next = cur;
                continue;
            }
            prev = prev.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
