package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.other.convertsortedlisttobst;

import type.ListNode;
import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/20/16 4:22 PM
 */
public class Solution {
    private ListNode list;

    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {

        // write your code here
        if (head == null) {
            return null;
        }

        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        list = head;
        return helper(0, len - 1);
    }

    private TreeNode helper(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode left = helper(start, mid -1);
        TreeNode node = new TreeNode(list.val);
        list = list.next;
        node.left = left;
        node.right = helper(mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //1,3,5
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(3);
        ln1.next.next = new ListNode(5);

        solution.sortedListToBST(ln1);
    }
}
