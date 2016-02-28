package leetcode.binarytrees.validatebinarysearchtree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 9/20/15 9:39 AM
 */
public class Solution_InOrder {
    private static TreeNode prev = null;
    public static boolean isValidBST(TreeNode root) {
        //prev = null;
        return isMonotonicIncreasing(root);
    }
    private static boolean isMonotonicIncreasing(TreeNode p) {
        if (p == null) return true;
        if (isMonotonicIncreasing(p.left)) {
            if (prev != null && p.val <= prev.val) return false;
            prev = p;
            return isMonotonicIncreasing(p.right);
        }
        return false;
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
