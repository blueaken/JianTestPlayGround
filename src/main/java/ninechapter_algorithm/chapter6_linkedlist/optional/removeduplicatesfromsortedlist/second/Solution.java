package ninechapter_algorithm.chapter6_linkedlist.optional.removeduplicatesfromsortedlist.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/11/16 08:47
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (prev.val == cur.val) {
                while (cur != null && prev.val == cur.val) {
                    cur = cur.next;
                }
                prev.next = cur;
                cur = prev.next;
                continue;
            }
            prev = prev.next;
            cur = cur.next;
        }

        return head;
    }
}
