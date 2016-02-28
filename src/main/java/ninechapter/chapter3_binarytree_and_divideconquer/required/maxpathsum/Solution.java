package ninechapter.chapter3_binarytree_and_divideconquer.required.maxpathsum;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/27/16 4:22 PM
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public static int maxPathSum(TreeNode root) {
        // write your code here
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;

        rec (root, max);
        return max[0];
    }

    private static int rec(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }

        int left = rec(node.left, max);
        int right = rec(node.right, max);
        int arch = left + node.val + right;

        int maxPathThroughNode
                = Math.max(Math.max(left + node.val, right + node.val), node.val);

        max[0] = Math.max(Math.max(arch, maxPathThroughNode), max[0]);

        return maxPathThroughNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);

        int maxsum = maxPathSum(treeNode);
        System.out.println("Max Path Sum of the tree is: " + maxsum);
    }
}
