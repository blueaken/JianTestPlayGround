package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.mindepthofbinarytree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/21/16 3:20 PM
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }
}
