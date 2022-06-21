package lintcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import type.TreeNode;
import util.TreeNodeUtil;

public class BoundaryOfBinaryTree_LE_545_P1 {
    /*
        - Need both recursive and iterative traverse to solve, nice design, but poor description. Easy to confuse when read first time.
        Ref - https://leetcode.com/problems/boundary-of-binary-tree/solution/
    */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (!isLeaf(root)) { //leaf nodes is taken care below
            res.add(root.val);
        }
        getLeftBoundary(root.left, res);
        getLeafNodes(root, res);
        getRightBoundaryReverseOrder(root.right, res);
        return res;
    }

    private void getLeftBoundary(TreeNode node, List<Integer> res) {
        while (node != null && !isLeaf(node)) {
            res.add(node.val);
            if (node.left != null) {
                node = node.left;
            } else {//node.left is null case
                node = node.right;
            }
        }
    }

    private void getRightBoundaryReverseOrder(TreeNode node, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        while (node != null && !isLeaf(node)) {
            stack.push(node.val);
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        while (stack.size() > 0) {
            res.add(stack.pop());
        }
    }

    private void getLeafNodes (TreeNode node, List<Integer> res) {
        if (isLeaf(node)) {
            res.add(node.val);
        }
        if (node.left != null) {
            getLeafNodes(node.left, res);
        }
        if (node.right != null) {
            getLeafNodes(node.right, res);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,-999,-999,-999,7,8,9,10};//[1,2,4,7,8,9,10,6,3]
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        BoundaryOfBinaryTree_LE_545_P1 solution = new BoundaryOfBinaryTree_LE_545_P1();
        System.out.println(solution.boundaryOfBinaryTree(root));
    }
}
