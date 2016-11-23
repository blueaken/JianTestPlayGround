package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.completebinarytree;

import type.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 4/21/16 3:04 PM
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

        //first traverse to get the number of nodes
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            count++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        //second traverse to find if tree is complete
        int cur = 0;
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node == null) {
                return cur == count;
            }
            cur++;
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return true;
    }
}
