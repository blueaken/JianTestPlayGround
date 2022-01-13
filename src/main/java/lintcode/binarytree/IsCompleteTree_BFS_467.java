package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree_BFS_467 {
    //Idea: BFS and 当出现 null 值时停止遍历，如果此时还有没有遍历到的非空结点，说明该树非完全二叉树
    //Ref: https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/comments/
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while ((node = queue.poll()) != null) {
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (queue.size() > 0) {
            if (queue.poll() != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,5,-999,7,8};
        TreeNode root = TreeNodeUtil.buildTree(input);

        System.out.println(isCompleteTree(root));
    }

}
