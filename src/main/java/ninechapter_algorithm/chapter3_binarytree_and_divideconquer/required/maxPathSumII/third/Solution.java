package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.maxPathSumII.third;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 6/27/16 13:54
 */
public class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }

        //same as I, but without the arch case
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);

        return Math.max(Math.max(left, right) + root.val, root.val);
    }
}
