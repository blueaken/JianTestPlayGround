package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.symmetricbinarytree.second;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 6/28/16 10:52
 */
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null) {
            return true;
        }
        return isIdentical(root.left, root.right);
    }

    private boolean isIdentical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isIdentical(left.left, right.right) && isIdentical(left.right, right.left);
    }
}
