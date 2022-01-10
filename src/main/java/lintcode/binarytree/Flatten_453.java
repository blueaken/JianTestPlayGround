package lintcode.binarytree;

import type.TreeNode;

public class Flatten_453 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    //Idea: 不需要在做Preorder visit
    // 左子树非null的话，找到左子树前序遍历的最后一个node
    // 将右子树append到这个node
    // 左右子树交换，左子树为null
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) return;
        TreeNode node = root;
        while (node != null) {
            //process current node
            if (node.left != null) {
                TreeNode temp = node.left;
                node.left = null;
                TreeNode btn = temp;
                while (btn.right != null) {
                    btn = btn.right;
                }
                btn.right = node.right;
                node.right = temp;
            }
            node = node.right;
        }
        return;
    }
}
