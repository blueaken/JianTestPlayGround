package lintcode.binarysearchtree;

import type.TreeNode;

public class DeleteNodeInBST_LE_450 {
    /**
     11.10.2022
     ref 东哥 post
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            // case when none or one of the child is null
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            //if both children not null, use the minNode of right child or maxNode of left child to replace root, use minNode here
            //we can replace value and it works here but not applicable in real world, where usually extis much more properties in the BST
            TreeNode minNode = getMinNode(root.right);
            root.right = deleteNode(root.right, minNode.val); //delete minNode from right child
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    TreeNode getMinNode (TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
