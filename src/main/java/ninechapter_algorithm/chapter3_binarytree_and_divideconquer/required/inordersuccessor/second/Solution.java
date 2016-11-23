package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.inordersuccessor.second;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/19/16 9:29 AM
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }

        TreeNode node = root;
        TreeNode leftParent = null;
        while (node != null) {
            if (node.val > p.val) {
                //record left parent in case p has no right child
                leftParent = node;
                node = node.left;
            } else if (node.val < p.val) {
                node = node.right;
            } else{
                //found p
                if (p.right != null) {
                    node = p.right;
                    while (node.left != null) {
                        node = node.left;
                    }
                    return node;
                }
                if (leftParent != null) {
                    return leftParent;
                }
                return null;
            }
        }
        return null;
    }
}
