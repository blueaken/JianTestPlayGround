package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.symmetricbinarytree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/21/16 2:43 PM
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
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }

        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
