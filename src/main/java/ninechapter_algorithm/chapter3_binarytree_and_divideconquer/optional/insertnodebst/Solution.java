package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.insertnodebst;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/19/16 4:30 PM
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            root = node;
            return root;
        }
        if (node == null) {
            return root;
        }

        TreeNode p = root;
        while (p != null) {
            if (p.val < node.val) {
                if (p.right != null) {
                    p = p.right;
                } else {
                    p.right = node;
                    break;
                }
            } else {
                if (p.left != null) {
                    p = p.left;
                } else {
                    p.left = node;
                    break;
                }
            }
        }

        return root;
    }
}
