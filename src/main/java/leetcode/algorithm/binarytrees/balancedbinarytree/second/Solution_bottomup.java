package leetcode.algorithm.binarytrees.balancedbinarytree.second;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/11/16 1:52 PM
 */
public class Solution_bottomup {
    public static boolean isBalanced(TreeNode node){
        return maxDepth(node) != -1;
    }

    private static int maxDepth(TreeNode node){
        if (node ==  null) return 0;

        int lh = maxDepth(node.left);
        if (lh == -1) return -1;

        int rh = maxDepth(node.right);
        if (rh == -1) return -1;

        return (Math.abs(lh-rh) < 2) ? 1 + Math.max(lh, rh) : -1;
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(11);
        node.right.left.left = new TreeNode(6);
        node.right.right = new TreeNode(27);

        System.out.println(isBalanced(node));
    }

}
