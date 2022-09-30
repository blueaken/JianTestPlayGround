package lintcode.binarytree.treepath;

import type.TreeNode;

public class BinaryTreeMaxPathSum_LE_124 {
    /*
        ref Huifeng Guan post
        - maxDownSum的意思是从起点出发往下“不拐弯”所能得到的最大路径和。如果maxDownSum(node->left)>0，那么maxTurnSum肯定会选择往左边继续往下，否则maxTurnSum就不会有左边的支路。对于右子树的分析同理。

所以我们有这样的表达式：

maxTurnSum(node) = node->val + max(0, maxDownSum(node->left)) + max(0, maxDownSum(node->right))
    */

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        rec(root);
        return res;
    }

    private int rec(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = rec(node.left);
        int right = rec(node.right);
        int arch = node.val + Math.max(0, left) + Math.max(0, right);

        res = Math.max(res, arch);

        int maxDownPath = Math.max(node.val + Math.max(left, right), node.val);

        return maxDownPath;
    }
}
