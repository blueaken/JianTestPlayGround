package leetcode.algorithm.binarytrees.validatebinarysearchtree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 9/20/15 10:43 AM
 */
public class Solution_BruteForce {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isSubtreeLessThan(root.left, root.val)
                && isSubtreeGreaterThan(root.right, root.val)
                && isValidBST(root.left) && isValidBST(root.right);
    }
    private static boolean isSubtreeLessThan(TreeNode p, int val) {
        if (p == null) return true;
        return p.val < val
                && isSubtreeLessThan(p.left, val)
                && isSubtreeLessThan(p.right, val);
    }
    private static boolean isSubtreeGreaterThan(TreeNode p, int val) {
        if (p == null) return true;
        return p.val > val
                && isSubtreeGreaterThan(p.left, val)
                && isSubtreeGreaterThan(p.right, val);
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
