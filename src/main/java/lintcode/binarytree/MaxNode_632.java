package lintcode.binarytree;

import type.TreeNode;

public class MaxNode_632 {
    TreeNode maxNode = new TreeNode(Integer.MIN_VALUE);
    /*
     * @param root: the root of tree
     * @return: the max node
     */
    //Idea: Pre Order Access
    public TreeNode maxNode(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }

        preOrder(root);
        return maxNode;
    }

    private void preOrder (TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.val > maxNode.val) {
            maxNode = node;
        }
        preOrder (node.left);
        preOrder (node.right);
    }
}
