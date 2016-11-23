package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.maxpathSum.second;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/18/16 12:24 PM
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        rec(root, max);
        return max[0];
    }

    private int rec(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }

        //divide
        int left = rec(node.left, max);
        int right = rec(node.right, max);

        //conquer
        int pathMax = Math.max(Math.max(left, right) + node.val, node.val);
        max[0] = Math.max(Math.max(pathMax, left + right + node.val), max[0]);

        return pathMax;
    }
}
