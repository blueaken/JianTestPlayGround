package ninechapter_algorithm.chapter6_linkedlist.optional.swapnodesinpairs;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/16/16 10:44
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public static ListNode swapPairs(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null && cur.next != null) {
            ListNode q = cur.next;
            ListNode r = q.next;

            cur.next = r;
            q.next = cur;
            prev.next = q;
            prev = cur;
            cur = r;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);

        swapPairs(test).print();
    }
}
