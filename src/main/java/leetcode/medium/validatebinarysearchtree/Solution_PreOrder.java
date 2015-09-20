package leetcode.medium.validatebinarysearchtree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 9/19/15 9:33 PM
 */
public class Solution_PreOrder {
    public static boolean isValidBST(TreeNode root) {
       return rec (root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean rec(TreeNode node, int left, int right){
        if (node == null) return true;

        if (node.val <= left || node.val >=  right){
            return false;
        }

        return rec(node.left, left, node.val) && rec(node.right, node.val, right);
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(11);
        node.right.left.left = new TreeNode(6);
        node.right.right = new TreeNode(27);

        System.out.println(isValidBST(node));
    }

}
