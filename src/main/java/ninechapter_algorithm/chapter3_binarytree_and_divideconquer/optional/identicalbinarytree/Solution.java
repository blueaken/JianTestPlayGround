package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.identicalbinarytree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/21/16 12:15 PM
 */
public class Solution {
    /**
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }

        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}
