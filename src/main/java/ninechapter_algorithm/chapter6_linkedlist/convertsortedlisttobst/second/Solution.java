package ninechapter_algorithm.chapter6_linkedlist.convertsortedlisttobst.second;

import type.ListNode;
import type.TreeNode;

/**
 * Author: blueaken
 * Date: 7/21/16 15:17
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    private ListNode list;

    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        int num = 0;
        ListNode node = head;
        while (node != null) {
            num++;
            node = node.next;
        }
        list = head;

        return rec(0, num - 1);
    }

    private TreeNode rec(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode left = rec(start, mid - 1);
        TreeNode root = new TreeNode(list.val);
        list = list.next;
        root.left = left;
        root.right = rec(mid + 1, end);

        return root;
    }
}
