package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum2_method2_246 {

    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    //ref: https://blog.csdn.net/wat1r/article/details/118554122
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> list = new ArrayList<>();

        rec(root, target, list, res, true);
        return res;
    }

    private void rec(TreeNode node, int target, List<Integer> list, List<List<Integer>> res, boolean fromRoot) {
        if (node == null) return;

        list.add(node.val);
        //method2: 从根节点来的List从左右子树开始重新计算
        if (node.val == target) {
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        rec(node.left, target - node.val, list, res, false);
        rec(node.right, target - node.val, list, res, false);

        if (fromRoot) {
            rec(node.left, target, new ArrayList<>(), res, true);
            rec(node.right, target, new ArrayList<>(), res, true);
        }

        list.remove(list.size() - 1);
        return;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,-999,-999,-999,2};
        int target = 6;
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        BinaryTreePathSum2_method2_246 solution = new BinaryTreePathSum2_method2_246();
        System.out.println(solution.binaryTreePathSum2(root, target).toString());
    }
}
