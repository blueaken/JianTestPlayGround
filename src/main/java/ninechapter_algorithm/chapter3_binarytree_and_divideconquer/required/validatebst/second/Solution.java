package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.validatebst.second;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/18/16 11:20 PM
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

    private boolean rec(TreeNode node, Integer leftBoundary, Integer rightBoundary) {
        //top down Divide & Conquer

        if (node == null) {
            return true;
        }
        if ((rightBoundary != null && node.val >= rightBoundary)
                || (leftBoundary != null && node.val <= leftBoundary)) {
            return false;
        }

        return rec(node.left, leftBoundary, node.val) && rec(node.right, node.val, rightBoundary);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.left.left = new TreeNode(5);

        node.right = new TreeNode(3);

        System.out.println(solution.isValidBST(node));
    }
}
