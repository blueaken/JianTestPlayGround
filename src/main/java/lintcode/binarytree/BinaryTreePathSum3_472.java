package lintcode.binarytree;

import type.ParentTreeNode;
import util.ParentTreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum3_472 {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    //Idea: similar to graph traversal, ref: https://www.jianshu.com/p/babf3e50e180 & https://www.lintcode.com/problem/472/solution/16860
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, target, res);
        return res;
    }

    private void dfs (ParentTreeNode node, int target, List<List<Integer>> res) {
        if (node == null) return;
        //find all possible path of current node
        List<Integer> list = new ArrayList<>();
        findPath(node, null, target, list, res);

        dfs(node.left, target, res);
        dfs(node.right, target, res);
    }

    private void findPath (ParentTreeNode node, ParentTreeNode parent, int target, List<Integer> list, List<List<Integer>> res) {
        if (node == null) return;

        list.add(node.val);
        if (node.val == target) {
            res.add(new ArrayList<>(list));
        }

        // 类似图遍历算法，往 left、right、parent 三个方向遍历，
        // 通过判断 parent 指针是否等于 father 来判断是否出现往回遍历的情形
        // 当前结点指针往上遍历时，下一轮递归 root.parent 做根结点同样往三个方向遍历，如果往下就可能出现重复
        // 判断条件就是防止出现这种情况
        if (node.parent != null && node.parent != parent) {
            findPath(node.parent, node, target - node.val, list, res);
        }
        if (node.left != null && node.left != parent) {
            findPath(node.left, node, target - node.val, list, res);
        }
        if (node.right != null && node.right != parent) {
            findPath(node.right, node, target - node.val, list, res);
        }
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        int target = 6;
        ParentTreeNode root = ParentTreeNodeUtil.buildTree(input);
        ParentTreeNodeUtil.printTree(root);

        BinaryTreePathSum3_472 solution = new BinaryTreePathSum3_472();
        System.out.println(solution.binaryTreePathSum3(root, target).toString());
    }
}
