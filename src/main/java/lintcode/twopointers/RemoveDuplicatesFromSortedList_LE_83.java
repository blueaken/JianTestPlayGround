package lintcode.twopointers;

import type.ListNode;

public class RemoveDuplicatesFromSortedList_LE_83 {
    /**
     ref 东哥 post
     - similar to the array problem 025
     - solve by slow / fast pointer
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                // slow = slow.next;
                // slow.val = fast.val;

                //optimize with linkedlist property
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }

        slow.next = null;
        return head;
    }
}
