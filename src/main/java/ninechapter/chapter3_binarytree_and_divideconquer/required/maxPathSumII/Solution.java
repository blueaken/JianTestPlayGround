package ninechapter.chapter3_binarytree_and_divideconquer.required.maxPathSumII;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/27/16 4:48 PM
 */
public class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public static int maxPathSum2(TreeNode root) {
        // Write your code here
        return rec(root);
    }

    private static int rec(TreeNode node)  {
        if (node == null) {
            return 0;
        }

        int left = rec(node.left);
        int right = rec(node.right);

        return Math.max(Math.max(left, right) + node.val, node.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

//        TreeNode treeNode = new TreeNode(-19);
//        treeNode.left = new TreeNode(-3);
//        treeNode.right = new TreeNode(-4);

        int maxsum = maxPathSum2(treeNode);
        System.out.println("Max Path Sum of the tree is: " + maxsum);
    }
}
