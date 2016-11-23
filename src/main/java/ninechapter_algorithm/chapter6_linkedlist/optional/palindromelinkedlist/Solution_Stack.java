package ninechapter_algorithm.chapter6_linkedlist.optional.palindromelinkedlist;

import type.ListNode;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 5/17/16 09:54
 */
public class Solution_Stack {
    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode mid = findMid(head, stack);
        while (mid != null) {
            if (stack.isEmpty() || mid.val != stack.pop()) {
                return false;
            }
            mid = mid.next;
        }
        return true;
    }

    private ListNode findMid(ListNode head, Stack<Integer> stack) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        //ensure slow start after the mid point
        if (fast != null) {
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
//        ListNode test = new ListNode(1);
//        test.next = new ListNode(0);
//        test.next.next = new ListNode(3);
//        test.next.next.next = new ListNode(4);
//        test.next.next.next.next = new ListNode(0);
//        test.next.next.next.next.next = new ListNode(1);

//        ListNode test = new ListNode(3);
//        test.next = new ListNode(4);
//        test.next.next = new ListNode(4);
//        test.next.next.next = new ListNode(3);

        ListNode test = new ListNode(1);
        test.next = new ListNode(0);
        test.next.next = new ListNode(1);

        Solution_Stack solution = new Solution_Stack();
        System.out.println(solution.isPalindrome(test));
    }
}
