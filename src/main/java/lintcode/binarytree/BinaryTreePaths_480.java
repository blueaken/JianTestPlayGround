package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_480 {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        String path = "";
        dfs (root, path, res);
        return res;
    }

    private void dfs (TreeNode node, String path, List<String> res) {
        if (node == null) {
            return;
        }
        path = path + node.val + "->";
        if (node.left == null && node.right == null) {
            res.add(path.substring(0, path.length()-2));
            return;
        }
        dfs(node.left, path, res);
        dfs(node.right, path, res);
    }

    public static void main(String[] args) {
        BinaryTreePaths_480 solution = new BinaryTreePaths_480();
        int[] input = {0,1,-999,3,2};
        TreeNode root = TreeNodeUtil.buildTree(input);
        System.out.println(solution.binaryTreePaths(root));
    }
}
