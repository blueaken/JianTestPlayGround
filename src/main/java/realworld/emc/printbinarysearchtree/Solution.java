package realworld.emc.printbinarysearchtree;

import type.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 2/10/16 10:49 AM
 */
public class Solution {
    public static void printBinaryTree(TreeNode root) {
        if (root == null) System.out.println("Input node is null");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 1;
        int nextLevel = 0;

        while (queue.size()>0){
            TreeNode node = queue.poll();
            System.out.print(node.val);
            System.out.print(" ");
            currentLevel--;

            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }

            if (currentLevel == 0){
                System.out.println();
                currentLevel = nextLevel;
                nextLevel = 0;
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

        printBinaryTree(node);
    }
}
