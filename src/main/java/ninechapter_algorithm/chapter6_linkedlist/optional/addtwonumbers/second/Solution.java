package ninechapter_algorithm.chapter6_linkedlist.optional.addtwonumbers.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/21/16 11:11
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
        int signal = 0;
        while (l1 != null && l2 != null) {
            int val = (l1.val + l2.val + signal) % 10;
            signal = (l1.val + l2.val + signal) / 10;
            node.next = new ListNode(val);

            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            node.next = new ListNode((l1.val + signal) % 10);
            signal = (l1.val + signal) / 10;
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            node.next = new ListNode((l2.val + signal) % 10);
            signal = (l2.val + signal) / 10;
            node = node.next;
            l2 = l2.next;
        }
        if (signal == 1) {
            node.next = new ListNode(1);
        }

        return dummy.next;
    }
}
