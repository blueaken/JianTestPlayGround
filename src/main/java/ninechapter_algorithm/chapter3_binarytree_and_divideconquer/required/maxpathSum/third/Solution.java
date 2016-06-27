package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.maxpathSum.third;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 6/27/16 13:48
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
        int left = rec(node.left, max);
        int right = rec(node.right, max);

        int maxsubTreePath = Math.max(Math.max(left, right) + node.val, node.val);
        int arch = left + node.val + right;
        max[0] = Math.max(Math.max(maxsubTreePath, arch), max[0]);

        return maxsubTreePath;
    }
}
