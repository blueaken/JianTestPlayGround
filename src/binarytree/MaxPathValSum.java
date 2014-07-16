package binarytree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 7/15/14 10:23 下午
 */
public class MaxPathValSum {
    /*
     * a difficult one - see good solution here - http://blog.csdn.net/fightforyourdream/article/details/16894069
    */
    public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        rec(root, max);

        return max[0];
    }

    private static int rec(TreeNode root, int[] max){
        if (root == null) return 0;

        int leftSubMaxVal = rec(root.left, max);
        int rightSubMaxVal = rec(root.right, max);
        int archMaxVal = leftSubMaxVal + root.val + rightSubMaxVal;

        //find the max value of 4 max path candidates
        int maxPathAcrossRootToParent = Math.max(root.val, Math.max(leftSubMaxVal, rightSubMaxVal) + root.val);

        max[0] = Math.max(max[0], Math.max(archMaxVal, maxPathAcrossRootToParent));

        return maxPathAcrossRootToParent;
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        int maxsum = maxPathSum(treeNode);
        System.out.println("Max Path Sum of the tree is: " + maxsum);

        TreeNode treeNode1 = new TreeNode(0);
        maxsum = maxPathSum(treeNode1);
        System.out.println("Max Path Sum of zero tree node is: " + maxsum);
    }
}
