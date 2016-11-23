package ninechapter_algorithm.chapter6_linkedlist.reorderlist;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 4/24/16 11:55 AM
 */
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public static void reorderList(ListNode head) {
        // write your code here
        if (head == null) {
            return;
        }

        int n = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            n++;
        }

        node = head;
        int count = 0;
        if (n % 2 == 0) {
            count = n / 2;
        } else {
            count = n / 2 + 1;
        }
        for (int i = 1; i <= count; i++) {
            node.next = reverse(node.next);
            node = node.next;
        }
        return;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        reorderList(head);
    }
}
