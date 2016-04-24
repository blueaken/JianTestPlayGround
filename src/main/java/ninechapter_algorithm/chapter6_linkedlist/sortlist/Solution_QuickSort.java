package ninechapter_algorithm.chapter6_linkedlist.sortlist;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 4/23/16 4:51 PM
 */
public class Solution_QuickSort {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
    using constant space complexity.
     */
    public static ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        /* quick sort */

        ListNode pivot = findMidNode(head);

        ListNode leftDummy = new ListNode(-1);
        ListNode middleDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);
        ListNode left = leftDummy;
        ListNode middle = middleDummy;
        ListNode right = rightDummy;

        while (head != null) {
            if (head.val < pivot.val) {
                left.next = head;
                left = left.next;
            } else if (head.val > pivot.val) {
                right.next = head;
                right = right.next;
            } else {
                middle.next = head;
                middle = middle.next;
            }
            head = head.next;
        }
        left.next = null;
        middle.next = null;
        right.next = null;

        ListNode leftSorted = sortList(leftDummy.next);
        ListNode rightSorted = sortList(rightDummy.next);

        return concat(leftSorted, middleDummy.next, rightSorted);
    }

    private static ListNode findMidNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        //注意，如果FAST = HEAD的话会死循环。可以另外返回一个PreSlow来解决。可以看以前写得 SORT.SORTLIS里面的处理方法
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        tail.next = left;
        tail = getTail(tail);
        tail.next = middle;
        tail = getTail(tail);
        tail.next = right;

        return dummy.next;
    }

    private static ListNode getTail(ListNode head) {
        if (head == null) {
            return null;
        }

        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);

        sortList(head).print();
    }
}
