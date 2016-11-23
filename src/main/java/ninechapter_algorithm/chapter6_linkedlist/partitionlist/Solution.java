package ninechapter_algorithm.chapter6_linkedlist.partitionlist;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 4/23/16 3:54 PM
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
            return head;
        }

        ListNode leftDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);
        ListNode left = leftDummy;
        ListNode right = rightDummy;

        while(head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
                head = head.next;
            } else {
                right.next = head;
                right = right.next;
                head = head.next;
            }
        }

        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}
