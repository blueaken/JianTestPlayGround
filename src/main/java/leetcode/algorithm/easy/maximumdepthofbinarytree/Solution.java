package leetcode.algorithm.easy.maximumdepthofbinarytree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 9/24/15 8:28 AM
 */
public class Solution {
    public static int maxDepth(TreeNode root) {
        return rec (root);
    }

    static int rec(TreeNode node){
        if (node==null) return 0;
        return Math.max(rec(node.left), rec(node.right))+1;
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(11);
        node.right.left.left = new TreeNode(6);
        node.right.right = new TreeNode(27);

        System.out.println(maxDepth(node));
    }
}
