package leetcode.easy.balancedbinarytree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 9/27/15 7:41 PM
 */
public class Solution {
    public static boolean isBalanced(TreeNode node){
        if (node==null) return true;
        return Math.abs(maxDepth(node.left) - maxDepth(node.right))<2
                && isBalanced(node.left)
                && isBalanced(node.right);
    }

    public static int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
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
