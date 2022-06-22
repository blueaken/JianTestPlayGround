package lintcode.linkedlist;

import java.util.Stack;
import type.ListNode;

public class MaxTwinSumLinkedList_LE_2130 {
    /*
        - 1. find the size of the list
        - 2. init a stack of half list size and push the first half list
        - 3. add each node of the rest half to the stack top, which is the twin nodes sum and return the max
        - Time is O(N), need 2 iteration of the list, Space is O(N), for the stack
    */
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }

        int size = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            size++;
        }

        Stack<Integer> stack = new Stack<>();
        node = head;
        int count = size / 2, max = 0;
        while(node != null) {
            if (count > 0) {
                stack.push(node.val);
                count--;
            } else {
                max = Math.max(max, node.val + stack.pop());
            }
            node = node.next;
        }
        return max;
    }
}
