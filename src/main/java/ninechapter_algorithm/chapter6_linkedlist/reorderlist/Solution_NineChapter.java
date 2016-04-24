package ninechapter_algorithm.chapter6_linkedlist.reorderlist;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 4/24/16 2:17 PM
 */
public class Solution_NineChapter {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        // write your code here
        if (head == null) {
            return;
        }

        int n = 0;
        ListNode mid = findMidNode(head);
        ListNode right = reverse(mid.next);
        mid.next = null;

        merge(head, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        int n = 0;
        while (left != null && right != null) {
            if (n % 2 == 0) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
            n++;
        }

        if (left != null) {
            node.next = left;
        }
        if (right != null) {
            node.next = right;
        }

        return dummy.next;
    }

    private static ListNode findMidNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
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
}
