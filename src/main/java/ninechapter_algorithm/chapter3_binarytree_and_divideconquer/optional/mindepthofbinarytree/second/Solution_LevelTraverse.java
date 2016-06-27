package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.mindepthofbinarytree.second;

import type.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 6/27/16 09:48
 */
public class Solution_LevelTraverse {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        //bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        TreeNode rightmost = root;

        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            //stop loop on first leaf node
            if (node.left == null && node.right == null) {
                break;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            if (node == rightmost) {
                level++;
                rightmost = node.right != null ? node.right : node.left;
            }
        }

        return level;
    }

    public static void main(String[] args) {
        Solution_LevelTraverse solution = new Solution_LevelTraverse();

        //expect 2
//        TreeNode node = new TreeNode(10);
//        node.left = new TreeNode(5);
//        node.right = new TreeNode(15);
//        node.right.left = new TreeNode(13);
//        node.right.right = new TreeNode(17);

        //expect 1
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);

        System.out.println(solution.minDepth(node));
    }
}
