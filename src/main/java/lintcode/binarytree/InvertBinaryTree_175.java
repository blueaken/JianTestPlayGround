package lintcode.binarytree;

import type.TreeNode;

public class InvertBinaryTree_175 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    //Idea: PreOrder visit
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) return;
        //switch Subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            invertBinaryTree(root.left);
        }
        if (root.right != null) {
            invertBinaryTree(root.right);
        }

        return;
    }
}
