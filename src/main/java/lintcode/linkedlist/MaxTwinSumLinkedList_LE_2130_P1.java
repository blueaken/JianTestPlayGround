package lintcode.linkedlist;

import type.ListNode;

import java.util.Stack;

public class MaxTwinSumLinkedList_LE_2130_P1 {
    /*
        - 1. find the size of the list
        - 2. init a stack of half list size and push the first half list
        - 3. add each node of the rest half to the stack top, which is the twin nodes sum and return the max
        - Time is O(N), need 2 iteration of the list, Space is O(N), for the stack
    */
    public int pairSum(ListNode head) {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }

        Stack<Integer> stack = new Stack<>();
        node = head;
        int count = size / 2, max = 0;
        while (node != null) {
            if (count > 0) {
                stack.push(node.val);
                count--;
            } else {
                int cur = node.val + stack.pop();
                max = Math.max(max, cur);
            }
            node = node.next;
        }
        return max;
    }

    public static void main(String[] args) {
        //4,2,2,3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        MaxTwinSumLinkedList_LE_2130_P1 solution = new MaxTwinSumLinkedList_LE_2130_P1();
        System.out.println(solution.pairSum(head));
    }
}
