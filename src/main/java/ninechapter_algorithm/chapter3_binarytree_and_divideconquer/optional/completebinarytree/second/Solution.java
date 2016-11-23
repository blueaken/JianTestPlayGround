package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.completebinarytree.second;

import type.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 6/28/16 11:18
 */
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // Write your code here
        if (root == null) {
            return true;
        }

        //1st traverse to get total node num
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode current = queue.poll();
            count++;
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        //2nd traverse to tell if tree is complete via node number
        int currentNum = 0;
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode current = queue.poll();
            if (current == null) {
                return currentNum == count;
            }
            currentNum++;
            queue.offer(current.left);
            queue.offer(current.right);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
