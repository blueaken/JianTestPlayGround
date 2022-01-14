package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePathSum_376 {

    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    //Idea: DFS, https://www.lintcode.com/problem/376/solution/17481

    public static List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<Integer> list = new ArrayList<>();
        rec(root, target, list, res);
        return res;
    }

    private static void rec(TreeNode node, int target, List<Integer> list, List<List<Integer>> res) {
        if (node == null) return;

        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        rec(node.left, target - node.val, list, res);
        rec(node.right, target - node.val, list, res);
        list.remove(list.size() - 1);
        return;
    }

    public static void main(String[] args) {
        int[] input = {1,2,4,2,3};
        int target = 5;
        TreeNode root = TreeNodeUtil.buildTree(input);

        System.out.println(binaryTreePathSum(root, target).toString());
    }

}
