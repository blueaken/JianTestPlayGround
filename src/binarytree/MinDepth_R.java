package binarytree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 7/15/14 8:21 下午
 */
public class MinDepth_R {
    public static int minDepth(TreeNode root) {
        return rec(root);
    }

    private static int rec(TreeNode root){
        //similar to find the height of a tree, but note the situation when root itself cannot be the leaf node
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        if (root.left == null) return 1 + rec(root.right);

        if (root.right == null) return 1 + rec(root.left);

        return 1 + Math.min(rec(root.left), rec(root.right));
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);

        int md = minDepth(treeNode);
        System.out.println("Min Depth of the tree is: " + md);
    }
}
