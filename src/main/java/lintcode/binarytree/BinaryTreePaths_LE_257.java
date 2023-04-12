package lintcode.binarytree;

import type.TreeNode;

import java.util.LinkedList;
import java.util.List;


public class BinaryTreePaths_LE_257 {
    LinkedList<String> res = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        rec(root);
        return res;
    }

    private void rec(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            path.addLast(String.valueOf(root.val));
            res.add(String.join("->", path));
            path.removeLast();
            return;
        }

        // 前序位置添加element
        path.addLast(String.valueOf(root.val));

        rec(root.left);
        rec(root.right);

        // 后序位置删除element, 回溯法
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreePaths_LE_257 solution = new BinaryTreePaths_LE_257();
        System.out.println(solution.binaryTreePaths(root));
    }
}
