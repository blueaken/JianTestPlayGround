package lintcode.binarytree;

import type.TreeNode;

public class MinDepth_155 {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        return helper(root);
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        //bypass either subtree when it does not exist
        if (node.left == null) {
            return helper(node.right) + 1;
        }
        if (node.right == null) {
            return helper(node.left) + 1;
        }

        return Math.min(helper(node.left), helper(node.right)) + 1;
    }
}
