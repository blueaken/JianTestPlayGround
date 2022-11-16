package lintcode.linkedlist;

import type.ListNode;

public class IntersectionOfTwoLinkedLists_LE_160 {
    /**
     11.16.2022
     ref 东哥 post
     - the real difficulty is to solve it without extra space
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
