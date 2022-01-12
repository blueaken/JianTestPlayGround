package lintcode.binarytree;

import type.TreeNode;

public class IsSymmetric_468 {
    /**
     * @param root: the root of binary tree.
     * @return: true if it is a mirror of itself, or false.
     */
    //Idea:
    //1. 不需要遍历，判断这棵树的左子树和右子树是否对称即可。
    //2. 左右两棵子树的对称条件：根节点相等，左子树的左子树和右子树的右子树对称，左子树的右子树和右子树的左子树对称。
    //ref: https://blog.csdn.net/SoulOH/article/details/81735414
    public boolean isSymmetric(TreeNode root) {
        // write your code here
        if (root == null) return true;

        return rec(root.left, root.right);
    }

    private boolean rec(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return (left.val == right.val) && rec(left.left, right.right) && rec(left.right, right.left);
    }
}
