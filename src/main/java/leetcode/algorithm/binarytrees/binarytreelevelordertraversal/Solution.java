package leetcode.algorithm.binarytrees.binarytreelevelordertraversal;

import type.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 2/10/16 11:41 AM
 */
public class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 1;
        int nextLevel = 0;

        List<Integer> level = new ArrayList<>();
        while (queue.size()>0){
            TreeNode node = queue.poll();
            level.add(node.val);
            currentLevel--;

            if (node.left != null){
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null){
                queue.add(node.right);
                nextLevel++;
            }

            if (currentLevel == 0){
                result.add(level);
                level = new ArrayList<>();
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }

        return result;
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

        System.out.println(levelOrder(node));
    }
}
