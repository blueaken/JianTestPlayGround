package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.required.maxdepth;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/16/16 9:39 AM
 */
public class Solution_Traverse {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public static int maxDepth(TreeNode root) {
        // write your code here
        int[] max = new int[1];

        rec(root, 1, max);
        return max[0];
    }

    private static void rec(TreeNode node, int depth, int[] max) {
        if (node == null) {
            return;
        }
        max[0] = Math.max(depth, max[0]);

        rec(node.left, depth + 1, max);
        rec(node.right, depth + 1, max);
    }

    public static void main(String[] args) {
        //expect 2
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        //expect 3
//        TreeNode node = new TreeNode(10);
//        node.left = new TreeNode(5);
//        node.right = new TreeNode(15);
//        node.right.left = new TreeNode(13);
//        node.right.right = new TreeNode(17);

        System.out.println(maxDepth(node));
    }
}
