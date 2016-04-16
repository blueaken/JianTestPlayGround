package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.balancedbinarytree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/16/16 10:17 AM
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }

        int height = getHeight(root);
        return height != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        if (left == -1) {
            return -1;
        }

        int right = getHeight(node.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
