package ninechapter_algorithm.chapter6_linkedlist.optional.removeduplicatesfromunsortedlist.third;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/17/16 19:02
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                while (cur != null && cur.val == pre.val) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }

        return head;
    }
}
