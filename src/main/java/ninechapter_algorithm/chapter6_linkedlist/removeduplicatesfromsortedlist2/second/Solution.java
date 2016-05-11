package ninechapter_algorithm.chapter6_linkedlist.removeduplicatesfromsortedlist2.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/11/16 09:00
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
                cur = prev.next;
                continue;
            }
            prev = prev.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
