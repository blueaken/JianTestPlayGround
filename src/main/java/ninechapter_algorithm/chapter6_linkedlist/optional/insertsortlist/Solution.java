package ninechapter_algorithm.chapter6_linkedlist.optional.insertsortlist;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/16/16 11:17
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public static ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null && cur.next != null) {
            if (cur.val > cur.next.val) {
                ListNode next = cur.next;
                cur.next = next.next;

                ListNode preInsert = dummy;
                ListNode start = dummy.next;
                while (start != null && start.val < next.val) {
                    preInsert = preInsert.next;
                    start = start.next;
                }
                next.next = start;
                preInsert.next = next;
                continue;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(3);
        test.next.next = new ListNode(2);
        test.next.next.next = new ListNode(0);
        test.next.next.next.next = new ListNode(5);

        insertionSortList(test).print();
    }
}
