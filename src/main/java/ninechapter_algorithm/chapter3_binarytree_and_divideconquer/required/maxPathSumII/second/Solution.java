package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.maxPathSumII.second;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/18/16 12:54 PM
 */
public class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Algorithm:
        // Use divide conquer algorithm. Get the max path sum from left child
        // and max path sum from right child. Then conquer them together.

        // check some corner case here
        if (root == null) {
            return 0;
        }

        // divide the max path sum from left and right children
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);

        // conquer and return
        return Math.max(Math.max(left, right) + root.val, root.val);
    }
}
