package ninechapter_algorithm.chapter6_linkedlist.optional.addtwonumbers2;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/15/16 10:26
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int val = l1Val + l2Val + carry;

            node.next = new ListNode(val % 10);
            carry = val / 10;
            node = node.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }

        return reverse(dummyHead.next);
    }

    private ListNode reverse(ListNode list) {
        ListNode prev = null;
        while (list != null) {
            ListNode temp = list.next;
            list.next = prev;
            prev = list;
            list = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(5);

        solution.addLists2(l1, l2).print();
    }
}
