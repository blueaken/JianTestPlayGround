package lintcode.binarytree.treepath;

import type.TreeNode;

public class BinaryTreeMaxPathSum_LE_124_P1 {
    /*
        ref Huifeng Guan post
        - maxDownSum的意思是从起点出发往下“不拐弯”所能得到的最大路径和。如果maxDownSum(node->left)>0，那么maxTurnSum肯定会选择往左边继续往下，否则maxTurnSum就不会有左边的支路。对于右子树的分析同理。

所以我们有这样的表达式：

maxTurnSum(node) = node->val + max(0, maxDownSum(node->left)) + max(0, maxDownSum(node->right))
        ==============================
        P1 11.03.2022
        ref 东哥 post - refactor the maxDepth problem with 后序 Traverse
        ==============================
    */

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxValOnePath(root);
        return res;
    }

    private int maxValOnePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxValOnePath(root.left));
        int right = Math.max(0, maxValOnePath(root.right));

        int pathSum = left + right + root.val;
        res = Math.max(res, pathSum);

        return root.val + Math.max(left, right); //return the max value of one path, per the function definition
    }
}
