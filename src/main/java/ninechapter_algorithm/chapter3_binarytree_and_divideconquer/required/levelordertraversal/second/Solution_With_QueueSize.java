package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.levelordertraversal.second;

import type.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 4/18/16 4:42 PM
 */
public class Solution_With_QueueSize {
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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }

        return result;
    }
}
