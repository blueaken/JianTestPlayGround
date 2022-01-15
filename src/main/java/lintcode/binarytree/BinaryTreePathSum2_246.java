package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum2_246 {

    int target;

    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        this.target = target;
        List<Integer> list = new ArrayList<>();

        rec(root, list, res);
        return res;
    }

    private void rec(TreeNode node, List<Integer> list, List<List<Integer>> res) {
        if (node == null) return;

        list.add(node.val);
        //method1: 从后面倒数计算是否满足
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i);
            if (sum == this.target) {
                res.add(new ArrayList<>(list.subList(i, list.size())));
            }
        }

        rec(node.left, list, res);
        rec(node.right, list, res);
        list.remove(list.size() - 1);
        return;
    }

    public static void main(String[] args) {
        int[] input = {1,-2,-999,1,-999,-999,-999,2};
        int target = 2;
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        BinaryTreePathSum2_246 solution = new BinaryTreePathSum2_246();
        System.out.println(solution.binaryTreePathSum2(root, target).toString());
    }
}
