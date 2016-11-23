package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.other.convertsortedlisttobst.second;

import type.ListNode;
import type.TreeNode;

/**
 * Author: blueaken
 * Date: 6/30/16 09:17
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    private ListNode ln;

    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        int num = 0;
        ListNode p = head;
        while (p != null) {
            num++;
            p = p.next;
        }
        ln = head;

        return rec(0, num - 1);
    }

    private TreeNode rec(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = rec(start, mid - 1);
        TreeNode node = new TreeNode(ln.val);
        ln = ln.next;
        node.left = left;
        node.right = rec(mid + 1, end);
        return node;
    }
}
