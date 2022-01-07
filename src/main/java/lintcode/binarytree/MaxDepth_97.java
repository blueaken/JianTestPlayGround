package lintcode.binarytree;

import type.TreeNode;

public class MaxDepth_97 {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        return helper(root);
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int leftLevel = helper(node.left);
        int rightLevel = helper(node.right);

        return Math.max(leftLevel, rightLevel) + 1;
    }
}
