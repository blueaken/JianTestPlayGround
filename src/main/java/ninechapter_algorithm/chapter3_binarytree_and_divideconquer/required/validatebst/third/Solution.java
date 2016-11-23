package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.validatebst.third;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 6/27/16 10:50
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return rec(root, null, null);
    }

    private boolean rec(TreeNode node, Integer left, Integer right) {
        //divide and conquer
        if (node == null) {
            return true;
        }

        if (left != null && node.val <= left || right != null && node.val >= right) {
            return false;
        }
        return rec(node.left, left, node.val) && rec(node.right, node.val, right);
    }
}
