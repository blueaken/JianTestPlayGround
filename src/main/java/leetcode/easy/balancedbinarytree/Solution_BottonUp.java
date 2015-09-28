package leetcode.easy.balancedbinarytree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 9/27/15 8:20 PM
 */
public class Solution_BottonUp {
    public static boolean isBalanced(TreeNode node){
        return maxDepth(node)!=-1;
    }

    public static int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int L = maxDepth(root.left);
        if (L==-1) return -1;
        int R = maxDepth(root.right);
        if (R==-1) return -1;

        return Math.abs(L-R)>1 ? -1 : Math.max(L, R)+1;
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(11);
//        node.right.left.left = new TreeNode(6);
        node.right.right = new TreeNode(27);

        System.out.println(isBalanced(node));
    }
}
