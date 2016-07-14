package leetcode.algorithm.binarytrees.minimumdepthofbinarytree;

import type.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 9/25/15 8:18 AM
 */
public class Solution_LevelAccess {
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode rightMost = root;
        int minDepth = 1;
        while (queue.size()!=0){
            TreeNode node = queue.poll();
            if (node.left==null && node.right==null) {
                break;
            }
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
            if (node == rightMost) {
                minDepth++;
                rightMost = (node.right == null) ? node.left : node.right;
            }
        }

        return minDepth;

    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(11);
        node.right.left.left = new TreeNode(6);
        node.right.right = new TreeNode(27);

        System.out.println(minDepth(node));
    }
}
