package ninechapter_algorithm.chapter6_linkedlist.optional.reverseKgroup;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/25/16 18:13
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if (head == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        int count = 0;
        while ( cur != null) {
            count++;
            ListNode next = cur.next;
            if (count == k) {
                pre = reverse(pre, next);
                count = 0;
            }
            cur = next;
        }
        return dummy.next;
    }

    ListNode reverse(ListNode start, ListNode end) {
        if (start == null || start.next == null) {
            return start;
        }

        ListNode head = start.next;
        ListNode cur = start.next.next;
        while (cur != end) {
            ListNode temp = cur.next;
            cur.next = start.next;
            start.next = cur;
            cur = temp;
        }
        head.next = cur;
        return head;
    }
}
