package leetcode.algorithm.binarytrees.minimumdepthofbinarytree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 9/25/15 8:09 AM
 */
public class Solution {
    public static int minDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null) return minDepth(root.right) + 1;
        if (root.right==null) return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) +1 ;
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(11);
        node.right.left.left = new TreeNode(6);
        node.right.right = new TreeNode(27);

        System.out.println(minDepth(node));
    }
}
