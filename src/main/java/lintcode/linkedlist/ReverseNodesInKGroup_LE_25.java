package lintcode.linkedlist;

import type.ListNode;

public class ReverseNodesInKGroup_LE_25 {
    /**
     11.17.2022
     ref 东哥 post
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            //if [a, b) less than length k, no need to reverse, return head directly
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        //reverse range [a, b)
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverse(ListNode a, ListNode b) {
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
