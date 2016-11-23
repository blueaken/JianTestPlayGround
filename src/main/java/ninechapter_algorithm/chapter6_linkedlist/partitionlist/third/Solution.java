package ninechapter_algorithm.chapter6_linkedlist.partitionlist.third;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/13/16 23:16
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;

        while (head != null) {
            int cur = head.val;
            if (cur < x) {
                left.next = new ListNode(cur);
                left = left.next;
            } else {
                right.next = new ListNode(cur);
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDummy.next;

        return leftDummy.next;
    }
}
