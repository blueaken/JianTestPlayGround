package ninechapter_algorithm.chapter6_linkedlist.convertsortedlisttobst;

import type.ListNode;
import type.TreeNode;

/**
 * Author: blueaken
 * Date: 5/14/16 13:33
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    private ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        node = head;
        int num = 0;
        while (node != null) {
            num++;
            node = node.next;
        }
        node = head;

        return rec(0, num - 1);
    }

    private TreeNode rec(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = rec(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        root.left = left;
        root.right = rec(mid + 1, end);
        return root;
    }
}
