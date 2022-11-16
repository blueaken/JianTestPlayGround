package lintcode.linkedlist;

import type.ListNode;

public class PartitionList_LE_86 {
    /**
     11.16.2022
     ref 东哥 post
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }

            //cut p from original list then assign the next p
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        p1.next = dummy2.next;
        return dummy1.next;
    }
}
