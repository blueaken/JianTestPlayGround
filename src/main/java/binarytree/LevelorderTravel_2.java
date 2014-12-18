package binarytree;

import type.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 7/13/14 6:03 下午
 */
public class LevelorderTravel_2 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> level = new ArrayList<Integer>();
        TreeNode node;

        int currentLevel = 1;
        int nextLevel = 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0){
            node = queue.remove();
            level.add(node.val);
            currentLevel --;

            if (node.left != null) {
                queue.add(node.left);
                nextLevel ++;
            }

            if (node.right != null) {
                queue.add(node.right);
                nextLevel ++;
            }

            if (currentLevel == 0){
                currentLevel = nextLevel;
                nextLevel = 0;
                result.add(level);
                level = new ArrayList<Integer>();
            }
        }

        List<List<Integer>> result2 = new ArrayList<List<Integer>>();
        for (int i=result.size()-1; i>=0; i--){
            result2.add(result.get(i));
        }

        return result2;
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(27);

        List<List<Integer>> result = levelOrderBottom(node);
        System.out.println(result);
    }
}
