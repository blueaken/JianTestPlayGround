package ninechapter_algorithm.chapter6_linkedlist.reorderlist.third;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 7/23/16 09:37
 */
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null) {
            return;
        }

        ListNode mid = findMid(head);
        ListNode half = mid.next;
        mid.next = null;
        merge(head, reverse(half));
    }

    private ListNode findMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        int count = 1;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null && l2 != null) {
            if (count % 2 == 1) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            count++;
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
    }
}
