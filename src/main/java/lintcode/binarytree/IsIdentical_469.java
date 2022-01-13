package lintcode.binarytree;

import type.TreeNode;

public class IsIdentical_469 {
    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;

        return (isIdentical(a.left, b.left) && isIdentical(a.right, b.right));
    }
}
