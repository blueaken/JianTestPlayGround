package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.validatebst;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/28/16 9:31 AM
 */
public class Solution_DC {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public static boolean isValidBST(TreeNode root) {
        // write your code here

        //top down Divide & Conquer
        return rec(root, null, null);
    }

    private static boolean rec(TreeNode node, Integer left, Integer right) {
        if (node == null) {
            return true;
        }

        if (left != null && node.val <= left || right != null && node.val >= right) {
            return false;
        }

        //divide && conquer
        return rec(node.left, left, node.val) && rec(node.right, node.val, right);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(10);
//        treeNode.left = new TreeNode(5);
//        treeNode.right = new TreeNode(15);
//        treeNode.right.left = new TreeNode(6);
//        treeNode.right.right = new TreeNode(20);

//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(1);

//        TreeNode treeNode = new TreeNode(2147483647);

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        System.out.println(isValidBST(treeNode));
    }
}
