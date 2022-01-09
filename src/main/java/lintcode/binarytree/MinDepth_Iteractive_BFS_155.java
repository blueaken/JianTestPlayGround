package lintcode.binarytree;

import type.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth_Iteractive_BFS_155 {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    //Key Idea: Iterative solution with BFS, return current level when the first leaf node visited
    public static int minDepth(TreeNode root) {
        // write your code here
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int level = 0;

        while (queue.size() > 0) {
            level++;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (isLeaf(node)) {
                    return level;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return -1;
    }

    private static boolean isLeaf (TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(minDepth(root));
    }
}
