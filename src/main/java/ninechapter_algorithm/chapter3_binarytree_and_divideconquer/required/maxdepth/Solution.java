package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.maxdepth;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/16/16 9:35 AM
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
