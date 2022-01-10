package lintcode.binarytree;

import type.TreeNode;

import java.util.Stack;

public class InvertBinaryTree_Interactive_175 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    //Idea: PreOrder visit
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            //switch Subtrees
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return;
    }
}
