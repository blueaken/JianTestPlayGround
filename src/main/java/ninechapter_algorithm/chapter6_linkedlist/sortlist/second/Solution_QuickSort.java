package ninechapter_algorithm.chapter6_linkedlist.sortlist.second;

import type.ListNode;

/**
 * Author: blueaken
 * Date: 5/12/16 10:04
 */
public class Solution_QuickSort {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        //quick sort
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pivot = findMid(head);
        ListNode leftDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode middleDummy = new ListNode(0);
        ListNode middle = middleDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode right = rightDummy;
        while (head != null) {
            if (head.val < pivot.val) {
                left.next = head;
                left = left.next;
            } else if (head.val > pivot.val){
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

        //sort
        ListNode leftSorted = sortList(leftDummy.next);
        ListNode rightSorted = sortList(rightDummy.next);

        //combine
        return combine(leftSorted, middleDummy.next, rightSorted);
    }

    private ListNode combine(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        //getTail will handle the case when left is null
        tail.next = left;
        tail = getTail(tail);
        tail.next = middle;
        tail = getTail(tail);
        tail.next = right;

        return dummy.next;
    }

    private ListNode getTail(ListNode head) {
        if (head == null) {
            return null;
        }

        while (head.next != null) {
            head = head.next;
        }
        return head;
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
//        ListNode one = new ListNode(1);
//        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        one.next = three;
//        three.next = two;

        ListNode one = new ListNode(2);
        ListNode two = new ListNode(-1);
        ListNode three = new ListNode(0);
        one.next = two;
        two.next = three;

        Solution_QuickSort solution_quickSort = new Solution_QuickSort();
        solution_quickSort.sortList(one).print();
    }
}
