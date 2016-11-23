package ninechapter_algorithm.chapter6_linkedlist.reorderlist.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/13/16 08:48
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
        ListNode end = reverse(mid.next);
        mid.next = null;

        merge(head, end);
    }

    private ListNode merge(ListNode head, ListNode end) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int count = 1;
        while (head != null && end != null) {
            if (count++ % 2 == 1) {
                node.next = head;
                head = head.next;
            } else {
                node.next = end;
                end = end.next;
            }
            node = node.next;
        }
        if (head != null) {
            node.next = head;
        }
        if (end != null) {
            node.next = end;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        solution.reorderList(head);
    }
}
