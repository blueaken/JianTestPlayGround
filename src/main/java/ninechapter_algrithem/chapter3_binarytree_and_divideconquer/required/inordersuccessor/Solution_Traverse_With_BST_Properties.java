package ninechapter_algrithem.chapter3_binarytree_and_divideconquer.required.inordersuccessor;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/28/16 8:15 PM
 */
public class Solution_Traverse_With_BST_Properties {
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode successor = null;
        //1. found p and save successor position when p has no right child
        while (root != null && root != p) {
            if (root.val < p.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return successor;
        }

        //2. found successor when p has right child
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);

        TreeNode target = new TreeNode(3);
        treeNode.right = target;
        treeNode.right.right = new TreeNode(6);

        System.out.println(inorderSuccessor(treeNode, target).val);
    }
}
