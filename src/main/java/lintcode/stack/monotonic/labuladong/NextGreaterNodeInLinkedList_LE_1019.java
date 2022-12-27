package lintcode.stack.monotonic.labuladong;

import type.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList_LE_1019 {
    /**
     12.27.2022
     - convert to an array list, then use NGE template
     */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nums.add(p.val);
            p = p.next;
        }

        int n = nums.size();
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            //monotonic increas from back
            while (stack.size() > 0 && stack.peek() <= nums.get(i)) {
                stack.pop();
            }
            res[i] = stack.size() == 0 ? 0 : stack.peek();
            stack.push(nums.get(i));
        }
        return res;
    }
}
