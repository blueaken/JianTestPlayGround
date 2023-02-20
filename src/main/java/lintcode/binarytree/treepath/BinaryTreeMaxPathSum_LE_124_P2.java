package lintcode.binarytree.treepath;

import type.TreeNode;

public class BinaryTreeMaxPathSum_LE_124_P2 {
    /**
     2.20.2023
     P2 Labuladong Template
     */
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getOneSideMax(root);
        return res;
    }

    public int getOneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // note need to compare to 0 to avoid negative value!
        int left = Math.max(0, getOneSideMax(root.left));
        int right = Math.max(0, getOneSideMax(root.right));

        // post position
        int pathSum = left + right + root.val;
        res = Math.max(res, pathSum);
        // return one side max
        return Math.max(left, right) + root.val;
    }
}
