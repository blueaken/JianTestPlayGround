package leetcode.binarytrees.binarytreemaximumpathsum.second;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/13/16 9:15 AM
 */
public class Solution {

    public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        rec(root, max);
        return max[0];
    }

    private static int rec(TreeNode node, int[] max){
        if (node == null) return 0;

        int maxLeft = rec(node.left, max);
        int maxRight = rec(node.right, max);
        int arch = maxLeft + node.val + maxRight;

        int maxArcossRoot = Math.max(Math.max(maxLeft, maxRight) + node.val, node.val);
        max[0] = Math.max(Math.max(arch, maxArcossRoot), max[0]);

        return maxArcossRoot;
    }


    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);

        int maxsum = maxPathSum(treeNode);
        System.out.println("Max Path Sum of the tree is: " + maxsum);
    }
}
