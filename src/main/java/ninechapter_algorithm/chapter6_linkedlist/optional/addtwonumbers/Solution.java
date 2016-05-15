package ninechapter_algorithm.chapter6_linkedlist.optional.addtwonumbers;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/15/16 10:10
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int cur = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + cur;
            int next = val / 10;

            val = val % 10;
            node.next = new ListNode(val);
            cur = next;

            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            l1.val = l1.val + cur;
            node.next = l1;
        }
        if (l2 != null) {
            l2.val = l2.val + cur;
            node.next = l2;
        }
        if (l1 == null && l2 == null && cur == 1) {
            node.next = new ListNode(cur);
        }

        return dummy.next;
    }
}
