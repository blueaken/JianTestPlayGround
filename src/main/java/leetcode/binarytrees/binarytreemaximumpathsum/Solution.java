package leetcode.binarytrees.binarytreemaximumpathsum;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 9/30/15 3:46 PM
 */
public class Solution {
    public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        rec(root, max);

        return max[0];
    }

    static int rec(TreeNode node, int[] max){
        if (node==null) return 0;

        int leftSubMax = rec(node.left, max);
        int rightSubMax = rec(node.right, max);
        int archMax = leftSubMax + node.val + rightSubMax;

        int maxAcrossRoot =  Math.max(node.val, Math.max(leftSubMax, rightSubMax) + node.val);
        max[0] = Math.max(max[0], Math.max(archMax, maxAcrossRoot));

        return maxAcrossRoot;
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
