package leetcode.easy.binarytreedfs;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/14/16 10:19 AM
 */
public class Solution_Rec {

    public static void dfs(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args){
        //test case
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(11);
        node.right.left.left = new TreeNode(6);
        node.right.left.right = new TreeNode(12);
        node.right.left.left.left = new TreeNode(2);
        node.right.left.left.right = new TreeNode(8);
        node.right.right = new TreeNode(27);

        dfs(node);
    }
}
