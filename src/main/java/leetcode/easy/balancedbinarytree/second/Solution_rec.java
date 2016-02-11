package leetcode.easy.balancedbinarytree.second;

import leetcode.easy.maximumdepthofbinarytree.second.Solution;
import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/11/16 1:33 PM
 */
public class Solution_rec {
    public static boolean isBalanced(TreeNode node){
        if (node == null) return true;

        return Math.abs(Solution.maxDepth(node.left) - Solution.maxDepth(node.right)) < 2
                && isBalanced(node.left)
                && isBalanced(node.right);
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(11);
        node.right.left.left = new TreeNode(6);
        node.right.right = new TreeNode(27);

        System.out.println(isBalanced(node));
    }

}
