package lintcode.linkedlist;

import type.ListNode;

public class ReverseNodesInKGroup_LE_25_P1 {
    /**
     11.17.2022
     ref 东哥 post
     ============
     3.14.2023
     P1
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head;
        // base case
        for (int i = 0; i < k; i++) {
            if (b == null) {
                // if [a, b) less than k, then reserve the linked list unchanged
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reverse(head, a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode a, ListNode b) {
        ListNode pre = null, cur = a, nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;

            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
