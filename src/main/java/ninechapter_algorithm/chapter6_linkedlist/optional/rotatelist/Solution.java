package ninechapter_algorithm.chapter6_linkedlist.optional.rotatelist;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 4/25/16 10:56 AM
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public static ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                fast = head;
            }
            fast = fast.next;
        }
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = prev.next;
            fast = fast.next;
        }

        if (fast == null) {
            return prev;
        }
        fast.next = head;
        dummy.next = prev.next;
        prev.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        rotateRight(head, 30).print();
    }
}
