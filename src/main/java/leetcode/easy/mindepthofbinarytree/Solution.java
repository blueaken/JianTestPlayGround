package leetcode.easy.mindepthofbinarytree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/10/16 10:20 AM
 */
public class Solution {
    public static int minDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null) return 1+minDepth(root.right);
        if (root.right==null) return 1+minDepth(root.left);
        return 1+Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void main(String[] args){
        //normal tc
//        TreeNode node = new TreeNode(10);
//        node.left = new TreeNode(5);
//        node.right = new TreeNode(15);
//        node.right.left = new TreeNode(11);
//        node.right.left.left = new TreeNode(6);
//        node.right.right = new TreeNode(27);

        //case of root left is null
        TreeNode node = new TreeNode(10);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(11);
        node.right.right = new TreeNode(27);

        System.out.println(minDepth(node));
    }
}
