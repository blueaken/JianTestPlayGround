package lintcode.linkedlist;

import type.ListNode;

public class ReverseLinkedList_LE_206 {
    /**
     11.17.2022
     ref 东哥 post
     solve by recursive
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
