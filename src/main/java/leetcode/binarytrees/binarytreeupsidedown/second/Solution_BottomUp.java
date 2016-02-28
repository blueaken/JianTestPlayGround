package leetcode.binarytrees.binarytreeupsidedown.second;

import type.TreeNode;
import realworld.emc.printbinarysearchtree.Solution;

/**
 * Author: blueaken
 * Date: 2/14/16 10:30 AM
 */
public class Solution_BottomUp {

    public static TreeNode UpsideDownBinaryTree(TreeNode root) {
        return dfsBottomUp(root, null);
    }

    private static TreeNode dfsBottomUp(TreeNode node, TreeNode parent){
        if (node == null) return parent;

        TreeNode root = dfsBottomUp(node.left, node);
        node.left = parent == null ? parent : parent.right;
        node.right = parent;

        return root;
    }


    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        node = UpsideDownBinaryTree(node);

        Solution.printBinaryTree(node);
    }

}
