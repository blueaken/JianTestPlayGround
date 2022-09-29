package lintcode.binarytree;

import type.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class BoundaryOfBinaryTree_LE_545_P2 {
    /*
        P2
        - use 3 dfs methods handling left, leaf & right seperately
    */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (!isLeaf(root)) {
            res.add(root.val);
        }

        getLeftBoundary(root.left, res);
        getLeaf(root, res);
        getRightBoundaryRev(root.right, res);

        return res;
    }

    private void getLeftBoundary(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.val);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        // if (!isLeaf(node)) {
        //     res.add(node.val);
        // }
        // if (node.left != null) {
        //     getLeftBoundary(node.left, res);
        // } else if (node.right != null) {
        //     getLeftBoundary(node.right, res);
        // }
    }

    private void getLeaf(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (isLeaf(node)) {
            res.add(node.val);
        }
        getLeaf(node.left, res);
        getLeaf(node.right, res);

    }

    private void getRightBoundaryRev(TreeNode node, List<Integer> res) {

        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.val);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        while (stack.size() > 0) {
            res.add(stack.pop());
        }

        return;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
