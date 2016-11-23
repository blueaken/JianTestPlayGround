package leetcode.algorithm.easy.mindepthofbinarytree;

import type.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 2/10/16 10:31 AM
 */
public class Solution_BFS {
    public static int minDepth(TreeNode root) {
        if (root==null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode rightmost = root;
        int depth = 1;

        while (queue.size()>0){
            TreeNode node = queue.poll();
            if (node.left==null && node.right==null) return depth;
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
            if (node == rightmost){
                depth++;
                rightmost = (node.right!=null) ? node.right : node.left;
            }
        }

        return depth;
    }

    public static void main(String[] args){
        //normal case
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(11);
        node.right.left.left = new TreeNode(6);
        node.right.right = new TreeNode(27);

        //case of root left is null
//        TreeNode node = new TreeNode(10);
//        node.right = new TreeNode(15);
//        node.right.left = new TreeNode(11);
//        node.right.right = new TreeNode(27);

        System.out.println(minDepth(node));
    }
}
