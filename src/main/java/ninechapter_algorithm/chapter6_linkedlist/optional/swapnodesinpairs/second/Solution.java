package ninechapter_algorithm.chapter6_linkedlist.optional.swapnodesinpairs.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/18/16 17:02
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while ( cur != null && cur.next != null) {
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = temp;

            pre = cur;
            cur = temp;
        }
        return dummy.next;
    }
}
