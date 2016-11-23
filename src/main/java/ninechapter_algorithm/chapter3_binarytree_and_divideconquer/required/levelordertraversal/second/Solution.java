package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.levelordertraversal.second;

import type.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 4/18/16 4:24 PM
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        //init 1st level data
        int level = 0;
        int nextlevel = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        level++;

        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            list.add(node.val);
            level--;

            if (node.left != null) {
                queue.offer(node.left);
                nextlevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextlevel++;
            }

            if (level == 0) {
                result.add(list);
                list = new ArrayList<>();
                level = nextlevel;
                nextlevel = 0;
            }
        }
        return result;
    }
}
