package leetcode.easy.binarytreedfs;

import type.TreeNode;

import java.util.Stack;

/**
 * Author: blueaken
 * Date: 2/14/16 10:10 AM
 */
public class Solution_Ite {
    public static void dfs(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (stack.size()>0){
            TreeNode node = stack.pop();
            System.out.println(node.val + " ");

            if (node.right != null){
                stack.push(node.right);
            }

            if (node.left != null){
                stack.push(node.left);
            }
        }
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
