package leetcode.binarytrees.validatebinarysearchtree.second;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/7/16 9:59 AM
 */
public class Solution {

    public static boolean isValidBST(TreeNode root) {
        return rec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean rec(TreeNode node, int low, int high){
        if (node==null) return true;

        return node.val>low && node.val<high
                && rec(node.left, low, node.val)
                && rec(node.right, node.val, high);
    }

    public static void main(String[] args){
//        TreeNode node = new TreeNode(10);
//        node.left = new TreeNode(5);
//        node.right = new TreeNode(15);
//        node.right.left = new TreeNode(11);
//        node.right.left.left = new TreeNode(6);
//        node.right.right = new TreeNode(27);

        //tc [10,5,15,null,null,6,20]
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(20);

        System.out.println(isValidBST(node));
    }
}
