package leetcode.medium.binarytreeupsidedown;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 10/2/15 6:52 AM
 */
public class Solution {
    public static TreeNode UpsideDownBinaryTree(TreeNode root) {
        return dfsBottomUp(root, null);
    }

    static TreeNode dfsBottomUp(TreeNode node, TreeNode parent){
        if (node == null) return parent;
        TreeNode newRoot = dfsBottomUp(node.left, node);
        node.left = (parent==null ? parent : parent.right);
        node.right = parent;

        return newRoot;
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node = UpsideDownBinaryTree(node);
        System.out.println(node);
    }
}
