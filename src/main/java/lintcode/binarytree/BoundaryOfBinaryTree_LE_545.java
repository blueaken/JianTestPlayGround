package lintcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import type.TreeNode;

public class BoundaryOfBinaryTree_LE_545 {
    /*
        同时考察了BinaryTree的Rec和Iterative遍历，设计的不错，但题目说明文字不太友好，第一次读很容易晕。
        Ref - https://leetcode.com/problems/boundary-of-binary-tree/solution/
    */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (!isLeaf(root)) { //leaf root node will be processed in getLeaveNodes method
            res.add(root.val);
        }
        getLeftBoundary(root.left, res);
        getLeaveNodes(root, res);
        getRightBoundarReverseOrder(root.right, res);

        return res;
    }

    private void getLeaveNodes(TreeNode node, List<Integer> res) {
        if (isLeaf(node)) {
            res.add(node.val);
        }
        if (node.left != null) {
            getLeaveNodes(node.left, res);
        }
        if (node.right != null) {
            getLeaveNodes(node.right, res);
        }
    }

    private void getLeftBoundary(TreeNode node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.val);
            }
            if (node.left != null) {
                node = node.left;
            } else { //node.right != null case
                node = node.right;
            }
        }

    }

    private void getRightBoundarReverseOrder(TreeNode node, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.val);
            }
            if (node.right != null) {
                node = node.right;
            } else { //node.left != null case
                node = node.left;
            }
        }

        while (stack.size() > 0) {
            res.add(stack.pop());
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
