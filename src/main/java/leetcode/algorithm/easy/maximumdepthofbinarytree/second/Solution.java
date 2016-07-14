package leetcode.algorithm.easy.maximumdepthofbinarytree.second;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/9/16 9:24 AM
 */
public class Solution {

    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
