package ninechapter_algorithm.chapter6_linkedlist.sortlist.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/12/16 09:29
 */
public class Solution_MergeSort {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        //merge sort
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        if (left != null) {
            node.next = left;
        }
        if (right != null) {
            node.next = right;
        }

        return dummy.next;
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
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = three;
        three.next = two;

        Solution_MergeSort solution_mergeSort = new Solution_MergeSort();
        solution_mergeSort.sortList(one).print();
    }
}
