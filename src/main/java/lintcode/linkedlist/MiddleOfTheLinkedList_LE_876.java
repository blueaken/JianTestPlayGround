package lintcode.linkedlist;

import type.ListNode;

public class MiddleOfTheLinkedList_LE_876 {
    /**
     ref 东哥 post
     use slow & fast pointer
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
