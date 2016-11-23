package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.inordersuccessor.third;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 6/29/16 17:43
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }

        //in case p has right child, inorder succ is leftmost of the right child
        if (p.right != null) {
            TreeNode node = p.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        //otherwise the leftmost parent is the inorder succ
        TreeNode leftParent = null;
        while (root != null) {
            if (root.val > p.val) {
                leftParent = root;
                root = root.left;
            } else if (root.val < p.val){
                root = root.right;
            } else {
                //found p
                break;
            }
        }
        return leftParent;
    }
}
